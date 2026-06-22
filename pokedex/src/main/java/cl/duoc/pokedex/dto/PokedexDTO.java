package cl.duoc.pokedex.dto;

import lombok.Data;

@Data
public class PokedexDTO {
    private Long idEspecie;
    private String nombrePokemon;
    private String tipoPrimario;
    private String tipoSecundario;
    private Integer puntosVidaBase;
}
