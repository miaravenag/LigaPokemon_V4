package cl.duoc.entrenadores.service;

import cl.duoc.entrenadores.dto.EntrenadorDTO;
import cl.duoc.entrenadores.exception.RecursoNoEncontradoException;
import cl.duoc.entrenadores.exception.RecursoDuplicadoException;
import cl.duoc.entrenadores.exception.ValidacionNegocioException;
import cl.duoc.entrenadores.mapper.EntrenadorMapper;
import cl.duoc.entrenadores.model.Entrenador;
import cl.duoc.entrenadores.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService {

    private static final List<String> REGIONES_VALIDAS = List.of(
            "kanto", "johto", "hoenn", "sinnoh", "unova", "kalos", "alola", "galar", "paldea"
    );

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private EntrenadorMapper entrenadorMapper;

    public List<EntrenadorDTO> findAll() {
        return entrenadorRepository.findAll()
                .stream()
                .map(entrenadorMapper::toDTO)
                .toList();
    }

    public EntrenadorDTO findById(Long id) {
        return entrenadorRepository.findById(id)
                .map(entrenadorMapper::toDTO)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "Entrenador no encontrado con id: " + id));
    }

    public EntrenadorDTO save(EntrenadorDTO dto) {

        // REGLA 1: nivel entre 1 y 100
        if (dto.getNivel() < 1 || dto.getNivel() > 100) {
            throw new ValidacionNegocioException(
                    "El nivel debe estar entre 1 y 100. Nivel recibido: " + dto.getNivel());
        }

        // REGLA 2: región válida
        if (!REGIONES_VALIDAS.contains(dto.getRegion().toLowerCase())) {
            throw new ValidacionNegocioException(
                    "La región '" + dto.getRegion() + "' no es válida. Regiones permitidas: " + REGIONES_VALIDAS);
        }

        // REGLA 3: no duplicar nombre + apellido
        boolean existe = entrenadorRepository.findAll().stream()
                .anyMatch(e -> e.getNombre().equalsIgnoreCase(dto.getNombre())
                        && e.getApellido().equalsIgnoreCase(dto.getApellido()));
        if (existe) {
            throw new RecursoDuplicadoException(
                    "Ya existe un entrenador llamado: " + dto.getNombre() + " " + dto.getApellido());
        }

        Entrenador e = new Entrenador();
        e.setNombre(dto.getNombre());
        e.setApellido(dto.getApellido());
        e.setRegion(dto.getRegion());
        e.setNivel(dto.getNivel());
        return entrenadorMapper.toDTO(entrenadorRepository.save(e));
    }

    public EntrenadorDTO update(Long id, EntrenadorDTO dto) {

        // REGLA 1: nivel entre 1 y 100
        if (dto.getNivel() < 1 || dto.getNivel() > 100) {
            throw new ValidacionNegocioException(
                    "El nivel debe estar entre 1 y 100. Nivel recibido: " + dto.getNivel());
        }

        // REGLA 2: región válida
        if (!REGIONES_VALIDAS.contains(dto.getRegion().toLowerCase())) {
            throw new ValidacionNegocioException(
                    "La región '" + dto.getRegion() + "' no es válida. Regiones permitidas: " + REGIONES_VALIDAS);
        }

        return entrenadorRepository.findById(id).map(e -> {
            e.setNombre(dto.getNombre());
            e.setApellido(dto.getApellido());
            e.setRegion(dto.getRegion());
            e.setNivel(dto.getNivel());
            return entrenadorMapper.toDTO(entrenadorRepository.save(e));
        }).orElseThrow(() -> new RecursoNoEncontradoException(
                "Entrenador no encontrado con id: " + id));
    }

    public void delete(Long id) {
        if (!entrenadorRepository.existsById(id)) {
            throw new RecursoNoEncontradoException(
                    "No se puede eliminar. Entrenador no encontrado con id: " + id);
        }
        entrenadorRepository.deleteById(id);
    }
}