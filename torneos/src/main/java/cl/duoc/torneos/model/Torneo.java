package cl.duoc.torneos.model;

import cl.duoc.torneos.dto.TorneoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ms_torneos")
@NoArgsConstructor
@AllArgsConstructor
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_torneo")
    private Long idTorneo;

    @NotBlank
    @Size(min = 20,max = 150)
    @Column(name = "nombre_evento", nullable = false, length = 150)
    private String nombreEvento;

    @NotNull
    @Column(name = "medallas_minimas_requeridas", nullable = false)
    private Integer medallasMinimasRequeridas;

    @NotBlank
    @Pattern(regexp = "^(ABIERTA|CERRADA|EN_CURSO|FINALIZADA)$")
    @Column(name = "estado_convocatoria", nullable = false, length = 30)
    private String estadoConvocatoria;

    @ManyToOne
    @JoinColumn(name = "id_inscripcion_id_inscripcion")
    private Inscripcion idInscripcion;

}
