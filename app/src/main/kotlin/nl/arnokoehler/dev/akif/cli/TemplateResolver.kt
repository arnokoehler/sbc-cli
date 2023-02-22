package nl.arnokoehler.dev.akif.cli

class TemplateResolver {

    private val kotlinTemplates = mapOf(
        "controller" to "kotlin/template-crud-controller.ftl",
        "service" to "kotlin/template-crud-service.ftl",
        "repository" to "kotlin/template-crud-repository.ftl"
    )

    private val javaTemplates = mapOf(
        "controller" to "java/template-crud-controller.ftl",
        "service" to "java/template-crud-service.ftl",
        "repository" to "java/template-crud-repository.ftl"
    )

    fun resolveTemplates(languageVariant: LanguageVariant?): Map<String, String> {
        return when (languageVariant) {
            LanguageVariant.JAVA -> javaTemplates
            LanguageVariant.KOTLIN -> kotlinTemplates
            else -> javaTemplates
        }
    }
}