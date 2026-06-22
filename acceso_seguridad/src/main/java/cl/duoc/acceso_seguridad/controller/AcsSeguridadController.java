package cl.duoc.acceso_seguridad.controller;

import cl.duoc.acceso_seguridad.dto.AcsSeguridadDTO;
import cl.duoc.acceso_seguridad.exception.ErrorResponse;
import cl.duoc.acceso_seguridad.model.AcsSeguridad;
import cl.duoc.acceso_seguridad.service.AcsSeguridadService;
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

import java.util.List;

@RestController
@RequestMapping("/api/v1/acceso-seguridad/")
@Tag(name = "Acceso y Seguridad", description = "Metodos Relacionados con la Seguridad y Acceso de Usuarios")
public class AcsSeguridadController {
    @Autowired
    private AcsSeguridadService seguridadService;

    // FIND ALL
    @GetMapping
    @Operation(summary = "Obtener todos los accesos", description = "Metodo que entrega una lista con todos los registros de seguridad/usuarios")
    @ApiResponse(responseCode = "200", description = "Registros listados correctamente", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AcsSeguridad.class))))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(seguridadService.findAll());
    }

    // FIND BY ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener acceso por ID", description = "Metodo que busca un usuario/acceso específico mediante su identificador único")
    @ApiResponse(responseCode = "200", description = "Registro encontrado correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AcsSeguridad.class)))
    @ApiResponse(responseCode = "404", description = "Registro no encontrado", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> findById(@PathVariable Long id) {
        AcsSeguridad registro = seguridadService.findById(id);
        if (registro == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(registro);
    }

    // SAVE
    @PostMapping
    @Operation(summary = "Crear un nuevo acceso", description = "Metodo que registra un nuevo usuario con su contraseña en el sistema")
    @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AcsSeguridadDTO.class)))
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> save(@RequestBody AcsSeguridadDTO dto, @RequestParam String contrasena) {
        return new ResponseEntity<>(seguridadService.save(dto, contrasena), HttpStatus.CREATED);
    }

    // UPDATE
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un acceso", description = "Metodo que actualiza los datos de un usuario existente usando su ID")
    @ApiResponse(responseCode = "200", description = "Usuario actualizado correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AcsSeguridadDTO.class)))
    @ApiResponse(responseCode = "400", description = "Datos de actualización inválidos", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AcsSeguridad datosNuevos) {
        return ResponseEntity.ok(seguridadService.update(id, datosNuevos));
    }

    // DELETE
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un acceso", description = "Metodo que elimina un usuario/acceso mediante su ID")
    @ApiResponse(responseCode = "204", description = "Usuario eliminado correctamente", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> delete(@PathVariable Long id) {
        seguridadService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
