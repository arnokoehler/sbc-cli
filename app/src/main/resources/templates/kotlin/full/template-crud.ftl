package ${packageName}

import dev.akif.crud.CRUDModel
import java.time.Instant
import java.util.UUID

data class ${resourceNameUppercase}(
    val id: UUID,
    val name: String,
    val breed: String,
    val age: Int,
    val version: Int,
    val createdAt: Instant,
    val updatedAt: Instant,
    val deletedAt: Instant?
) : CRUDModel<UUID> {
    override fun id(): UUID = id
    override fun version(): Int = version
    override fun createdAt(): Instant = createdAt
    override fun updatedAt(): Instant = updatedAt
    override fun deletedAt(): Instant? = deletedAt
}
