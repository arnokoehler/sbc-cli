package ${packageName}

import dev.akif.crud.CRUDCreateModel

data class Create${resourceNameUppercase}(val name: String, val breed: String, val age: Int) : CRUDCreateModel
