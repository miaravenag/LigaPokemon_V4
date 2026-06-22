package cl.duoc.torneos.mapper;

import cl.duoc.torneos.dto.InscripcionDTO;
import cl.duoc.torneos.dto.TorneoDTO;

import cl.duoc.torneos.model.Torneo;
import org.springframework.stereotype.Component;

@Component
public class TorneoMapper {
    public TorneoDTO toDTO(Torneo entity) {
        if (entity == null) return null;
        TorneoDTO dto = new TorneoDTO();
        InscripcionDTO inDTO= new InscripcionDTO();

        dto.setIdTorneo(entity.getIdTorneo());
        dto.setNombreEvento(entity.getNombreEvento());
        dto.setMedallasMinimasRequeridas(entity.getMedallasMinimasRequeridas());
        dto.setEstadoConvocatoria(entity.getEstadoConvocatoria());

        dto.setFechaInscripcion(entity.getIdInscripcion().getFechaInscripcion());

        return dto;
    }
}
