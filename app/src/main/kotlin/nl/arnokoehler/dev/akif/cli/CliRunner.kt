package nl.arnokoehler.dev.akif.cli

import com.beust.jcommander.JCommander
import com.beust.jcommander.Parameter

class CliRunner() {

    @Parameter(
        names = ["-resourceName"],
        description = "The name of the resource to generate"
    )
    private var resourceName: String = ""

    @Parameter(
        names = ["-variantStyle"],
        description = "The name of the resource to generate"
    )
    private var variantStyle: String? = null

    @Parameter(
        names = ["-languageVariant"],
        description = "Kotlin or Java",
        converter = LanguageConverter::class
    )
    private var languageVariant: LanguageVariant? = null

    @Parameter(
        names = ["-packageName"],
        description = "The name of the resource to generate"
    )
    private var packageName: String = ""

    fun run() {
        CommanLineInterfaceApplication(
            languageVariant = languageVariant,
            variantStyle = variantStyle,
            resourceName = resourceName,
            packageName = packageName
        ).menuOptions()
    }
}

fun main(args: Array<String>) {
    val cliRunner = CliRunner()
    JCommander.newBuilder()
        .addObject(cliRunner)
        .build()
        .parse(*args)
    cliRunner.run()
}


