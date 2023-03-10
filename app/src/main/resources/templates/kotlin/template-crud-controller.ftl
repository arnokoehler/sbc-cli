package ${packageName}

import dev.akif.crud.*
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
<#if idType["import"]?has_content>
import ${idType["import"]}
</#if>

@RestController
@RequestMapping("/${resourceNamePlural}")
class ${resourceNameUppercase}Controller(service: ${resourceNameUppercase}Service, mapper: ${resourceNameUppercase}Mapper) :
CRUDController<${idType["type"]}, ${resourceNameUppercase}Entity, ${resourceNameUppercase}, ${resourceNameUppercase}DTO, Create${resourceNameUppercase}, Update${resourceNameUppercase}, Create${resourceNameUppercase}DTO, Update${resourceNameUppercase}DTO, ${resourceNameUppercase}Mapper, ${resourceNameUppercase}Mapper, ${resourceNameUppercase}Service>(
"${resourceNameUppercase}",
service,
mapper
)

data class Create${resourceNameUppercase}DTO(
    ${dtoFields}
) : CRUDCreateDTO

data class Update${resourceNameUppercase}DTO(val name: String) : CRUDUpdateDTO

data class ${resourceNameUppercase}DTO(
val id: ${idType["type"]},
${dtoFields}
val createdAt: Instant,
val updatedAt: Instant
) : CRUDDTO<${idType["type"]}> {
  override fun id(): ${idType["type"]} = id
  override fun createdAt(): Instant = createdAt
  override fun updatedAt(): Instant = updatedAt
}
