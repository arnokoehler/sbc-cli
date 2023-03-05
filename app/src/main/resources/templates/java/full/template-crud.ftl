package ${packageName};

import dev.akif.crud.CRUDModel;

import java.time.Instant;
import java.time.LocalDate;
<#if idType["import"]?has_content>
import ${idType["import"]};
</#if>

public record ${resourceNameUppercase}(
        ${idType["type"]} id,
        String name,
        LocalDate birthDate,
        int version,
        Instant createdAt,
        Instant updatedAt,
        Instant deletedAt
) implements CRUDModel<${idType["type"]}> {
}
