package ${packageName}

import dev.akif.crud.CRUDEntity
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant
<#if idType["import"]?has_content>
import ${idType["import"]}
</#if>

@Entity
@Table(name = "cats")
class ${resourceNameUppercase}Entity(
    @Id override var id: ${idType["type"]}? = null,
    var name: String? = null,
    var breed: String? = null,
    var age: Int? = null,
    override var version: Int? = null,
    override var createdAt: Instant? = null,
    override var updatedAt: Instant? = null,
    override var deletedAt: Instant? = null
) : CRUDEntity<${idType["type"]}>(id, version, createdAt, updatedAt, deletedAt) {
    override fun toString(): String {
        return "${resourceNameUppercase}Entity(id=$id, name=$name, breed=$breed, age=$age, version=$version, createdAt=$createdAt, updatedAt=$updatedAt, deletedAt=$deletedAt)"
    }
}
