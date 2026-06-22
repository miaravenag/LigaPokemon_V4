package cl.duoc.entrenadores.mapper;

import cl.duoc.entrenadores.dto.EntrenadorDTO;
import cl.duoc.entrenadores.model.Entrenador;
import org.springframework.stereotype.Component;

@Component
public class EntrenadorMapper {
    public EntrenadorDTO toDTO(Entrenador entrenador) {
        if (entrenador == null) return null;
        EntrenadorDTO dto = new EntrenadorDTO();
        dto.setId(entrenador.getId());
        dto.setNombre(entrenador.getNombre());
        dto.setApellido(entrenador.getApellido());
        dto.setNombreCompleto(entrenador.getNombre() + " " + entrenador.getApellido());
        dto.setRegion(entrenador.getRegion());
        dto.setNivel(entrenador.getNivel());
        return dto;
    }
}
