package cl.duoc.torneos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(
        name = "ms_torneos_inscripciones",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id_torneo", "uuid_entrenador"})}
)
@NoArgsConstructor
@AllArgsConstructor
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Long idInscripcion;

    @ManyToOne
    @JoinColumn(name = "torneo_id_torneo")
    @NotNull
    private Torneo torneo;

    @NotBlank
    @Column(name = "uuid_entrenador", length = 36, nullable = false)
    private String uuidEntrenador;

    @Column(name = "fecha_inscripcion", nullable = false, updatable = false)
    private LocalDate fechaInscripcion;

}
