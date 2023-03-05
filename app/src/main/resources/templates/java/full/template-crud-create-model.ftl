package ${packageName};

import dev.akif.crud.CRUDCreateModel;

import java.time.LocalDate;

public record Create${resourceNameUppercase}(String name, LocalDate birthDate) implements CRUDCreateModel {
}
