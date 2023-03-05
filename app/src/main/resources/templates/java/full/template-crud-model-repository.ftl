package ${packageName};

import dev.akif.crud.CRUDRepository;
import org.springframework.stereotype.Repository;

<#if idType["import"]?has_content>
import ${idType["import"]};
</#if>

@Repository
public interface ${resourceNameUppercase}Repository extends CRUDRepository<${idType["type"]}, ${resourceNameUppercase}Entity> {
}
