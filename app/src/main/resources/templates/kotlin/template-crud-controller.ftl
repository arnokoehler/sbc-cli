package ${packageName}

import dev.akif.crud.*
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
@RequestMapping("/${resourceNamePlural}")
class ${resourceNameUppercase}Controller(service: ${resourceNameUppercase}Service, mapper: ${resourceNameUppercase}Mapper) :
CRUDController<Long, ${resourceNameUppercase}Entity, ${resourceNameUppercase}, ${resourceNameUppercase}DTO, Create${resourceNameUppercase}, Update${resourceNameUppercase}, Create${resourceNameUppercase}DTO, Update${resourceNameUppercase}DTO, ${resourceNameUppercase}Mapper, ${resourceNameUppercase}Mapper, ${resourceNameUppercase}Service>(
"${resourceNameUppercase}",
service,
mapper
)

data class Create${resourceNameUppercase}DTO(val name: String) : CRUDCreateDTO

data class Update${resourceNameUppercase}DTO(val name: String) : CRUDUpdateDTO

data class ${resourceNameUppercase}DTO(
val id: Long,
val name: String,
val createdAt: Instant,
val updatedAt: Instant
) : CRUDDTO<Long> {
  override fun id(): Long = id
  override fun createdAt(): Instant = createdAt
  override fun updatedAt(): Instant = updatedAt
  }
