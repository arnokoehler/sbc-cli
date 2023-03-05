package ${packageName};

import dev.akif.crud.CRUDUpdateDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record Update${resourceNameUppercase}DTO(
        @NotBlank String name,
        @NotNull LocalDate birthDate
) implements CRUDUpdateDTO {
}
