package ${packageName}

import dev.akif.crud.CRUDCreateDTO

data class Create${resourceNameUppercase}DTO(val name: String, val breed: String, val age: Int) : CRUDCreateDTO
