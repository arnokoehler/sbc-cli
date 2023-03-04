package nl.arnokoehler.dev.akif.cli

import nl.arnokoehler.dev.akif.cli.inputhandlers.dto.CliDto
import nl.arnokoehler.dev.akif.cli.inputhandlers.ApplicationParameters
import nl.arnokoehler.dev.akif.cli.inputhandlers.RawInput

sealed class CliState {
    data class InitialUnchecked(val input: RawInput) : CliState()
    data class InitialChecked(val input: RawInput) : CliState()
    data class Incomplete(val input: RawInput) : CliState()
    data class Validated(val validInput: ApplicationParameters, val dtoEntries: List<CliDto.DtoEntry>) : CliState()
    data class Generated(val input: RawInput) : CliState()
}

class InitialScreen : Screen<CliState.InitialUnchecked> {
    override fun render(cliState: CliState): Boolean {
        println("Welcome to the Spring-Boot-Crud CLI")
        println("You have provided the following parameters: ${(cliState as CliState.InitialUnchecked).input}")
        return true
    }
}

class ValidatedScreen : Screen<CliState.Validated> {
    override fun render(cliState: CliState): Boolean {
        println("You have provided the following parameters: ${(cliState as CliState.Validated).validInput}")
        println("Do you want to generate the project? (y/n)")
        return askForInput()
    }
}

interface Screen<T : CliState> {
    fun render(cliState: CliState): Boolean
}

fun askForInput(): Boolean =
    readlnOrNull()?.let {
        return when (it) {
            "y" -> proceed()
            "n" -> correct()
            else -> handleError()
        }
    } ?: handleError()
 fun handleError(): Boolean {
    println("Please provide a valid option")
    return askForInput()
}

fun correct(): Boolean {
    println("Please provide the correct parameters")
    return false
}

fun proceed(): Boolean {
    println("Great!")
    return true
}