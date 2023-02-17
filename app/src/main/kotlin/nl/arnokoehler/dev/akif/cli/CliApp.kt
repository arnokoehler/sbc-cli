package nl.arnokoehler.dev.akif.cli

import com.beust.jcommander.JCommander
import com.beust.jcommander.Parameter
import freemarker.template.Configuration
import java.io.StringWriter

class CliApp() {

    @Parameter(
        names = ["-resourceName"],
        description = "The name of the resource to generate"
    )
    private var resourceName: String = ""

    fun writeFile() {
        val controller = processTemplate("kotlin/template-crud-controller.ftl", resourceName)
        println(controller.toString())
        val service = processTemplate("kotlin/template-crud-repository.ftl", resourceName)
        println(service.toString())
        val repository = processTemplate("kotlin/template-crud-service.ftl", resourceName)
        println(repository.toString())
    }

    private fun processTemplate(templateName: String, resourceName: String): StringWriter {
        val cfg = Configuration(Configuration.VERSION_2_3_28)
        cfg.defaultEncoding = "UTF-8"
        cfg.templateLoader = freemarker.cache.ClassTemplateLoader(CliApp::class.java.classLoader, "templates")
        val template = cfg.getTemplate(templateName)
        val data = HashMap<String, Any>()
        data["resourceName"] = resourceName
        val writer = StringWriter()
        template.process(data, writer)
        return writer
    }
}

fun main(args: Array<String>) {
    val cliApp = CliApp()
    JCommander.newBuilder()
        .addObject(cliApp)
        .build()
        .parse(*args)
    cliApp.writeFile()
}
