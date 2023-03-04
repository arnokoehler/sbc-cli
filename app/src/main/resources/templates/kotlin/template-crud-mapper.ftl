package ${packageName}

import dev.akif.crud.CRUDDTOMapper
import dev.akif.crud.CRUDMapper
import org.springframework.stereotype.Component
import java.time.Instant
<#if idType["import"]?has_content>
    import ${idType["import"]}
</#if>

@Component
class ${resourceNameUppercase}Mapper: CRUDMapper<${idType["type"]}, ${resourceNameUppercase}Entity, ${resourceNameUppercase}, Create${resourceNameUppercase}, Update${resourceNameUppercase}>,
CRUDDTOMapper<${idType["type"]}, ${resourceNameUppercase}, ${resourceNameUppercase}DTO, Create${resourceNameUppercase}, Update${resourceNameUppercase}, Create${resourceNameUppercase}DTO, Update${resourceNameUppercase}DTO> {
override fun entityToBeCreatedFrom(createModel: Create${resourceNameUppercase}, now: Instant): ${resourceNameUppercase}Entity =
TODO("Not yet implemented")

override fun entityToModel(entity: ${resourceNameUppercase}Entity): ${resourceNameUppercase} =
TODO("Not yet implemented")

override fun updateEntityWith(entity: ${resourceNameUppercase}Entity, updateModel: Update${resourceNameUppercase}) {
entity.apply {
TODO("Not yet implemented")
}
}

override fun createDTOToCreateModel(createDTO: Create${resourceNameUppercase}DTO): Create${resourceNameUppercase} =
TODO("Not yet implemented")

override fun modelToDTO(model: ${resourceNameUppercase}): ${resourceNameUppercase}DTO =
TODO("Not yet implemented")

override fun updateDTOToUpdateModel(updateDTO: Update${resourceNameUppercase}DTO): Update${resourceNameUppercase} =
TODO("Not yet implemented")
}