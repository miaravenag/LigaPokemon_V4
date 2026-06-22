package cl.duoc.tienda.controller;

import cl.duoc.tienda.dto.TiendaDTO;
import cl.duoc.tienda.exception.ErrorResponse;
import cl.duoc.tienda.model.Tienda;
import cl.duoc.tienda.service.TiendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transacciones")
@Tag(name = "Transacciones (Tienda)", description = "Metodos Relacionados con las Transacciones de la Tienda")
public class TiendaController {

    @Autowired
    private TiendaService tService;

    // FIND BY ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener transacción por ID", description = "Metodo que busca una transacción o tienda específica mediante su identificador único")
    @ApiResponse(responseCode = "200", description = "Transacción encontrada correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TiendaDTO.class)))
    @ApiResponse(responseCode = "404", description = "Transacción no encontrada", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> findById(@PathVariable Long id) {
        TiendaDTO dto = tService.findID(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    // SAVE
    @PostMapping
    @Operation(summary = "Registrar una nueva Transacción", description = "Metodo que registra una nueva transacción/tienda en el sistema")
    @ApiResponse(responseCode = "201", description = "Transacción registrada exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Tienda.class)))
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> save(@Valid @RequestBody Tienda t) {
        return new ResponseEntity<>(tService.save(t), HttpStatus.CREATED);
    }
}