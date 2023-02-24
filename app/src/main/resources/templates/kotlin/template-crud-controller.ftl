package ${packageName}

import dev.akif.crud.*
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
@RequestMapping("/${resourceName}s")
class ${resourceName}Controller(service: ${resourceName}Service, mapper: ${resourceName}Mapper) :
CRUDController<Long, ${resourceName}Entity, ${resourceName}, ${resourceName}DTO, Create${resourceName}, Update${resourceName}, Create${resourceName}DTO, Update${resourceName}DTO, ${resourceName}Mapper, ${resourceName}Mapper, ${resourceName}Service>(
"${resourceName}",
service,
mapper
)

data class Create${resourceName}DTO(
  ${dtoFields}
) : CRUDCreateDTO

data class Update${resourceName}DTO(val name: String) : CRUDUpdateDTO

data class ${resourceName}DTO(
val id: Long,
${dtoFields}
val createdAt: Instant,
val updatedAt: Instant
) : CRUDDTO<Long> {
  override fun id(): Long = id
  override fun createdAt(): Instant = createdAt
  override fun updatedAt(): Instant = updatedAt
  }
