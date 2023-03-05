package ${packageName};

import dev.akif.crud.CRUDRepository;
import dev.akif.crud.CRUDService;
import dev.akif.crud.common.InstantProvider;
import org.springframework.stereotype.Service;

<#if idType["import"]?has_content>
import ${idType["import"]};
</#if>

@Service
public class ${resourceNameUppercase}Service extends CRUDService<${idType["type"]}, ${resourceNameUppercase}Entity, ${resourceNameUppercase}, Create${resourceNameUppercase}, Update${resourceNameUppercase}, ${resourceNameUppercase}Repository, ${resourceNameUppercase}Mapper> {
    public ${resourceNameUppercase}Service(final InstantProvider instantProvider,
                         final CRUDRepository<${idType["type"]}, ${resourceNameUppercase}Entity> repository,
                         final ${resourceNameUppercase}Mapper mapper) {
        super("${resourceNameUppercase}", instantProvider, repository, mapper);
    }
}
