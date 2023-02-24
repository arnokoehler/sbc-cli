package nl.arnokoehler.dev.akif.cli

import nl.arnokoehler.dev.akif.cli.dto.CliDto
import kotlin.system.exitProcess

class Menu(private val rawInput: RawInput, private val fileCreator: FileCreator) {

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
        val validatedInput = InputValidator().handleInput(rawInput)
        val cliDto = CliDto()
        cliDto.askUser()
        fileCreator.writeFile(validatedInput, cliDto.dataTransferObjects)
    }

}