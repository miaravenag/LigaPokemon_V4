package cl.duoc.torneos.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InscripcionDTO {

    private Long idInscripcion;
    private LocalDate fechaInscripcion;
    private String uuidEntrenador;
}
