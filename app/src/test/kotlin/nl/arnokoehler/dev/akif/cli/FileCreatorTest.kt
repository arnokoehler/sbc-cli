package nl.arnokoehler.dev.akif.cli

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FileCreatorTest {

    @Test
    fun shouldCapitalize() {
        assertEquals("Test", "test".capitalize())
    }

    @Test
    fun shouldNotChangeAlreadyCapitalize() {
        assertEquals("Fun", "Fun".capitalize())
    }


}