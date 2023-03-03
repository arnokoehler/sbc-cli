package ${packageName}

import dev.akif.crud.CRUDDTOMapper
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ${resourceNameUppercase}DTOMapper : CRUDDTOMapper<UUID, ${resourceNameUppercase}, ${resourceNameUppercase}DTO, Create${resourceNameUppercase}, Update${resourceNameUppercase}, Create${resourceNameUppercase}DTO, Update${resourceNameUppercase}DTO> {
    override fun createDTOToCreateModel(createDTO: Create${resourceNameUppercase}DTO): Create${resourceNameUppercase} =
        Create${resourceNameUppercase}(
            name = createDTO.name,
            breed = createDTO.breed,
            age = createDTO.age
        )

    override fun modelToDTO(model: ${resourceNameUppercase}): ${resourceNameUppercase}DTO =
        ${resourceNameUppercase}DTO(
            id = model.id,
            name = model.name,
            breed = model.breed,
            age = model.age,
            createdAt = model.createdAt,
            updatedAt = model.updatedAt
        )

    override fun updateDTOToUpdateModel(updateDTO: Update${resourceNameUppercase}DTO): Update${resourceNameUppercase} =
        Update${resourceNameUppercase}(
            name = updateDTO.name,
            age = updateDTO.age
        )
}
