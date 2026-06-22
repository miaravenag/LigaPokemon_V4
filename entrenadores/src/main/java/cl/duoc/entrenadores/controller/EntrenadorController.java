package cl.duoc.entrenadores.controller;

import cl.duoc.entrenadores.dto.EntrenadorDTO;
import cl.duoc.entrenadores.exception.ErrorResponse;
import cl.duoc.entrenadores.service.EntrenadorService;
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

import java.util.List;

@RestController
@RequestMapping("/api/v1/entrenadores")
@RequiredArgsConstructor
@Tag(name = "Entrenadores", description = "Metodos Relacionados con los Entrenadores")
public class EntrenadorController {

    private final EntrenadorService service;

    // FIND ALL
    @GetMapping
    @Operation(summary = "Obtener todos los Entrenadores", description = "Metodo que entrega una lista con todos los entrenadores")
    @ApiResponse(responseCode = "200", description = "Entrenadores listados correctamente", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EntrenadorDTO.class))))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }


    // FIND BY ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener entrenador por ID", description = "Metodo que busca un entrenador específico mediante su identificador único")
    @ApiResponse(responseCode = "200", description = "Entrenador encontrado correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EntrenadorDTO.class)))
    @ApiResponse(responseCode = "404", description = "Entrenador no encontrado", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> findByI(@PathVariable Long id) {
        if (service.findById(id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(service.findById(id));
    }

    // SAVE
    @PostMapping
    @Operation(summary = "Crear un nuevo Entrenador", description = "Metodo que registra un nuevo entrenador en el sistema")
    @ApiResponse(responseCode = "201", description = "Entrenador creado exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EntrenadorDTO.class)))
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> save(@RequestBody EntrenadorDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un Entrenador", description = "Metodo que elimina un entrenador mediante su ID")
    @ApiResponse(responseCode = "204", description = "Entrenador eliminado correctamente", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // UPDATE
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un Entrenador", description = "Metodo que actualiza los datos de un entrenador existente usando su ID")
    @ApiResponse(responseCode = "200", description = "Entrenador actualizado correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EntrenadorDTO.class)))
    @ApiResponse(responseCode = "400", description = "Datos de actualización inválidos", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EntrenadorDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
