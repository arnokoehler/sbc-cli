package dev.akif.library;

import dev.akif.crud.common.InstantProvider;
import dev.akif.crud.error.CRUDErrorHandler;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@OpenAPIDefinition(
        info = @Info(
                title = "${resourceNameUppercase} API",
                version = "1.0.0",
                description = "An API for a ${resourceNameUppercase}, capable of managing ${resourceNameUppercase}",
                contact = @Contact(
                        name = "",
                        url = ""
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                )
        )
)
@RestControllerAdvice
@SpringBootApplication
public class Main implements CRUDErrorHandler {
    @Bean
    public InstantProvider instantProvider() {
        return InstantProvider.getUtc();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
