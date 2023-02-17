package nl.arnokoehler.akif.sbc.sbcdemo

import dev.akif.crud.*
import org.springframework.stereotype.Service
import java.time.Clock
import java.time.Instant

@Service
class ${resourceName}Service(typeName: String, clock: Clock, repository: CRUDRepository<Long, ${resourceName}Entity>, mapper: ${resourceName}Mapper) :
CRUDService<Long, ${resourceName}Entity, ${resourceName}Model, ${resourceName}CreateModel, ${resourceName}UpdateModel, ${resourceName}Mapper>(typeName, clock, repository, mapper) {

}

@Service
class ${resourceName}Mapper : CRUDMapper<Long, ${resourceName}Entity, ${resourceName}Model, ${resourceName}CreateModel, ${resourceName}UpdateModel> {

override fun entityToBeCreatedFrom(createModel: ${resourceName}CreateModel, now: Instant): ${resourceName}Entity {
TODO("Not yet implemented")
}

override fun entityToModel(entity: ${resourceName}Entity): ${resourceName}Model {
TODO("Not yet implemented")
}

override fun updateEntityWith(updateModel: ${resourceName}UpdateModel, entity: ${resourceName}Entity) {
TODO("Not yet implemented")
}
}

data class ${resourceName}Model(
val id: Long, val version: Int, val createdAt: Instant, val updatedAt: Instant, val deletedAt: Instant?
) : CRUDModel<Long> {

    override fun createdAt(): Instant {
    return createdAt
    }

    override fun deletedAt(): Instant? {
    return deletedAt
    }

    override fun id(): Long {
    return id
    }

    override fun updatedAt(): Instant {
    return updatedAt
    }

    override fun version(): Int {
    return version
    }

}

data class ${resourceName}CreateModel(val ${resourceName}Name: String) : CRUDCreateModel

data class ${resourceName}UpdateModel(val ${resourceName}Name: String) : CRUDUpdateModel