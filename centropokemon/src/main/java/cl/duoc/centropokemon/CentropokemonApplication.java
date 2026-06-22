package cl.duoc.centropokemon;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@OpenAPIDefinition(
		info = @Info(
				title = "Centro Pokemon",
				description = "Api liga pokemon, servicio centro pokemon",
				version = "1.0.1",
				contact = @Contact(
						name = "vicente",
						email = "vi.vilchesr@duocuc.cl"
				)
		)

)
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CentropokemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentropokemonApplication.class, args);
	}

}
