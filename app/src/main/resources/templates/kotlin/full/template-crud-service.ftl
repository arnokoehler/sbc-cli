package ${packageName}

import dev.akif.crud.CRUDRepository
import dev.akif.crud.CRUDService
import dev.akif.crud.common.InstantProvider
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ${resourceNameUppercase}Service(
    instantProvider: InstantProvider,
    repository: CRUDRepository<UUID, ${resourceNameUppercase}Entity>,
    mapper: ${resourceNameUppercase}Mapper
) : CRUDService<UUID, ${resourceNameUppercase}Entity, ${resourceNameUppercase}, Create${resourceNameUppercase}, Update${resourceNameUppercase}, ${resourceNameUppercase}Repository, ${resourceNameUppercase}Mapper>(
    typeName = "${resourceNameUppercase}",
    instantProvider = instantProvider,
    crudRepository = repository,
    mapper = mapper
)
