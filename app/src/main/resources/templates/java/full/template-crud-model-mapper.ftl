package ${packageName};

import dev.akif.crud.CRUDDTOMapper;
import dev.akif.crud.CRUDMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;
<#if idType["import"]?has_content>
import ${idType["import"]};
</#if>

@Component
public class ${resourceNameUppercase}Mapper implements CRUDMapper<${idType["type"]}, ${resourceNameUppercase}Entity, ${resourceNameUppercase}, Create${resourceNameUppercase}, Update${resourceNameUppercase}>, CRUDDTOMapper<${idType["type"]}, ${resourceNameUppercase}, ${resourceNameUppercase}DTO, Create${resourceNameUppercase}, Update${resourceNameUppercase}, Create${resourceNameUppercase}DTO, Update${resourceNameUppercase}DTO> {
    @Override
    public ${resourceNameUppercase}DTO modelToDTO(final ${resourceNameUppercase} author) {
        return new ${resourceNameUppercase}DTO(author.id(), author.name(), author.birthDate(), author.createdAt(), author.updatedAt());
    }

    @Override
    public Create${resourceNameUppercase} createDTOToCreateModel(final Create${resourceNameUppercase}DTO create${resourceNameUppercase}DTO) {
        return new Create${resourceNameUppercase}(create${resourceNameUppercase}DTO.name(), create${resourceNameUppercase}DTO.birthDate());
    }

    @Override
    public Update${resourceNameUppercase} updateDTOToUpdateModel(final Update${resourceNameUppercase}DTO update${resourceNameUppercase}DTO) {
        return new Update${resourceNameUppercase}(update${resourceNameUppercase}DTO.name(), update${resourceNameUppercase}DTO.birthDate());
    }

    @Override
    public ${resourceNameUppercase}Entity entityToBeCreatedFrom(final Create${resourceNameUppercase} create${resourceNameUppercase}, final Instant now) {
        return new ${resourceNameUppercase}Entity(create${resourceNameUppercase}.name(), create${resourceNameUppercase}.birthDate(), now);
    }

    @Override
    public ${resourceNameUppercase} entityToModel(final ${resourceNameUppercase}Entity authorEntity) {
        return new ${resourceNameUppercase}(
                authorEntity.getId(),
                authorEntity.getName(),
                authorEntity.getBirthDate(),
                authorEntity.getVersion(),
                authorEntity.getCreatedAt(),
                authorEntity.getUpdatedAt(),
                authorEntity.getDeletedAt()
        );
    }

    @Override
    public void updateEntityWith(final ${resourceNameUppercase}Entity authorEntity, final Update${resourceNameUppercase} update${resourceNameUppercase}) {
        authorEntity.setName(update${resourceNameUppercase}.name());
        authorEntity.setBirthDate(update${resourceNameUppercase}.birthDate());
    }
}
