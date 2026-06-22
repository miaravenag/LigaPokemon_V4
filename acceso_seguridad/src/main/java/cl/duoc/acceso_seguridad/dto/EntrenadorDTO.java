package cl.duoc.acceso_seguridad.dto;

import lombok.Data;

@Data
public class EntrenadorDTO {
    private String idEntrenador;
    private String nombreCompleto;
    private String regionOrigen;
    private Integer nivelRango;
}
