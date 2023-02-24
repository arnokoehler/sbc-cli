package nl.arnokoehler.dev.akif.cli

import com.beust.jcommander.JCommander
import com.beust.jcommander.Parameter

class CliRunner {

    @Parameter(
        names = ["-resourceName"],
        description = "The name of the resource to generate"
    )
    private var resourceName: String? = null

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
    private var packageName: String? = null

    @Parameter(
        names = ["-idType"],
        description = "The name type of the Id",
        converter = ResourceIdTypeConverter::class
    )
    private var idType: ResourceIdType? = null

    @Parameter(
        names = ["-initializr"],
        description = "Path to a Spring Initializr ZIP file to use as starting point"
    )
    private var initializr: String? = null

    @Parameter(
        names = ["-targetDir"],
        description = "The name of the resource to generate"
    )
    private var targetDir: String? = null

    fun run() {
        Menu(
            RawInput(
                languageVariant = languageVariant,
                variantStyle = variantStyle,
                resourceName = resourceName,
                packageName = packageName,
                initializrZip = initializr,
                idType = idType,
                targetDir = targetDir
            ), FileCreator()
        ).execute()
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

