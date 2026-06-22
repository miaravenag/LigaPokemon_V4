package cl.duoc.centropokemon.FeingClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "entrenadores", path = "/api/v1/entrenadores")
public interface CentroClient {
    @GetMapping("/{id}")
    Object getEntrenadorById(@PathVariable Long id);
}


