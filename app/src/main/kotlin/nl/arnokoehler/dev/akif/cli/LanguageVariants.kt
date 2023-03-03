package nl.arnokoehler.dev.akif.cli

import com.beust.jcommander.IStringConverter

enum class LanguageVariant {
    KOTLIN,
    JAVA
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

