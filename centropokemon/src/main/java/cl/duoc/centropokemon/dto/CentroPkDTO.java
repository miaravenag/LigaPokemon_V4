package cl.duoc.centropokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CentroPkDTO {
    private Long id;
    private String nombre;
    private String ciudad;
    private String region;
    private String direccion;
    private int totalAtenciones;
    private boolean disponible;
}
