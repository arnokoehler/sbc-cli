package nl.arnokoehler.dev.akif.cli.generators

import nl.arnokoehler.dev.akif.cli.inputhandlers.LanguageVariant
import nl.arnokoehler.dev.akif.cli.inputhandlers.StyleVariant

class TemplateResolver {

    private val kotlinTemplates = mapOf(
        "Controller" to "kotlin/template-crud-controller.ftl",
        "Service" to "kotlin/template-crud-service.ftl",
        "Mapper" to "kotlin/template-crud-mapper.ftl",
        "Repository" to "kotlin/template-crud-repository.ftl"
    )

    private val kotlinFullTemplates = mapOf(
        "Controller" to "kotlin/full/template-crud-controller.ftl",
        "CreateDto" to "kotlin/full/template-crud-create-dto.ftl",
        "Create" to "kotlin/full/template-crud-create.ftl",
        "DtoMapper" to "kotlin/full/template-crud-dto-mapper.ftl",
        "Dto" to "kotlin/full/template-crud-dto.ftl",
        "Entity" to "kotlin/full/template-crud-entity.ftl",
        "Main" to "kotlin/full/template-crud-main.ftl",
        "Mapper" to "kotlin/full/template-crud-mapper.ftl",
        "Repository" to "kotlin/full/template-crud-repository.ftl",
        "Service" to "kotlin/full/template-crud-service.ftl",
        "UpdateDto" to "kotlin/full/template-crud-update-dto.ftl",
        "Update" to "kotlin/full/template-crud-update.ftl",
        "" to "kotlin/full/template-crud.ftl",
    )

    private val javaFullTemplates = mapOf(
        "Controller" to "java/full/template-crud-controller.ftl",
        "CreateModelDto" to "java/full/template-crud-create-model-dto.ftl",
        "CreateModel" to "java/full/template-crud-create-model.ftl",
        "ModelDto" to "java/full/template-crud-model-dto.ftl",
        "ModelEntity" to "java/full/template-crud-model-entity.ftl",
        "ModelMapper" to "java/full/template-crud-model-mapper.ftl",
        "ModelRepository" to "java/full/template-crud-model-repository.ftl",
        "ModelService" to "java/full/template-crud-model-service.ftl",
        "UpdateModelDto" to "java/full/template-crud-update-model-dto.ftl",
        "UpdateModel" to "java/full/template-crud-update-model.ftl",
        "" to "java/full/template-crud.ftl",
    )

    private val templates = mapOf(
        Pair(LanguageVariant.KOTLIN, StyleVariant.FULL_CRUD) to kotlinFullTemplates,
        Pair(LanguageVariant.KOTLIN, StyleVariant.FULL_CRUD_THREE_FILES) to kotlinTemplates,
        Pair(LanguageVariant.JAVA, StyleVariant.FULL_CRUD) to javaFullTemplates,
    )

    fun resolveTemplates(languageVariant: LanguageVariant?, styleVariant: StyleVariant): Map<String, String> {
        return templates[Pair(languageVariant, styleVariant)] ?: kotlinTemplates
    }
}