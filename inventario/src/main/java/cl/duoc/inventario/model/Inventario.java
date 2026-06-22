package cl.duoc.inventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(
        name = "ms_inventario_mochila",
        uniqueConstraints = @UniqueConstraint(columnNames = {"uuid_entrenador", "id_articulo"})
)
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Long idRegistro;

    @NotBlank
    @Column(name = "uuid_entrenador", length = 36, nullable = false)
    private String uuidEntrenador;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_articulo", nullable = false)
    private Articulo articulo;

    @NotNull
    @Column(name = "cantidad_disponible", nullable = false)
    private Integer cantidadDisponible;
}
