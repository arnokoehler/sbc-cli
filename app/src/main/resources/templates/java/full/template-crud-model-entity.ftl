package ${packageName};

import dev.akif.crud.CRUDEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDate;
<#if idType["import"]?has_content>
import ${idType["import"]};
</#if>

@Entity
@Getter
@Setter
@Table(name = "authors")
@ToString(callSuper = true)
public class ${resourceNameUppercase}Entity extends CRUDEntity<${idType["type"]}> {
    private String name;
    private LocalDate birthDate;

    public ${resourceNameUppercase}Entity(
            final ${idType["type"]} id,
            final String name,
            final LocalDate birthDate,
            final int version,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        super(id, version, createdAt, updatedAt, deletedAt);
        this.name = name;
        this.birthDate = birthDate;
    }

    public ${resourceNameUppercase}Entity(final String name, final LocalDate birthDate, final Instant now) {
        this(${idType["type"]}.random${idType["type"]}(), name, birthDate, 0, now, now, null);
    }

    public ${resourceNameUppercase}Entity() {
        this(null, null, null);
    }
}
