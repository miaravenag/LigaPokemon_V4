package cl.duoc.medallas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@OpenAPIDefinition(
		info = @Info(
				title = "Medallas",
				description = "Api liga pokemon, servicio medallas",
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
public class MedallasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedallasApplication.class, args);
	}

}
