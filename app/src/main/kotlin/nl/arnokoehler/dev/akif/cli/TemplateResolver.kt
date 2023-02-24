package nl.arnokoehler.dev.akif.cli

class TemplateResolver {

    private val kotlinTemplates = mapOf(
        "Controller" to "kotlin/template-crud-controller.ftl",
        "Service" to "kotlin/template-crud-service.ftl",
        "Mapper" to "kotlin/template-crud-mapper.ftl",
        "Repository" to "kotlin/template-crud-repository.ftl"
    )

    private val javaTemplates = mapOf(
        "Controller" to "java/template-crud-controller.ftl",
        "Service" to "java/template-crud-service.ftl",
        "Repository" to "java/template-crud-repository.ftl"
    )

    fun resolveTemplates(languageVariant: LanguageVariant?): Map<String, String> {
        return when (languageVariant) {
            LanguageVariant.JAVA -> javaTemplates
            LanguageVariant.KOTLIN -> kotlinTemplates
            else -> javaTemplates
        }
    }
}