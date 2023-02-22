package nl.arnokoehler.dev.akif.cli

import org.junit.jupiter.api.Test

class FullCliKtTest {
    @Test
    fun appHasAGreeting() {
        val classUnderTest = CliRunner()
        classUnderTest.run()

        TODO("Add assertions")
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

