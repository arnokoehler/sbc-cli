package ${packageName}

import dev.akif.crud.CRUDDTOMapper
import dev.akif.crud.CRUDMapper
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class ${resourceName}Mapper: CRUDMapper<Long, ${resourceName}Entity, ${resourceName}, Create${resourceName}, Update${resourceName}>,
CRUDDTOMapper<Long, ${resourceName}, ${resourceName}DTO, Create${resourceName}, Update${resourceName}, Create${resourceName}DTO, Update${resourceName}DTO> {
override fun entityToBeCreatedFrom(createModel: Create${resourceName}, now: Instant): ${resourceName}Entity =
TODO("Not yet implemented")

override fun entityToModel(entity: ${resourceName}Entity): ${resourceName} =
TODO("Not yet implemented")

override fun updateEntityWith(entity: ${resourceName}Entity, updateModel: Update${resourceName}) {
entity.apply {
TODO("Not yet implemented")
}
}

override fun createDTOToCreateModel(createDTO: Create${resourceName}DTO): Create${resourceName} =
TODO("Not yet implemented")

override fun modelToDTO(model: ${resourceName}): ${resourceName}DTO =
TODO("Not yet implemented")

override fun updateDTOToUpdateModel(updateDTO: Update${resourceName}DTO): Update${resourceName} =
TODO("Not yet implemented")
}