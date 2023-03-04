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

    private fun resolveOptions(value: String): StyleVariant {
        return StyleVariant.values()
            .getOrNull((value.toIntOrNull() ?: 0) - 1)
            ?: throw IllegalArgumentException("Please provide a valid language variant")
    }

}

