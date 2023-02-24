package nl.arnokoehler.dev.akif.cli

data class RawInput(
    var languageVariant: LanguageVariant?,
    var variantStyle: StyleVariant?,
    var resourceName: String?,
    var packageName: String?,
    var initializrZip: String?,
    var idType: ResourceIdType?,
    var targetDir: String?
)

data class ApplicationParameters(
    val languageVariant: LanguageVariant,
    val variantStyle: StyleVariant,
    val idType: ResourceIdType,
    val resourceName: String,
    val packageName: String,
    val targetDir: String
)

class InputValidator() {

    fun handleInput(rawInput: RawInput): ApplicationParameters {
        val applicationParameters = ApplicationParameters(
            languageVariant = LanguageVariantInputHandler().handleInput(rawInput.languageVariant),
            resourceName = ResourceNameInputHandler().handleInput(rawInput.resourceName),
            packageName = PackageNameInputHandler().handleInput(rawInput.packageName),
            variantStyle = VariantStyleInputHandler().handleInput(rawInput.variantStyle),
            targetDir = rawInput.targetDir ?: throw IllegalArgumentException("Target directory cannot be empty")
        )

        return applicationParameters.copy(
            packageName = applicationParameters.packageName.convertToPackageWithResourceName(applicationParameters.resourceName)
        )
    }
}

abstract class InputHandler<T> {
    abstract fun handleInput(input: T?): T
}

class ResourceNameInputHandler : InputHandler<String>() {
    override fun handleInput(input: String?): String {
        if (!input.isNullOrEmpty()) {
            return input
        }
        println("Please provide a resource name")
        val resourceName = readlnOrNull() ?: throw IllegalArgumentException("Resource name cannot be empty")
        println("resource name set to: $resourceName")
        return resourceName
    }
}

class PackageNameInputHandler : InputHandler<String>() {
    override fun handleInput(input: String?): String {
        if (!input.isNullOrEmpty()) {
            return input
        }
        println("Please provide a package name")
        val packageName = readlnOrNull() ?: throw IllegalArgumentException("Package name cannot be empty")
        println("package name set to: $packageName")
        return packageName
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

class ResourceIdTypeInputHandler : InputHandler<ResourceIdType>() {
    override fun handleInput(input: ResourceIdType?): ResourceIdType {
        if (input != null) {
            return input
        }
        println("Please provide a type for the primary ID")
        for (value in StyleVariant.values()) {
            println("${value.ordinal + 1} ${value.name}")
        }
        val resourceIdType = ResourceIdTypeConverter().convert(readlnOrNull() ?: "long")
        println("variant style set to: $resourceIdType")
        return resourceIdType
    }
}


fun String.convertToPackageWithResourceName(resourceName: String): String = when {
    this.contains(resourceName, ignoreCase = true) -> this
    else -> this + resourceName.pluralize()
}

fun String.pluralize() = if (this.endsWith("s")) {
    ".${this}"
} else if(this.endsWith("y")) {
    ".${this.substring(0, this.length - 1)}ies"
} else {
    ".${this}s"
}



