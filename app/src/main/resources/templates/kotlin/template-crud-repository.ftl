package ${packageName}

import dev.akif.crud.CRUDEntity
import dev.akif.crud.CRUDRepository
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.stereotype.Repository
import java.time.Instant

@Repository
interface ${resourceNameUppercase}Repository : CRUDRepository<Long, ${resourceNameUppercase}Entity>

@Entity
class ${resourceNameUppercase}Entity(
@Id override var id: Long?,
var name: String?,
override var version: Int?,
override var createdAt: Instant?,
override var updatedAt: Instant?,
override var deletedAt: Instant?
) : CRUDEntity<Long, ${resourceNameUppercase}Entity>(id, version, createdAt, updatedAt, deletedAt) {
constructor() : this(
id = null,
name = null,
version = null,
createdAt = null,
updatedAt = null,
deletedAt = null
)

override fun toString(): String {
return "${resourceNameUppercase}Entity(id=$id, name=$name, version=$version, createdAt=$createdAt, updatedAt=$updatedAt, deletedAt=$deletedAt)"
}
}