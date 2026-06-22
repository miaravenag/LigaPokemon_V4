package cl.duoc.tienda.mapper;

import cl.duoc.tienda.feing.EntrenadorClient;
import cl.duoc.tienda.feing.PokedexClient;
import cl.duoc.tienda.dto.TiendaDTO;
import cl.duoc.tienda.model.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class TiendaMapper {

    @Autowired
    private EntrenadorClient entrenadorClient;

    @Autowired
    private PokedexClient pokedexClient;

    public TiendaDTO toDTO(Tienda entity) {
        if (entity == null) return null;

        TiendaDTO dto = new TiendaDTO();
        dto.setIdTransaccion(entity.getIdTransaccion());
        dto.setPrecioMonedas(entity.getPrecioMonedas());
        dto.setFechaTransaccion(entity.getFechaTransaction());


        try {
            Map<String, Object> entrenador = (Map<String, Object>) entrenadorClient.getEntrenadorById(Long.valueOf(entity.getIdComprador()));
            dto.setNombreComprador(entrenador.get("nombre").toString());
        } catch (Exception e) {
            dto.setNombreComprador("Desconocido (ID: " + entity.getIdComprador() + ")");
        }


        try {
            Map<String, Object> pokemon = (Map<String, Object>) pokedexClient.getPokemonById(entity.getIdArticulo());
            dto.setNombreArticulo(pokemon.get("nombre").toString());
        } catch (Exception e) {
            dto.setNombreArticulo("Artículo #" + entity.getIdArticulo());
        }

        return dto;
    }
}
