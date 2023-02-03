package nl.arnokoehler.dev.akif.cli

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CliKtTest {
    @Test
    fun appHasAGreeting() {
        val classUnderTest = CliApp("Arno".split(" ").toTypedArray())
        assertEquals("Hello, Arno", classUnderTest.greeting)
    }
}

