package ${packageName}

import dev.akif.crud.CRUDUpdateModel

data class Update${resourceNameUppercase}(val name: String, val age: Int) : CRUDUpdateModel
