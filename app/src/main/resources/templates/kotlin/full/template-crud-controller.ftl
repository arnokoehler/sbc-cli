package ${packageName}

import dev.akif.crud.CRUDController
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
<#if idType["import"]?has_content>
import ${idType["import"]}
</#if>

@RestController
@RequestMapping("/${resourceNamePlural}")
@Tag(name = "${resourceNamePlural}", description = "CRUD operations for ${resourceName} entities")
class ${resourceNameUppercase}Controller(service: ${resourceNameUppercase}Service, mapper: ${resourceNameUppercase}DTOMapper) :
    CRUDController<${idType["type"]}, ${resourceNameUppercase}Entity, ${resourceNameUppercase}, ${resourceNameUppercase}DTO, Create${resourceNameUppercase}, Update${resourceNameUppercase}, Create${resourceNameUppercase}DTO, Update${resourceNameUppercase}DTO, ${resourceNameUppercase}Mapper, ${resourceNameUppercase}DTOMapper, ${resourceNameUppercase}Repository, ${resourceNameUppercase}Service>(
        typeName = "${resourceNameUppercase}",
        service = service,
        mapper = mapper
    )
