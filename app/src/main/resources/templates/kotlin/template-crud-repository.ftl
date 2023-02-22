package ${packageName}

import dev.akif.crud.CRUDEntity
import dev.akif.crud.CRUDRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import java.time.Instant

@Repository
class ${resourceName}Repository() : CRUDRepository<Long, ${resourceName}Entity> {
override fun findAllByDeletedAtIsNull(pageable: Pageable): Page<${resourceName}Entity> {
    TODO("Not yet implemented")
    }

    override fun update(entity: ${resourceName}Entity): Int {
    TODO("Not yet implemented")
    }

    override fun save(entity: ${resourceName}Entity): ${resourceName}Entity {
    TODO("Not yet implemented")
    }

    override fun findByIdAndDeletedAtIsNull(id: Long): ${resourceName}Entity? {
    TODO("Not yet implemented")
    }
}

class ${resourceName}Entity(
id: Long, version: Int, createdAt: Instant, updatedAt: Instant, deletedAt: Instant
) : CRUDEntity<Long, ${resourceName}Entity>(id, version, createdAt, updatedAt, deletedAt)