package cl.duoc.medallas.controller;

import cl.duoc.medallas.dto.MedallasDTO;
import cl.duoc.medallas.exception.ErrorResponse;
import cl.duoc.medallas.model.Medalla;
import cl.duoc.medallas.service.MedallasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medallas/")
@Tag(name = "Medallas", description = "Metodos Relacionados con las Medallas")
public class MedallasController {

    @Autowired
    private MedallasService medallasService;

    // 1. FIND ALL
    @GetMapping
    @Operation(summary = "Obtener todas las Medallas", description = "Metodo que entrega una lista simple con todas las medallas")
    @ApiResponse(responseCode = "200", description = "Medallas listadas correctamente", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Medalla.class))))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(medallasService.finndAll());
    }

    // 2. FIND BY ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener medalla por ID", description = "Metodo que busca una medalla específica mediante su identificador único")
    @ApiResponse(responseCode = "200", description = "Medalla encontrada correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Medalla.class)))
    @ApiResponse(responseCode = "404", description = "Medalla no encontrada", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Medalla medalla = medallasService.findById(id);
        if (medalla == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(medalla);
    }

    // 3. SAVE
    @PostMapping
    @Operation(summary = "Crear una nueva Medalla", description = "Metodo que registra una nueva medalla en el sistema y la asocia a un entrenador")
    @ApiResponse(responseCode = "201", description = "Medalla creada exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MedallasDTO.class)))
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> save(@RequestBody MedallasDTO dto, @RequestParam String idEntrenador) {
        return new ResponseEntity<>(medallasService.save(dto, idEntrenador), HttpStatus.CREATED);
    }

    // 4. FIND ALL DETALLADO
    @GetMapping("/detallado")
    @Operation(summary = "Obtener todas las Medallas (Detallado)", description = "Metodo que entrega una lista detallada con todas las medallas (DTO)")
    @ApiResponse(responseCode = "200", description = "Medallas detalladas listadas correctamente", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MedallasDTO.class))))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> listarDetallado() {
        return ResponseEntity.ok(medallasService.listarDetallado());
    }

    // 5. DELETE
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una Medalla", description = "Metodo que elimina una medalla mediante su ID")
    @ApiResponse(responseCode = "204", description = "Medalla eliminada correctamente", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> delete(@PathVariable Long id) {
        medallasService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // 6. UPDATE
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una Medalla", description = "Metodo que actualiza los datos de una medalla existente usando su ID")
    @ApiResponse(responseCode = "200", description = "Medalla actualizada correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MedallasDTO.class)))
    @ApiResponse(responseCode = "400", description = "Datos de actualización inválidos", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Medalla medallaActualizada) {
        return ResponseEntity.ok(medallasService.update(id, medallaActualizada));
    }
}
