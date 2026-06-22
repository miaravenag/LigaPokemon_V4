package cl.duoc.medallas.dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class MedallasDTO {
    private String nombreEntrenador;
    private String regionEntrenador;
    private String nombreMedalla;
    private Boolean esOficial;
}
