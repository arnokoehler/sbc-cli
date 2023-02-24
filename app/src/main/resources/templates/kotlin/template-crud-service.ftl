package ${packageName}

import dev.akif.crud.*
import dev.akif.crud.common.InstantProvider
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class ${resourceName}Service(
instantProvider: InstantProvider,
repository: CRUDRepository<Long, ${resourceName}Entity>,
mapper: ${resourceName}Mapper
) : CRUDService<Long, ${resourceName}Entity, ${resourceName}, Create${resourceName}, Update${resourceName}, ${resourceName}Mapper>("${resourceName}", instantProvider, repository, mapper)

data class Create${resourceName}(
${dtoFields}
) : CRUDCreateModel

data class Update${resourceName}(
${dtoFields}
) : CRUDUpdateModel

data class ${resourceName}(
val id: Long,
${dtoFields}
val version: Int,
val createdAt: Instant,
val updatedAt: Instant,
val deletedAt: Instant?
) : CRUDModel<Long> {
    override fun id(): Long = id
    override fun version(): Int = version
    override fun createdAt(): Instant = createdAt
    override fun updatedAt(): Instant = updatedAt
    override fun deletedAt(): Instant? = deletedAt
    }