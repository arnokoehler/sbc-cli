package nl.arnokoehler.dev.akif.cli

import kotlin.system.exitProcess

class CommanLineInterfaceApplication (
    private var languageVariant: LanguageVariant?,
    private var variantStyle: String?,
    private var resourceName: String,
    private var packageName: String,
    private val targetDir: String
) {

    fun menuOptions() {
        while (true) {
            println("Please select an option:")
            println("1. Create resource")
            println("2. Exit")
            when (readlnOrNull() ?: "2") {
                "1" -> createResource()
                "2" -> exitProcess(0)
                else -> println("Please select a valid option")
            }
        }
    }

    private fun createResource() {
        if(languageVariant == null) {
            println("Please provide a language variant: kotlin or java")
            for (value in LanguageVariant.values()) {
                println("${value.ordinal+1} ${value.name}")
            }

            languageVariant = LanguageConverter().convert(readlnOrNull() ?: "kotlin")
            println("language set to: $languageVariant")
        }
        if (resourceName.isEmpty()) {
            println("Please provide a resource name")
            val resourceName = readlnOrNull() ?: throw IllegalArgumentException("Resource name cannot be empty")
            println("resource name set to: $resourceName")
        }

        if (packageName.isEmpty()) {
            println("Please provide a package name")
            packageName = readlnOrNull() ?: throw IllegalArgumentException("Package name cannot be empty")
            println("package name set to: $packageName")
        }
        println("This will generate the resources in the following language: $languageVariant for the resource: $resourceName")
        FileCreator().writeFile(
            resourceName,
            packageName,
            languageVariant,
            variantStyle,
            targetDir
        )
    }

}