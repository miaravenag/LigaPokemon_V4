package cl.duoc.acceso_seguridad.feign;

import cl.duoc.acceso_seguridad.dto.EntrenadorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "entrenadores", path = "/api/v1/entrenadores")
public interface EntrenadorFeing {

    @GetMapping("/por-seguridad/{idUsuario}")
    EntrenadorDTO obtenerPerfilPorSeguridadId(@PathVariable Long idUsuario);
}

