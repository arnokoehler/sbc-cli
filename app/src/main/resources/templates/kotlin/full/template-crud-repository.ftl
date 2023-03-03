package ${packageName}

import dev.akif.crud.CRUDRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ${resourceNameUppercase}Repository : CRUDRepository<UUID, ${resourceNameUppercase}Entity>
