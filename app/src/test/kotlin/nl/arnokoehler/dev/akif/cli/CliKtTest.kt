package nl.arnokoehler.dev.akif.cli

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CliKtTest {
    @Test
    fun appHasAGreeting() {
        val classUnderTest = CliApp()
        assertEquals(file, classUnderTest.writeFile())
    }
}

val file = """
    package nl.arnokoehler.dev.akif.cli.template;

    import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class ExampleController extends CRUDController<
      Long,
      ExampleEntity,
      ExampleModel,
      ExampleDTO,
      ExampleCreateModel,
      ExampleUpdateModel,
      ExampleCreateDTO,
      ExampleUpdateDTO,
      ExampleMapper,
      ExampleQDTOMapper,
      ExampleService> {

      public MyController(ExampleService service, ExampleDTOMapper dtoMapper) {
        super(service, dtoMapper);
      }
    }

""".trimIndent()

