package cl.duoc.pokedex.mapper;

import cl.duoc.pokedex.dto.PokedexDTO;
import cl.duoc.pokedex.model.Pokedex;
import org.springframework.stereotype.Component;

@Component
public class PokedexMapper {
    public PokedexDTO toDTO(Pokedex entity) {
        if (entity == null) return null;
        PokedexDTO dto = new PokedexDTO();
        dto.setIdEspecie(entity.getIdEspecie());
        dto.setNombrePokemon(entity.getNombrePokemon());
        dto.setTipoPrimario(entity.getTipoPrimario());
        dto.setTipoSecundario(entity.getTipoSecundario());
        dto.setPuntosVidaBase(entity.getPuntosVidaBase());
        return dto;
    }
}
