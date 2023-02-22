package ${packageName}

import dev.akif.crud.*
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
class ${resourceName}Controller(typeName: String, service: ${resourceName}Service, mapper: ${resourceName}DTOMapper) :
CRUDController<Long, ${resourceName}Entity, ${resourceName}Model, ${resourceName}Dto, ${resourceName}CreateModel, ${resourceName}UpdateModel, ${resourceName}CreateDTO, ${resourceName}UpdateDTO, ${resourceName}Mapper, ${resourceName}DTOMapper, ${resourceName}Service>(
typeName, service, mapper
) {

}

@Service
class ${resourceName}DTOMapper : CRUDDTOMapper<Long, ${resourceName}Model, ${resourceName}Dto, ${resourceName}CreateModel, ${resourceName}UpdateModel, ${resourceName}CreateDTO, ${resourceName}UpdateDTO> {

override fun createDTOToCreateModel(createDTO: ${resourceName}CreateDTO): ${resourceName}CreateModel {
TODO("Not yet implemented")
}

override fun modelToDTO(model: ${resourceName}Model): ${resourceName}Dto {
TODO("Not yet implemented")
}

override fun updateDTOToUpdateModel(updateDTO: ${resourceName}UpdateDTO): ${resourceName}UpdateModel {
TODO("Not yet implemented")
}

}

data class ${resourceName}Dto(
val id: Long, val version: Int, val createdAt: Instant, val updatedAt: Instant, val deletedAt: Instant?
) : CRUDDTO<Long> {

  override fun id(): Long {
  return id
  }

  override fun createdAt(): Instant {
  return createdAt
  }

  override fun updatedAt(): Instant {
  return updatedAt
  }
  }

  data class ${resourceName}CreateDTO(val ${resourceName}Name: String) : CRUDCreateDTO

  data class ${resourceName}UpdateDTO(val ${resourceName}Name: String) : CRUDUpdateDTO