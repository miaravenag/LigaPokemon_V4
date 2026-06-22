package cl.duoc.medallas.service;

import cl.duoc.medallas.dto.EntrenadorDTO;
import cl.duoc.medallas.dto.MedallasDTO;
import cl.duoc.medallas.feign.EntrenadorFeing;
import cl.duoc.medallas.mapper.MedallasMapper;
import cl.duoc.medallas.model.Medalla;
import cl.duoc.medallas.repository.MedallasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class MedallasService {
    @Autowired
    private MedallasRepository medallasRepository;
    @Autowired
    private EntrenadorFeing entrenadorFeing;
    @Autowired
    private MedallasMapper medallasMapper;

    public List<Medalla> finndAll(){return medallasRepository.findAll();}

    public Medalla findById(Long idMedalla)
    {
        return medallasRepository.findById(idMedalla).orElseThrow(() -> new RuntimeException("No se encontro la medalla con id: " + idMedalla));
    }

    public MedallasDTO save(MedallasDTO dto, String idEntrenador) {
        cl.duoc.medallas.model.Medalla medalla =
                new cl.duoc.medallas.model.Medalla();
        medalla.setNombreMedalla(dto.getNombreMedalla());
        medalla.setEsOficial(dto.getEsOficial());
        medalla.setIdEntrenador(idEntrenador);

        cl.duoc.medallas.model.Medalla guardada = medallasRepository.save(medalla);
        return medallasMapper.toDTO(guardada);
    }

    public List<MedallasDTO> listarDetallado(){
        List<Medalla> listado = medallasRepository.findAll();
        List<MedallasDTO> listadoDTO = new ArrayList<>();
        for (Medalla medalla : listado){

            MedallasDTO dto = medallasMapper.toDTO(medalla);

            EntrenadorDTO entrenador = entrenadorFeing.obtenerNombrePorId(Long.valueOf(medalla.getIdEntrenador()));

            dto.setNombreEntrenador(entrenador.getNombreCompleto());
            dto.setRegionEntrenador(entrenador.getRegion());
            listadoDTO.add(dto);
        }
        return listadoDTO;
    }

    public void delete(Long idMedalla) {
        // Primero verificamos si la medalla realmente existe antes de borrarla
        Medalla medalla = medallasRepository.findById(idMedalla).orElse(null);

        if (medalla != null) {
            medallasRepository.deleteById(idMedalla);
        } else {
            throw new RuntimeException("No se puede eliminar. No existe la medalla con id: " + idMedalla);
        }
    }

    public MedallasDTO update(Long idMedalla, Medalla medallaActualizada) {
        Medalla medallaExistente = medallasRepository.findById(idMedalla)
                .orElseThrow(() -> new RuntimeException("No se encontró la medalla para actualizar con id: " + idMedalla));

        medallaExistente.setNombreMedalla(medallaActualizada.getNombreMedalla());
        medallaExistente.setEsOficial(medallaActualizada.getEsOficial());
        medallaExistente.setIdEntrenador(medallaActualizada.getIdEntrenador());

        Medalla guardada = medallasRepository.save(medallaExistente);

        MedallasDTO dto = medallasMapper.toDTO(guardada);

        EntrenadorDTO entrenador = entrenadorFeing.obtenerNombrePorId(Long.valueOf(guardada.getIdEntrenador()));

        if (entrenador != null) {
            dto.setNombreEntrenador(entrenador.getNombreCompleto());
        } else {
            dto.setNombreEntrenador("Entrenador no encontrado");
        }

        return dto;
    }

}
