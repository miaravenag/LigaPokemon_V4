package cl.duoc.inventario.mapper;

import cl.duoc.inventario.dto.InventarioDTO;
import cl.duoc.inventario.model.Inventario;
import org.springframework.stereotype.Component;

@Component
public class InventarioMapper {
    public InventarioDTO toDTO(Inventario entity) {
        if (entity == null) return null;
        InventarioDTO dto = new InventarioDTO();
        dto.setIdRegistro(entity.getIdRegistro());
        dto.setUuidEntrenador(entity.getUuidEntrenador());
        dto.setCantidadDisponible(entity.getCantidadDisponible());
        dto.setIdArticulo(entity.getArticulo().getIdArticulo());
        dto.setNombreArticulo(entity.getArticulo().getNombreArticulo());
        return dto;
    }
}
