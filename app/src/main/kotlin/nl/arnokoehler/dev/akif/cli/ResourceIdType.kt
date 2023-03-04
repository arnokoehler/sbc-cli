package nl.arnokoehler.dev.akif.cli

import com.beust.jcommander.IStringConverter


enum class ResourceIdType(val import: String?, val type: String) {
    LONG(null, "Long"),
    UUID("java.util.UUID", "UUID")
    ;
}

class ResourceIdTypeConverter : IStringConverter<ResourceIdType> {
    override fun convert(value: String): ResourceIdType {
        return if (value.length > 1) {
            ResourceIdType.valueOf(value.uppercase())
        } else {
            resolveOptions(value)
        }
    }

    private fun resolveOptions(value: String): ResourceIdType {
        return ResourceIdType.values()
            .getOrNull((value.toIntOrNull() ?: 0) - 1)
            ?: throw IllegalArgumentException("Please provide a valid language variant");
    }

}
