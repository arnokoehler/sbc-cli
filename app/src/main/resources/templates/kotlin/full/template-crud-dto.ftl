package ${packageName}

import dev.akif.crud.CRUDDTO
import java.time.Instant
<#if idType["import"]?has_content>
import ${idType["import"]}
</#if>

data class ${resourceNameUppercase}DTO(
    val id: ${idType["type"]},
    val name: String,
    val breed: String,
    val age: Int,
    val createdAt: Instant,
    val updatedAt: Instant
) : CRUDDTO<${idType["type"]}> {
    override fun id(): ${idType["type"]} = id
    override fun createdAt(): Instant = createdAt
    override fun updatedAt(): Instant = updatedAt
}
