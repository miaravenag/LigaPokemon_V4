package cl.duoc.centropokemon.controller;

import cl.duoc.centropokemon.dto.CentroPkDTO;
import cl.duoc.centropokemon.exception.ErrorResponse;
import cl.duoc.centropokemon.service.CentroPkdService;
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
@RequestMapping("/centropokemon")
@RequiredArgsConstructor
@Tag(name = "Centros Pokémon", description = "Metodos Relacionados con los Centros Pokémon")
public class CentroPkController {

    private final CentroPkdService centroPkdService;

    // FIND ALL
    @GetMapping
    @Operation(summary = "Obtener todos los Centros Pokémon", description = "Metodo que entrega una lista con todos los centros Pokémon registrados")
    @ApiResponse(responseCode = "200", description = "Centros listados correctamente", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CentroPkDTO.class))))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(centroPkdService.findAll());
    }

    // FIND BY ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener Centro Pokémon por ID", description = "Metodo que busca un centro Pokémon específico mediante su identificador único")
    @ApiResponse(responseCode = "200", description = "Centro encontrado correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CentroPkDTO.class)))
    @ApiResponse(responseCode = "404", description = "Centro no encontrado", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> findById(@PathVariable Long id) {
        CentroPkDTO dto = centroPkdService.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    // SAVE
    @PostMapping
    @Operation(summary = "Crear un nuevo Centro Pokémon", description = "Metodo que registra un nuevo centro Pokémon en el sistema")
    @ApiResponse(responseCode = "201", description = "Centro creado exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CentroPkDTO.class)))
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> save(@RequestBody CentroPkDTO dto) {
        return new ResponseEntity<>(centroPkdService.save(dto), HttpStatus.CREATED);
    }

    // UPDATE
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un Centro Pokémon", description = "Metodo que actualiza los datos de un centro Pokémon existente usando su ID")
    @ApiResponse(responseCode = "200", description = "Centro actualizado correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CentroPkDTO.class)))
    @ApiResponse(responseCode = "400", description = "Datos de actualización inválidos", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CentroPkDTO dto) {
        return ResponseEntity.ok(centroPkdService.update(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un Centro Pokémon", description = "Metodo que elimina un centro Pokémon mediante su ID")
    @ApiResponse(responseCode = "204", description = "Centro eliminado correctamente", content = @Content)
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> delete(@PathVariable Long id) {
        centroPkdService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // CUSTOM: POR CIUDAD
    @GetMapping("/ciudad/{ciudad}")
    @Operation(summary = "Obtener Centros por Ciudad", description = "Metodo que entrega una lista de centros Pokémon filtrados por una ciudad específica")
    @ApiResponse(responseCode = "200", description = "Centros listados correctamente", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CentroPkDTO.class))))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> porCiudad(@PathVariable String ciudad) {
        return ResponseEntity.ok(centroPkdService.findByCiudad(ciudad));
    }

    // CUSTOM: POR REGION
    @GetMapping("/region/{region}")
    @Operation(summary = "Obtener Centros por Región", description = "Metodo que entrega una lista de centros Pokémon filtrados por una región específica")
    @ApiResponse(responseCode = "200", description = "Centros listados correctamente", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CentroPkDTO.class))))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<?> porRegion(@PathVariable String region) {
        return ResponseEntity.ok(centroPkdService.findByRegion(region));
    }

}