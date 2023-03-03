package ${packageName}

import dev.akif.crud.CRUDMapper
import org.springframework.stereotype.Component
import java.time.Instant
import java.util.UUID

@Component
class ${resourceNameUppercase}Mapper : CRUDMapper<UUID, ${resourceNameUppercase}Entity, ${resourceNameUppercase}, Create${resourceNameUppercase}, Update${resourceNameUppercase}> {
    override fun entityToBeCreatedFrom(createModel: Create${resourceNameUppercase}, now: Instant): ${resourceNameUppercase}Entity =
        ${resourceNameUppercase}Entity(
            id = UUID.randomUUID(),
            name = createModel.name,
            breed = createModel.breed,
            age = createModel.age,
            version = 0,
            createdAt = now,
            updatedAt = now,
            deletedAt = null
        )

    override fun entityToModel(entity: ${resourceNameUppercase}Entity): ${resourceNameUppercase} =
        ${resourceNameUppercase}(
            id = requireNotNull(entity.id) { "${resourceNameUppercase}Entity.id was null" },
            name = requireNotNull(entity.name) { "${resourceNameUppercase}Entity.name was null" },
            breed = requireNotNull(entity.breed) { "${resourceNameUppercase}Entity.breed was null" },
            age = requireNotNull(entity.age) { "${resourceNameUppercase}Entity.age was null" },
            version = requireNotNull(entity.version) { "${resourceNameUppercase}Entity.version was null" },
            createdAt = requireNotNull(entity.createdAt) { "${resourceNameUppercase}Entity.createdAt was null" },
            updatedAt = requireNotNull(entity.updatedAt) { "${resourceNameUppercase}Entity.updatedAt was null" },
            deletedAt = entity.deletedAt
        )

    override fun updateEntityWith(entity: ${resourceNameUppercase}Entity, updateModel: Update${resourceNameUppercase}) {
        entity.apply {
            name = updateModel.name
            age = updateModel.age
        }
    }
}
