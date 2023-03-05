package ${packageName};

import dev.akif.crud.CRUDDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.time.LocalDate;
<#if idType["import"]?has_content>
import ${idType["import"]};
</#if>

public record ${resourceNameUppercase}DTO(
        @NotNull ${idType["type"]} id,
        @NotBlank String name,
        @NotNull LocalDate birthDate,
        @NotNull Instant createdAt,
        @NotNull Instant updatedAt
) implements CRUDDTO<${idType["type"]}> {
}
