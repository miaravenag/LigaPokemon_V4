package cl.duoc.torneos.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TorneoDTO {

    private Long idTorneo;
    private String nombreEvento;
    private Integer medallasMinimasRequeridas;
    private String estadoConvocatoria;
    private LocalDate fechaInscripcion;
}
