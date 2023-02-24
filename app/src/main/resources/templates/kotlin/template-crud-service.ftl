package ${packageName}

import dev.akif.crud.*
import dev.akif.crud.common.InstantProvider
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class ${resourceNameUppercase}Service(
instantProvider: InstantProvider,
repository: CRUDRepository<Long, ${resourceNameUppercase}Entity>,
mapper: ${resourceNameUppercase}Mapper
) : CRUDService<Long, ${resourceNameUppercase}Entity, ${resourceNameUppercase}, Create${resourceNameUppercase}, Update${resourceNameUppercase}, ${resourceNameUppercase}Mapper>("${resourceNameUppercase}", instantProvider, repository, mapper)

data class Create${resourceNameUppercase}(val name: String) : CRUDCreateModel

data class Update${resourceNameUppercase}(val name: String) : CRUDUpdateModel

data class ${resourceNameUppercase}(
val id: Long,
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