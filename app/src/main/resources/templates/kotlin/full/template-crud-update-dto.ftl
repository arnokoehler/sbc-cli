package ${packageName}

import dev.akif.crud.CRUDUpdateDTO

data class Update${resourceNameUppercase}DTO(val name: String, val age: Int) : CRUDUpdateDTO
