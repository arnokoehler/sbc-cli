package nl.arnokoehler.dev.akif.cli

import freemarker.template.Configuration
import org.apache.commons.lang3.StringUtils
import java.io.File
import java.io.StringWriter
import java.util.*
import kotlin.collections.HashMap


class FileCreator {

    private val templateResolver = TemplateResolver()

    fun writeFile(applicationParameters: ApplicationParameters) {
        val resolvedTemplates = templateResolver.resolveTemplates(applicationParameters.languageVariant)

        val (sourceFolder, folderAlreadyExists: Boolean) = createFolders(
            applicationParameters.packageName,
            applicationParameters.targetDir
        )

        if (checkIfCanBeOverwritten(folderAlreadyExists)) {
            println("Aborting")
            return
        }

        for (resolvedTemplate in resolvedTemplates) {
            val template = processTemplate(
                resolvedTemplate.value,
                applicationParameters
            )

            val filename = resolveFileName(applicationParameters.resourceName, resolvedTemplate.key)
            template.toFile(sourceFolder, filename)
            println("Created file: $filename")
        }
    }

    private fun processTemplate(templateName: String, applicationParameters: ApplicationParameters): StringWriter {
        val cfg = Configuration(Configuration.VERSION_2_3_28)
        cfg.defaultEncoding = "UTF-8"
        cfg.templateLoader = freemarker.cache.ClassTemplateLoader(CliRunner::class.java.classLoader, "templates")
        val template = cfg.getTemplate(templateName)
        val data = HashMap<String, Any>()

        data["resourceName"] = applicationParameters.resourceName
        data["resourceNamePlural"] = applicationParameters.resourceName.pluralize()
        data["resourceNameUppercase"] = applicationParameters.resourceName.capitalize()
        data["idType"] = applicationParameters.idType
        data["packageName"] = applicationParameters.packageName

        val writer = StringWriter()
        template.process(data, writer)
        return writer
    }

    private fun checkIfCanBeOverwritten(isFolderCreatedSuccessfully: Boolean): Boolean {
        if (!isFolderCreatedSuccessfully) {
            println("Folder structure already exists, contents will be overwritten")
            println("Do you want to continue? (y/n)")
            val answer = readlnOrNull() ?: "n"
            if (answer != "y") {
                println("Exiting")
                return true
            }
        }
        return false
    }

    private fun createFolders(packageName: String, targetDir: String): Pair<String, Boolean> {
        println("Creating folder structure: $packageName")
        val sourceFolder = StringUtils.stripEnd(targetDir, "/") + "/" + StringUtils.stripStart(
            StringUtils.replaceChars(
                packageName,
                ".",
                "/"
            ), "/"
        )
        val resultMkdir: Boolean = File(sourceFolder).mkdirs()
        return Pair(sourceFolder, resultMkdir)
    }

    private fun resolveFileName(
        resourceName: String,
        templateName: String
    ) = "${resourceName}$templateName.kt"

}

fun String.capitalize() = this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

fun StringWriter.toFile(path: String, filename: String) {
    File("${path}/${filename}.kt").writeBytes(this.toString().toByteArray())
}