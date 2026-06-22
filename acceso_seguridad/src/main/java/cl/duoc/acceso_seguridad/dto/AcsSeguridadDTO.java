package cl.duoc.acceso_seguridad.dto;

import lombok.Data;

@Data
public class AcsSeguridadDTO {
    private Long id;
    private String nombreUsuario;
    private String rolAsignado;
    private String nombreCompletoEntrenador;
    private String regionOrigenEntrenador;
}
