package cl.duoc.entrenadores.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "entrenadores")
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nombre no puede estar vacio.")
    @Size(max = 20, message = "Nombre solo puede tener un maximo de 20 caracteres")
    private String nombre;

    @NotBlank(message = "Apellido no puede estar vacio.")
    @Size(max = 20, message = "Apellido solo puede tener un maximo de 20 caracteres")
    private String apellido;

    @NotBlank
    private String region;

    @NotNull
    private Integer nivel;

    @Column(name = "id_usuario_seguridad")
    private Long idUsuarioSeguridad;
}
