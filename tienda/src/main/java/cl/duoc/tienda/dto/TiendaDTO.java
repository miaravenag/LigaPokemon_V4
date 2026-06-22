package cl.duoc.tienda.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TiendaDTO {
    private Long idTransaccion;
    private String nombreComprador;
    private String nombreArticulo;
    private int precioMonedas;
    private LocalDate fechaTransaccion;
}