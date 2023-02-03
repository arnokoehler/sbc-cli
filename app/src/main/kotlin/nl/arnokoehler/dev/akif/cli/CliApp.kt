package nl.arnokoehler.dev.akif.cli

import freemarker.template.Configuration
import java.io.StringWriter

class CliApp(private val args: Array<String>) {

    fun writeFile(): String {
        val cfg = Configuration(Configuration.VERSION_2_3_28)
        cfg.defaultEncoding = "UTF-8"
        cfg.templateLoader = freemarker.cache.ClassTemplateLoader(CliApp::class.java.classLoader, "templates")
        val template = cfg.getTemplate("template-crud-controller.ftl")
        val data = HashMap<String, Any>()
        data["domainName"] = args[0]
        val writer = StringWriter()
        template.process(data, writer)
        return writer.toString()
    }

}

fun main(args: Array<String>) {

    println(CliApp(args).writeFile())

}