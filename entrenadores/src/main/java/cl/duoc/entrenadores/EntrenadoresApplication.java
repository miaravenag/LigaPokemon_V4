package cl.duoc.entrenadores;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@OpenAPIDefinition(
		info = @Info(
				title = "API 2026 De Entrenadores",
				version = "1.0",
				description = "Documentacion de la API de Los Entrenadores Registrados",
				contact = @Contact(
						name = "Miguel Aravena",
						email = "mi.aravenaduoc@duoc.cl"
				)

		)
)
@EnableDiscoveryClient
@SpringBootApplication
public class EntrenadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntrenadoresApplication.class, args);
	}

}
