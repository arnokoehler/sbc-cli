package nl.arnokoehler.dev.akif.cli

import freemarker.template.Configuration
import org.apache.commons.lang3.StringUtils
import java.io.File
import java.io.StringWriter


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
                applicationParameters.resourceName,
                applicationParameters.packageName
            )

            println("Writing file: ${resolvedTemplate.key}.kt")
            File("$sourceFolder/${resolvedTemplate.key}.kt").writeBytes(template.toString().toByteArray())
        }
    }

    private fun processTemplate(templateName: String, resourceName: String, packageName: String): StringWriter {
        val cfg = Configuration(Configuration.VERSION_2_3_28)
        cfg.defaultEncoding = "UTF-8"
        cfg.templateLoader = freemarker.cache.ClassTemplateLoader(CliRunner::class.java.classLoader, "templates")
        val template = cfg.getTemplate(templateName)
        val data = HashMap<String, Any>()
        data["resourceName"] = resourceName
        data["packageName"] = packageName
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


}