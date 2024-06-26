package lt.viko.eif.asinkevic.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Arturas Sinkevic",
                        email = "arturas.sinkevic@ad.viko.lt",
                        url= "gmail.com"),
                description = "REST API for MovingCompany.",
                title = "MovingCompany REST",
                version = "1.0.0",
                license = @License(
                        name = "Free To Use",
                        url = "ad.viko.lt")

        ),
        servers = {
                @Server(
                        url = "http://localhost:8082",
                        description = "Local"
                )
        }
)
public class config {

}
