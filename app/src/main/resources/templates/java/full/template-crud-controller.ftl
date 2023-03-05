package ${packageName};

import dev.akif.crud.CRUDController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<#if idType["import"]?has_content>
import ${idType["import"]};
</#if>

@RequestMapping("/authors")
@RestController
@Tag(name = "${resourceNameUppercase}s", description = "CRUD operations for author entities")
public class ${resourceNameUppercase}Controller extends CRUDController<
        ${idType["type"]},
        ${resourceNameUppercase}Entity,
        ${resourceNameUppercase},
        ${resourceNameUppercase}DTO,
        Create${resourceNameUppercase},
        Update${resourceNameUppercase},
        Create${resourceNameUppercase}DTO,
        Update${resourceNameUppercase}DTO,
        ${resourceNameUppercase}Mapper,
        ${resourceNameUppercase}Mapper,
        ${resourceNameUppercase}Repository,
        ${resourceNameUppercase}Service> {
    public ${resourceNameUppercase}Controller(final ${resourceNameUppercase}Service service, final ${resourceNameUppercase}Mapper mapper) {
        super("${resourceNameUppercase}", service, mapper);
    }
}
