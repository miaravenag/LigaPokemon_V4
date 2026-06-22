package cl.duoc.centropokemon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "centro_pk")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CentroPk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String region;

    @Column
    private String direccion;

    @Column
    private int totalAtenciones;

    @Column
    private boolean disponible;
}