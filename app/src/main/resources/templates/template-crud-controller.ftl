package nl.arnokoehler.dev.akif.cli.template;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ${domainName}Controller extends CRUDController<
  Long,
  ${domainName}Entity,
  ${domainName}Model,
  ${domainName}DTO,
  ${domainName}CreateModel,
  ${domainName}UpdateModel,
  ${domainName}CreateDTO,
  ${domainName}UpdateDTO,
  ${domainName}Mapper,
  ${domainName}QDTOMapper,
  ${domainName}Service> {

  public MyController(${domainName}Service service, ${domainName}DTOMapper dtoMapper) {
    super(service, dtoMapper);
  }
}
