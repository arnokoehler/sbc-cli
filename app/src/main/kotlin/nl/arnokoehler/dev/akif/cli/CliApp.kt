package nl.arnokoehler.dev.akif.cli


class CliApp(private val args: Array<String>) {

    val greeting: String
        get() {
            return "Hello, ${args[0]}"
        }

}

fun main(args: Array<String>) {

    println(CliApp(args).greeting)
}