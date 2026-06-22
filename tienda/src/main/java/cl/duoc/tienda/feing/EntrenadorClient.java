package cl.duoc.tienda.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "entrenadores", path = "/api/v1/entrenadores")
public interface EntrenadorClient {
    @GetMapping("/{id}")
    Object getEntrenadorById(@PathVariable("id") Long id);
}
