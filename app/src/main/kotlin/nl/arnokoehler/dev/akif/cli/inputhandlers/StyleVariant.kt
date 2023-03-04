package nl.arnokoehler.dev.akif.cli.inputhandlers

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

class VariantStyleInputHandler : InputHandler<StyleVariant>() {
    override fun handleInput(input: StyleVariant?): StyleVariant {
        if (input != null) {
            return input
        }
        println("Please provide a variant style: crud or rest")
        for (value in StyleVariant.values()) {
            println("${value.ordinal + 1} ${value.name}")
        }
        val variantStyle = StyleVariantConverter().convert(readlnOrNull() ?: "crud")
        println("variant style set to: $variantStyle")
        return variantStyle
    }
}