package cl.duoc.entrenadores;

import cl.duoc.entrenadores.controller.EntrenadorController;
import cl.duoc.entrenadores.dto.EntrenadorDTO;
import cl.duoc.entrenadores.service.EntrenadorService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("Pruebas unitarias para EntrenadorController")
class EntrenadorControllerTest {


    private EntrenadorController entrenadorController;
    private EntrenadorService entrenadorService;
    private EntrenadorDTO entrenadorDTO;

    @BeforeEach
    void setUp() {

        entrenadorService = mock(EntrenadorService.class);
        entrenadorController = new EntrenadorController(entrenadorService);


        entrenadorDTO = new EntrenadorDTO();
        entrenadorDTO.setId(1L);
        entrenadorDTO.setNombre("Ash");
        entrenadorDTO.setNombreCompleto("Ash Ketchum");
    }

    @Test
    @DisplayName("Validación de Listar Todos los Entrenadores")
    void testEndpointListarTodos() {

        when(entrenadorService.findAll()).thenReturn(List.of(entrenadorDTO));

        ResponseEntity<?> respuesta = entrenadorController.findAll();

        assertNotNull(respuesta, "La respuesta del controlador no puede ser nula");
        assertEquals(200, respuesta.getStatusCode().value(), "El código de estado debe ser 200 OK");

        List<?> listaResultado = (List<?>) respuesta.getBody();
        assertNotNull(listaResultado);
        assertEquals(1, listaResultado.size());
    }

    @Test
    @DisplayName("Validación de Buscar Entrenador por ID")
    void testEndpointBuscarPorId() {

        when(entrenadorService.findById(1L)).thenReturn(entrenadorDTO);


        ResponseEntity<?> respuesta = entrenadorController.findByI(1L);


        assertNotNull(respuesta);
        assertEquals(200, respuesta.getStatusCode().value());

        EntrenadorDTO resultado = (EntrenadorDTO) respuesta.getBody();
        assertNotNull(resultado);
        assertEquals("Ash", resultado.getNombre());
    }
}