package ${packageName}

import dev.akif.crud.CRUDRepository
import dev.akif.crud.CRUDService
import dev.akif.crud.common.InstantProvider
import org.springframework.stereotype.Service
<#if idType["import"]?has_content>
import ${idType["import"]}
</#if>

@Service
class ${resourceNameUppercase}Service(
    instantProvider: InstantProvider,
    repository: CRUDRepository<${idType["type"]}, ${resourceNameUppercase}Entity>,
    mapper: ${resourceNameUppercase}Mapper
) : CRUDService<${idType["type"]}, ${resourceNameUppercase}Entity, ${resourceNameUppercase}, Create${resourceNameUppercase}, Update${resourceNameUppercase}, ${resourceNameUppercase}Repository, ${resourceNameUppercase}Mapper>(
    typeName = "${resourceNameUppercase}",
    instantProvider = instantProvider,
    crudRepository = repository,
    mapper = mapper
)
