package cl.duoc.pokedex.controller;

import cl.duoc.pokedex.model.Pokedex;
import cl.duoc.pokedex.service.PokedexService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pokedex")
public class PokedexController {
    @Autowired
    private PokedexService pokeService;

    @GetMapping
    @Operation(summary = "Listar Pokémon", description = "Obtiene la lista completa de todos los Pokémon registrados en la Pokedex")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(pokeService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Pokémon por ID", description = "Busca un Pokémon específico usando su identificador único numérico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pokémon encontrado con éxito"),
            @ApiResponse(responseCode = "404", description = "El Pokémon con el ID proporcionado no existe")
    })
    public ResponseEntity<?> buscarId(@PathVariable Long id) {

        cl.duoc.pokedex.dto.PokedexDTO pokemon = pokeService.findId(id);

        if (pokemon == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pokemon);
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo Pokémon", description = "Añade un nuevo Pokemon a la base de datos de la Pokedex")
    @ApiResponse(responseCode = "201", description = "Pokémon registrado exitosamente")
    public ResponseEntity<?> registrar(@RequestBody Pokedex p) {
        return new ResponseEntity<>(pokeService.save(p), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un Pokémon", description = "Borra el registro de un Pokémon de la Pokedex mediante su ID")
    @ApiResponse(responseCode = "204", description = "Pokémon eliminado con éxito (sin contenido de retorno)")
    public ResponseEntity<?> borrar(@PathVariable Long id) {
        pokeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar datos de un Pokémon", description = "Modifica las características o información de un Pokémon existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pokémon actualizado con éxito"),
            @ApiResponse(responseCode = "404", description = "No se encontró el Pokémon para actualizar")
    })
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Pokedex p) {
        return ResponseEntity.ok(pokeService.update(id, p));
    }
}



