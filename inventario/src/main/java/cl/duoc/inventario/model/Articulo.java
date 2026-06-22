package cl.duoc.inventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ms_articulos_catalogo")
@NoArgsConstructor
@AllArgsConstructor
public class Articulo {
    @Id
    @Column(name = "id_articulo")
    private Long idArticulo;

    @NotBlank
    @Size(max = 50)
    @Column(name = "nombre_articulo", unique = true, nullable = false, length = 50)
    private String nombreArticulo;

    @Size(max = 150)
    @Column(name = "descripcion", length = 150)
    private String descripcion;
}
