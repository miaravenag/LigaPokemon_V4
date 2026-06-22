package cl.duoc.acceso_seguridad.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ms_acceso_y_seguridad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcsSeguridad {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id_usuario")
 private Long idUsuario;

 @NotBlank
 @Size(min = 4, max = 20)
 @Column(name = "nombre_usuario", unique = true, nullable = false, length = 20)
 private String nombreUsuario;

 @NotBlank
 @Size(min = 20, max = 40)
 @Column(name = "contrasena_encriptada", nullable = false, length = 40)
 private String contrasenaEncriptada;

 @NotBlank
 @Pattern(regexp = "^(ADMIN|OPERADOR|ENTRENADOR)$")
 @Column(name = "rol_asignado", nullable = false, length = 20)
 private String rolAsignado;
}
