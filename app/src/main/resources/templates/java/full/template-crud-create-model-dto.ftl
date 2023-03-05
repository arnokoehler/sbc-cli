package ${packageName};

import dev.akif.crud.CRUDCreateDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record Create${resourceNameUppercase}DTO(
        @NotBlank String name,
        @NotNull LocalDate birthDate
) implements CRUDCreateDTO {
}
