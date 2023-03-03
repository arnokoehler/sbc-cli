package ${packageName}

import dev.akif.crud.*
import dev.akif.crud.common.InstantProvider
import org.springframework.stereotype.Service
import java.time.Instant
<#if idType["import"]?has_content>
    import ${idType["import"]}
</#if>

@Service
class ${resourceNameUppercase}Service(
instantProvider: InstantProvider,
repository: CRUDRepository<${idType["type"]}, ${resourceNameUppercase}Entity>,
mapper: ${resourceNameUppercase}Mapper
) : CRUDService<${idType["type"]}, ${resourceNameUppercase}Entity, ${resourceNameUppercase}, Create${resourceNameUppercase}, Update${resourceNameUppercase}, ${resourceNameUppercase}Mapper>("${resourceNameUppercase}", instantProvider, repository, mapper)

data class Create${resourceNameUppercase}(val name: String) : CRUDCreateModel

data class Update${resourceNameUppercase}(val name: String) : CRUDUpdateModel

data class ${resourceNameUppercase}(
val id: ${idType["type"]},
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