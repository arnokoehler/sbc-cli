package nl.arnokoehler.dev.akif.cli

import nl.arnokoehler.dev.akif.cli.dto.CliDto
import kotlin.system.exitProcess

class Menu(private val firstInput: RawInput, private val fileCreator: FileCreator) {

    private var currentState: CliState = CliState.InitialUnchecked(firstInput)

    fun execute() {
        while (currentState !is CliState.Generated) {
            if (handleState()) break
        }
        exitProcess(0)
    }

    private fun handleState(): Boolean {
        when (currentState) {
            is CliState.InitialUnchecked -> {
                InitialScreen().render(currentState)
                currentState = CliState.InitialChecked(firstInput)
            }

            is CliState.InitialChecked -> {
                currentState = if (RawInputHandler().validate((currentState as CliState.InitialChecked).input)) {
                    CliState.Validated(handleInput((currentState as CliState.InitialChecked).input), CliDto().askUser())
                } else {
                    CliState.Incomplete(firstInput)
                }
            }
            is CliState.Incomplete -> {
                currentState = CliState.Validated(handleInput((currentState as CliState.Incomplete).input), CliDto().askUser())
            }
            is CliState.Validated -> {
                ValidatedScreen().render(currentState)
                fileCreator.writeFile((currentState as CliState.Validated).validInput, (currentState as CliState.Validated).dtoEntries)
            }
            is CliState.Generated -> return true
        }
        return false
    }

    private fun handleInput(rawInput: RawInput): ApplicationParameters {
        val validatedInput: ApplicationParameters = if (firstInput.initializrZip != null) {
            SpringInitializr().handleInput(rawInput)
        } else {
            RawInputHandler().handleInput(rawInput)
        }
        return validatedInput
    }
}
