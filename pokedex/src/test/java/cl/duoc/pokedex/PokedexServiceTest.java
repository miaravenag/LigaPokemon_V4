package cl.duoc.pokedex;

import cl.duoc.pokedex.dto.PokedexDTO;
import cl.duoc.pokedex.mapper.PokedexMapper;
import cl.duoc.pokedex.model.Pokedex;
import cl.duoc.pokedex.repository.PokedexRepository;
import cl.duoc.pokedex.service.PokedexService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas unitarias para PokedexService")
public class PokedexServiceTest {

    @Mock
    private PokedexRepository pokedexRepository;

    @Mock
    private PokedexMapper pokedexMapper;

    @InjectMocks
    private PokedexService pokedexService;

    private Pokedex pokemon;
    private PokedexDTO pokemonDTO;

    @BeforeEach
    public void setUp() {
        pokemon = new Pokedex(1L, "Pikachu", "Eléctrico", "Ninguno", 35);

        pokemonDTO = new PokedexDTO();
        pokemonDTO.setIdEspecie(1L);
        pokemonDTO.setNombrePokemon("Pikachu");
        pokemonDTO.setTipoPrimario("Eléctrico");
        pokemonDTO.setTipoSecundario("Ninguno");
        pokemonDTO.setPuntosVidaBase(35);
    }

    @Test
    @DisplayName("Debe listar todas las especies correctamente")
    public void listarTodas_deberiaRetornarListaDePokemones() {
        // ARRANGE:
        when(pokedexRepository.findAll()).thenReturn(List.of(pokemon));
        when(pokedexMapper.toDTO(pokemon)).thenReturn(pokemonDTO);

        // ACT:
        List<PokedexDTO> resultado = pokedexService.findAll();

        // ASSERT:
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Pikachu", resultado.get(0).getNombrePokemon());

        verify(pokedexRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Debe buscar una especie por ID cuando existe")
    public void buscarPorId_cuandoExiste_deberiaRetornarEspecie() {
        // ARRANGE:
        when(pokedexRepository.findById(1L)).thenReturn(Optional.of(pokemon));
        when(pokedexMapper.toDTO(pokemon)).thenReturn(pokemonDTO);

        // ACT:
        PokedexDTO resultado = pokedexService.findId(1L);

        // ASSERT:
        assertNotNull(resultado);
        assertEquals(1L, resultado.getIdEspecie());
        assertEquals("Pikachu", resultado.getNombrePokemon());

        verify(pokedexRepository, times(1)).findById(1L);
    }
}