package nl.arnokoehler.dev.akif.cli.inputhandlers

data class RawInput(
    val languageVariant: LanguageVariant?,
    val variantStyle: StyleVariant?,
    val resourceName: String?,
    val packageName: String?,
    val initializrZip: String?,
    val idType: ResourceIdType?,
    val targetDir: String?
) {
    override fun toString(): String {
        return """
            languageVariant: $languageVariant
            variantStyle: $variantStyle
            resourceName: $resourceName
            packageName: $packageName
            initializrZip: $initializrZip
            idType: $idType
            targetDir: $targetDir
        """.trimIndent()
    }
}

data class ApplicationParameters(
    val languageVariant: LanguageVariant,
    val variantStyle: StyleVariant,
    val idType: ResourceIdType,
    val resourceName: String,
    val packageName: String,
    val targetDir: String
)

class RawInputHandler {
    fun validate(rawInput: RawInput): Boolean {
        if (LanguageVariantInputHandler().validateInput(rawInput.languageVariant)
            && VariantStyleInputHandler().validateInput(rawInput.variantStyle)
            && ResourceIdTypeInputHandler().validateInput(rawInput.idType)
            && ResourceNameInputHandler().validateInput(rawInput.resourceName)
            && PackageNameInputHandler().validateInput(rawInput.packageName)
        ) {
            return true
        }
        return false
    }

    fun handleInput(rawInput: RawInput): ApplicationParameters {
        val applicationParameters = ApplicationParameters(
            languageVariant = LanguageVariantInputHandler().handleInput(rawInput.languageVariant),
            resourceName = ResourceNameInputHandler().handleInput(rawInput.resourceName),
            packageName = PackageNameInputHandler().handleInput(rawInput.packageName),
            variantStyle = VariantStyleInputHandler().handleInput(rawInput.variantStyle),
            idType = ResourceIdTypeInputHandler().handleInput(rawInput.idType),
            targetDir = rawInput.targetDir ?: throw IllegalArgumentException("Target directory cannot be empty")
        )

        return applicationParameters.copy(
            packageName = applicationParameters.packageName.convertToPackageWithResourceName(applicationParameters.resourceName)
        )
    }
}

abstract class InputHandler<T> {
    abstract fun handleInput(input: T?): T
    fun validateInput(input: T?): Boolean {
        return input != null
    }
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

fun String.convertToPackageWithResourceName(resourceName: String): String = when {
    this.contains(resourceName, ignoreCase = true) -> this
    else -> "$this.${resourceName.pluralize().lowercase()}"
}

fun String.pluralize() = if (this.endsWith("s")) {
    this
} else if (this.endsWith("y")) {
    "${this.substring(0, this.length - 1)}ies"
} else {
    "${this}s"
}



