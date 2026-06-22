package cl.duoc.medallas.feign;

import cl.duoc.medallas.dto.EntrenadorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "entrenadores", path = "/api/v1/entrenadores/")
public interface EntrenadorFeing {
    @GetMapping("/{id}")
    EntrenadorDTO obtenerNombrePorId(@PathVariable("id") Long id);}
