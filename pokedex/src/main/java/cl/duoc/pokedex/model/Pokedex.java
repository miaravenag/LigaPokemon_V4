package cl.duoc.pokedex.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ms_pokedex_nacional")
@NoArgsConstructor
@AllArgsConstructor
public class Pokedex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especie")
    private Long idEspecie;

    @NotBlank
    @Size(max = 80)
    @Column(name = "nombre_pokemon", unique = true, nullable = false, length = 80)
    private String nombrePokemon;

    @NotBlank
    @Size(max = 30)
    @Column(name = "tipo_primario", nullable = false, length = 30)
    private String tipoPrimario;

    @Size(max = 30)
    @Column(name = "tipo_secundario", length = 30)
    private String tipoSecundario;

    @NotNull
    @Column(name = "puntos_vida_base", nullable = false)
    private Integer puntosVidaBase;
}
