package cl.duoc.tienda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "ms_tienda")
@NoArgsConstructor
@AllArgsConstructor
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Long idTransaccion;

    @NotBlank
    @Column(name = "id_comprador", length = 36, nullable = false)
    private String idComprador;

    @NotNull
    @Column(name = "id_articulo", nullable = false)
    private Long idArticulo;

    @NotNull
    @Column(name = "precio_monedas", nullable = false)
    private int precioMonedas;

    @Column(name = "fecha_transaccion", nullable = false, updatable = false)
    private LocalDate fechaTransaction;

}
