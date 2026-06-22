package cl.duoc.inventario.controller;

import cl.duoc.inventario.dto.InventarioDTO;
import cl.duoc.inventario.exception.ErrorResponse;
import cl.duoc.inventario.service.InventarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventario")
@RequiredArgsConstructor
@Tag(name = "Inventario", description = "Metodos Relacionados con el Inventario")
public class InventarioController {

    private final InventarioService service;

    // FIND ALL
    @GetMapping
    @Operation(summary = "Obtener todo el Inventario", description = "Metodo que entrega una lista con todos los registros del inventario")
    @ApiResponse(responseCode = "200", description = "Inventario listado correctamente", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = InventarioDTO.class))))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // FIND BY ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener inventario por ID", description = "Metodo que busca un registro específico del inventario mediante su identificador único")
    @ApiResponse(responseCode = "200", description = "Registro encontrado correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InventarioDTO.class)))
    @ApiResponse(responseCode = "404", description = "Registro no encontrado", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> findById(@PathVariable Long id) {
        if (service.findById(id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(service.findById(id));
    }

    // SAVE
    @PostMapping
    @Operation(summary = "Crear un nuevo registro en el Inventario", description = "Metodo que registra un nuevo ítem en el inventario")
    @ApiResponse(responseCode = "201", description = "Registro creado exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InventarioDTO.class)))
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> save(@RequestBody InventarioDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    // UPDATE
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un registro del Inventario", description = "Metodo que actualiza los datos de un ítem existente en el inventario usando su ID")
    @ApiResponse(responseCode = "200", description = "Registro actualizado correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InventarioDTO.class)))
    @ApiResponse(responseCode = "400", description = "Datos de actualización inválidos", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody InventarioDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un registro del Inventario", description = "Metodo que elimina un ítem del inventario mediante su ID")
    @ApiResponse(responseCode = "204", description = "Registro eliminado correctamente", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}