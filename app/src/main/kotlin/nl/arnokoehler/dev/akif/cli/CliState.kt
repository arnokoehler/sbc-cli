package nl.arnokoehler.dev.akif.cli

import nl.arnokoehler.dev.akif.cli.dto.CliDto

sealed class CliState {
    data class InitialUnchecked(val input: RawInput) : CliState()
    data class InitialChecked(val input: RawInput) : CliState()
    data class Incomplete(val input: RawInput) : CliState()
    data class Validated(val validInput: ApplicationParameters, val dtoEntries: List<CliDto.DtoEntry>) : CliState()
    data class Generated(val input: RawInput) : CliState()
}

interface Screen<T : CliState> {
    fun render(cliState: CliState)
}

class InitialScreen : Screen<CliState.InitialUnchecked> {
    override fun render(cliState: CliState) {
        println("Welcome to the Spring-Boot-Crud CLI")
        println("You have provided the following parameters: ${(cliState as CliState.InitialUnchecked).input}")
        println("Is this correct? (y/n)")
        askForInput()
    }

    private fun askForInput(): Boolean =
        readlnOrNull()?.let {
            return when (it) {
                "y" -> proceed()
                "n" -> correct()
                else -> handleError()
            }
        } ?: handleError()

    private fun handleError(): Boolean {
        println("Please provide a valid option")
        return askForInput()
    }

    private fun correct(): Boolean {
        println("Please provide the correct parameters")
        return true
    }

    private fun proceed(): Boolean {
        println("Great!")
        return false
    }
}

class ValidatedScreen : Screen<CliState.Validated> {
    override fun render(cliState: CliState) {
        println("You have provided the following parameters: ${(cliState as CliState.InitialUnchecked).input}")
        println("Do you want to generate the project? (y/n)")
    }
}

