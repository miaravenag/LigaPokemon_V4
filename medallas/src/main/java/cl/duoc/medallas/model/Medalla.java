package cl.duoc.medallas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ms_medallas_gimnasio")
@NoArgsConstructor
@AllArgsConstructor
public class Medalla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Logro")
    private Long idMedalla;

    @NotBlank
    @Column(name = "id_Entrenador", length = 36, nullable = false)
    private String idEntrenador;

    @NotBlank
    @Size(max = 25)
    @Column(name = "nombre_medalla", nullable = false, length = 25)
    private String nombreMedalla;

    @NotNull
    @Column(name = "es_oficial", nullable = false)
    private Boolean esOficial;
}
