package nl.arnokoehler.dev.akif.cli

import com.beust.jcommander.IStringConverter

enum class LanguageVariant(val extension: String) {
    KOTLIN(".kt"),
    JAVA(".java");
}

class LanguageConverter : IStringConverter<LanguageVariant> {
    override fun convert(value: String): LanguageVariant {
        return if(value.length > 1) {
            LanguageVariant.valueOf(value.uppercase())
        } else {
            resolveOptions(value)
        }
    }

    private fun resolveOptions(value: String): LanguageVariant {
        return LanguageVariant.values()
            .getOrNull((value.toIntOrNull() ?: 0) - 1)
            ?: throw IllegalArgumentException("Please provide a valid language variant")
    }

}

class LanguageVariantInputHandler : InputHandler<LanguageVariant>() {
    override fun handleInput(input: LanguageVariant?): LanguageVariant {
        if (input != null) {
            return input
        }
        println("Please provide a language variant: kotlin or java")
        for (value in LanguageVariant.values()) {
            println("${value.ordinal + 1} ${value.name}")
        }
        val languageVariant = LanguageConverter().convert(readlnOrNull() ?: "kotlin")
        println("language set to: $languageVariant")
        return languageVariant
    }
}



