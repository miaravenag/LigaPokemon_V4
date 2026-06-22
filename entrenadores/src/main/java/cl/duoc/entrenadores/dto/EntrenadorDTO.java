package cl.duoc.entrenadores.dto;

import lombok.Data;

@Data
public class EntrenadorDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String nombreCompleto;
    private String region;
    private Integer nivel;
}
