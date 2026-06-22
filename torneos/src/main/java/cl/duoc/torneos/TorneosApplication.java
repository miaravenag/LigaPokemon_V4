package cl.duoc.torneos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@OpenAPIDefinition(
		info = @Info(
				title = "Torneos",
				description = "Api liga pokemon, servicio torneos",
				version = "1.0.1",
				contact = @Contact(
						name = "vicente",
						email = "vi.vilchesr@duocuc.cl"
				)
		)

)
@EnableDiscoveryClient
@SpringBootApplication
public class TorneosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TorneosApplication.class, args);
	}

}
