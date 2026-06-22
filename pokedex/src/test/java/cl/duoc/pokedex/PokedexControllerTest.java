package cl.duoc.pokedex;

import cl.duoc.pokedex.controller.PokedexController;
import cl.duoc.pokedex.dto.PokedexDTO;
import cl.duoc.pokedex.service.PokedexService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas unitarias para PokedexController")
class PokedexControllerTest {

    @Mock
    private PokedexService pokedexService;

    @InjectMocks
    private PokedexController pokedexController;

    private PokedexDTO pokemonDTO;

    @BeforeEach
    void setUp() {

        pokemonDTO = new PokedexDTO();
        pokemonDTO.setIdEspecie(1L);
        pokemonDTO.setNombrePokemon("Pikachu");
        pokemonDTO.setTipoPrimario("Eléctrico");
    }

    @Test
    @DisplayName("Validación de Listar Toda la Pokedex")
    void testEndpointListarTodos() {
        // ARRANGE
        when(pokedexService.findAll()).thenReturn(List.of(pokemonDTO));

        // ACT
        ResponseEntity<?> respuesta = pokedexController.listar();

        // ASSERT
        assertNotNull(respuesta);
        assertEquals(200, respuesta.getStatusCode().value());

        List<?> listaResultado = (List<?>) respuesta.getBody();
        assertNotNull(listaResultado);
        assertEquals(1, listaResultado.size());
    }

    @Test
    @DisplayName("Validación de Buscar Pokémon por ID")
    void testEndpointBuscarPorId() {
        // ARRANGE
        when(pokedexService.findId(1L)).thenReturn(pokemonDTO);

        // ACT -
        ResponseEntity<?> respuesta = pokedexController.buscarId(1L);

        // ASSERT
        assertNotNull(respuesta);
        assertEquals(200, respuesta.getStatusCode().value());

        PokedexDTO resultado = (PokedexDTO) respuesta.getBody();
        assertNotNull(resultado);
        assertEquals("Pikachu", resultado.getNombrePokemon());
    }
}