package nl.arnokoehler.dev.akif.cli.dto

class CliDto {
    val dtos: MutableList<DtoEntry> = mutableListOf()

    fun createResource() {
        // Create a new DTO
        //   ask for name of dto
        //       ask for field entry
        println(createDto())
    }

    fun createDto(): DtoEntry {
        // Ask for name of DTO
        var dtoName: String

        println("What is the name of the DTO?")
        loop@ while (true) {
            dtoName = readlnOrNull() ?: ""
            when (dtoName) {
                "" -> println("Please enter a valid DTO name")
                else -> break@loop
            }
        }

        // Ask for the fields
        val fields: MutableList<DtoFieldEntry> = mutableListOf()
        loop@ while (true) {
            println("Do you need to add a field?")
            println("y: Add a new field")
            println("n: No need")
            when (readlnOrNull() ?: "n") {
                "y" -> createField().also { fields.add(it) }
                "n" -> break@loop
                else -> continue@loop
            }
        }

        return DtoEntry(dtoName)
            .also { it.fieldEntries.addAll(fields) }
    }

    fun createField(): DtoFieldEntry {
        // Ask for name of field
        // Ask for type of field

        // return type

        return DtoFieldEntry("fieldName", "fieldType")
    }

    fun askUser() {
        println("Do you want to generate your DTOs now?")

        loop@ while (true) {
            println("Please select an option:")
            println("y: Create a DTO")
            println("n: Skip process")
            when (readlnOrNull() ?: "n") {
                "y" -> createResource()
                "n" -> break@loop
                else -> println("Please select a valid option")
            }
        }
    }

    data class DtoEntry(
        val name: String,
        val fieldEntries: MutableList<DtoFieldEntry> = mutableListOf()
    )

    data class DtoFieldEntry(
        val varName: String,
        val typeName: String
    )
}