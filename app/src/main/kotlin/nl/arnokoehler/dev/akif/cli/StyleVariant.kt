package nl.arnokoehler.dev.akif.cli

import com.beust.jcommander.IStringConverter

enum class StyleVariant {
    FULL_CRUD,
    SIMPLER_CRUD,
    SIMPLE_CRUD,
    SIMPLIST_CRUD
}

class StyleVariantConverter : IStringConverter<StyleVariant> {
    override fun convert(value: String): StyleVariant {
        return if(value.length > 1) {
            StyleVariant.valueOf(value.uppercase())
        } else {
            resolveOptions(value)
        }
    }

    private fun resolveOptions(value: String) = when (value) {
        "1" -> StyleVariant.values()[0]
        "2" -> StyleVariant.values()[1]
        "3" -> StyleVariant.values()[2]
        "4" -> StyleVariant.values()[3]
        else -> throw IllegalArgumentException("Please provide a valid style variant")
    }

}

