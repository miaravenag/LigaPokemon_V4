package cl.duoc.acceso_seguridad.mapper;

import cl.duoc.acceso_seguridad.dto.AcsSeguridadDTO;
import cl.duoc.acceso_seguridad.model.AcsSeguridad;
import org.springframework.stereotype.Component;

@Component
public class AcsSeguridadMapper {
    public AcsSeguridadDTO toDTO(AcsSeguridad entity) {
        if (entity == null) return null;
        AcsSeguridadDTO dto = new AcsSeguridadDTO();
        dto.setId(entity.getIdUsuario());
        dto.setNombreUsuario(entity.getNombreUsuario());
        dto.setRolAsignado(entity.getRolAsignado());
        return dto;
    }
}
