package nl.arnokoehler.dev.akif.cli

import freemarker.template.Configuration
import java.io.StringWriter

class FileCreator {

    private val templateResolver = TemplateResolver()

    fun writeFile(resourceName: String, packageName: String, languageVariant: LanguageVariant?, variantStyle: String?) {
        val resolvedTemplates = templateResolver.resolveTemplates(languageVariant)

        for (resolvedTemplate in resolvedTemplates) {
            val template = processTemplate(resolvedTemplate.value, resourceName, packageName)
            println("Creating folder structure: $packageName")
            println("Writing file: ${resolvedTemplate.key}.kt")
            println(template.toString())
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
}