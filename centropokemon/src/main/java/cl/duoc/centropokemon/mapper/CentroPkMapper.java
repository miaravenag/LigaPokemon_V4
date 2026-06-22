package cl.duoc.centropokemon.mapper;

import cl.duoc.centropokemon.dto.CentroPkDTO;
import cl.duoc.centropokemon.model.CentroPk;
import org.springframework.stereotype.Component;

@Component
public class CentroPkMapper {

    public CentroPkDTO toDTO(CentroPk entidad) {
        if (entidad == null) return null;
        CentroPkDTO dto = new CentroPkDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setCiudad(entidad.getCiudad());
        dto.setRegion(entidad.getRegion());
        dto.setDireccion(entidad.getDireccion());
        dto.setTotalAtenciones(entidad.getTotalAtenciones());
        dto.setDisponible(entidad.isDisponible());
        return dto;
    }

    public CentroPk toEntity(CentroPkDTO dto) {
        if (dto == null) return null;
        CentroPk entidad = new CentroPk();
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setCiudad(dto.getCiudad());
        entidad.setRegion(dto.getRegion());
        entidad.setDireccion(dto.getDireccion());
        entidad.setTotalAtenciones(dto.getTotalAtenciones());
        entidad.setDisponible(dto.isDisponible());
        return entidad;
    }
}
