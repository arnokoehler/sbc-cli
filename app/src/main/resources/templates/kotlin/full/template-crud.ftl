package ${packageName}

import dev.akif.crud.CRUDModel
import java.time.Instant
<#if idType["import"]?has_content>
import ${idType["import"]}
</#if>

data class ${resourceNameUppercase}(
    val id: ${idType["type"]},
    val name: String,
    val breed: String,
    val age: Int,
    val version: Int,
    val createdAt: Instant,
    val updatedAt: Instant,
    val deletedAt: Instant?
) : CRUDModel<${idType["type"]}> {
    override fun id(): ${idType["type"]} = id
    override fun version(): Int = version
    override fun createdAt(): Instant = createdAt
    override fun updatedAt(): Instant = updatedAt
    override fun deletedAt(): Instant? = deletedAt
}
