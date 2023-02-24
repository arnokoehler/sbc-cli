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
    private var variantStyle: StyleVariant? = null

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

    @Parameter(
        names = ["-targetDir"],
        description = "The name of the resource to generate"
    )
    private var targetDir: String =
        "/Users/arnokoehler/Documents/Intellij/iodigital-com/sbc-cli/build/generated-sources/kotlin/main"

    fun run() {
        Menu(RawInput(
            languageVariant = languageVariant,
            variantStyle = variantStyle,
            resourceName = resourceName,
            packageName = packageName,
            targetDir = targetDir
        ), FileCreator()).execute()
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

