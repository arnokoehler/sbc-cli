package ${packageName};

import dev.akif.crud.CRUDUpdateModel;

import java.time.LocalDate;

public record Update${resourceNameUppercase}(String name, LocalDate birthDate) implements CRUDUpdateModel {
}
