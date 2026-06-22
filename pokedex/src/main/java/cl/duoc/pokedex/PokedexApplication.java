package cl.duoc.pokedex;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@OpenAPIDefinition(
		info = @Info(
				title = "Pokedex",
				description = "Api liga pokemon, servicio pokedex",
				version = "1.0.1",
				contact = @Contact(
						name = "Miguel Aravena",
						email = "mi.aravenag@duocuc.cl"
				)
		)

)
@EnableDiscoveryClient
@SpringBootApplication
public class PokedexApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokedexApplication.class, args);
	}

}
