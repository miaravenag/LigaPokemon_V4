package cl.duoc.medallas.mapper;

import cl.duoc.medallas.dto.MedallasDTO;
import cl.duoc.medallas.model.Medalla;
import org.springframework.stereotype.Component;

@Component
public class MedallasMapper {
    public MedallasDTO toDTO(Medalla entity) {
        if (entity == null) return null;
        MedallasDTO dto = new MedallasDTO();
        dto.setNombreMedalla(entity.getNombreMedalla());
        dto.setEsOficial(entity.getEsOficial());
        dto.setNombreEntrenador(dto.getNombreEntrenador());
        dto.setRegionEntrenador(dto.getRegionEntrenador());
        return dto;
    }
}
