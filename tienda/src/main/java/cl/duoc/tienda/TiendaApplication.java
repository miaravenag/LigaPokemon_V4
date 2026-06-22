package cl.duoc.tienda;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@OpenAPIDefinition(
		info = @Info(
				title = "Tienda",
				description = "Api liga pokemon, servicio tienda",
				version = "1.0.1",
				contact = @Contact(
						name = "vicente",
						email = "vi.vilchesr@duocuc.cl"
				)
		)

)
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class TiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);
	}

}
