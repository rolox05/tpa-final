package tpaPrueba;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
    info = @Info(
        title = "API Persona TPA 2020",
        version = "0.0",
        description = "Ejercicio de portar proyecto realizado con springboot a micronaut manteniendo la estructura general de clases",
        license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"),
        contact = @Contact(url = "https://gigantic-server.com", name = "TPA FRM UTN", email = "Fred@gigagantic-server.com")
    )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);

    }
}
