package ${packageName}

import dev.akif.crud.CRUDDTO
import java.time.Instant
import java.util.UUID

data class ${resourceNameUppercase}DTO(
    val id: UUID,
    val name: String,
    val breed: String,
    val age: Int,
    val createdAt: Instant,
    val updatedAt: Instant
) : CRUDDTO<UUID> {
    override fun id(): UUID = id
    override fun createdAt(): Instant = createdAt
    override fun updatedAt(): Instant = updatedAt
}
