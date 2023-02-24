package nl.arnokoehler.dev.akif.cli

import kotlin.system.exitProcess

class Menu(val applicationParameters: RawInput, val fileCreator: FileCreator) {

    fun execute() {
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
        val validatedInput = InputValidator().handleInput(applicationParameters)

        fileCreator.writeFile(validatedInput)
    }

}