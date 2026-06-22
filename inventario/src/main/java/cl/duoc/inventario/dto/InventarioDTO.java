package cl.duoc.inventario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InventarioDTO {
    private Long idRegistro;
    private String uuidEntrenador;
    private Long idArticulo;
    private String nombreArticulo;
    private Integer cantidadDisponible;
}