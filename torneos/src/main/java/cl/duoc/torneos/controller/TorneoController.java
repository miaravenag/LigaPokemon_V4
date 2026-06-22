package cl.duoc.torneos.controller;

import cl.duoc.torneos.exception.ErrorResponse;
import cl.duoc.torneos.model.Torneo;
import cl.duoc.torneos.service.TorneoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/torneos")
@Tag(name = "Torneos", description = "Metodos Relacionados con los Torneos")
public class TorneoController {

    @Autowired
    private TorneoService torService;

    // FIND ALL
    @GetMapping
    @Operation(summary = "Obtener todos los Torneos", description = "Metodo que entrega una lista con todos los torneos")
    @ApiResponse(responseCode = "200", description = "Torneos listados correctamente", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Torneo.class))))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(torService.findAll());
    }

    // FIND BY ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener torneo por ID", description = "Metodo que busca un torneo específico mediante su identificador único")
    @ApiResponse(responseCode = "200", description = "Torneo encontrado correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Torneo.class)))
    @ApiResponse(responseCode = "404", description = "Torneo no encontrado", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> findById(@PathVariable Long id) {
        if (torService.findID(id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(torService.findID(id));
    }

    // SAVE
    @PostMapping
    @Operation(summary = "Crear un nuevo Torneo", description = "Metodo que registra un nuevo torneo en el sistema")
    @ApiResponse(responseCode = "201", description = "Torneo creado exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Torneo.class)))
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> save(@RequestBody Torneo tor) {
        return new ResponseEntity<>(torService.save(tor), HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un Torneo", description = "Metodo que elimina un torneo mediante su ID")
    @ApiResponse(responseCode = "204", description = "Torneo eliminado correctamente", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> delete(@PathVariable Long id) {
        torService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // UPDATE
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un Torneo", description = "Metodo que actualiza los datos de un torneo existente usando su ID")
    @ApiResponse(responseCode = "200", description = "Torneo actualizado correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Torneo.class)))
    @ApiResponse(responseCode = "400", description = "Datos de actualización inválidos", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Torneo tor) {
        return ResponseEntity.ok(torService.update(id, tor));
    }
}
