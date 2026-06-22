package cl.duoc.torneos.service;

import cl.duoc.torneos.dto.TorneoDTO;
import cl.duoc.torneos.mapper.TorneoMapper;
import cl.duoc.torneos.model.Torneo;
import cl.duoc.torneos.repository.TorneoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneoService {

    @Autowired
    private TorneoRepositoy torRepositoy;

    @Autowired
    private TorneoMapper torMapper;

    public List<Torneo> findAll() {
        return torRepositoy.findAll();
    }

    public TorneoDTO findID(Long id) {
        Torneo tor = torRepositoy.findById(id).orElse(null);
        return torMapper.toDTO(tor);
    }

    public Torneo save(Torneo tor) {
        return torRepositoy.save(tor);
    }

    public void delete(Long id) {
        torRepositoy.deleteById(id);
    }

    public Torneo update(Long id, Torneo tor) {
        Torneo nuevoTor = torRepositoy.findById(id).orElse(null);

        if (nuevoTor == null) return null;
        nuevoTor.setIdTorneo(tor.getIdTorneo());
        nuevoTor.setIdInscripcion(tor.getIdInscripcion());
        nuevoTor.setEstadoConvocatoria(tor.getEstadoConvocatoria());
        nuevoTor.setNombreEvento(tor.getNombreEvento());
        nuevoTor.setMedallasMinimasRequeridas(tor.getMedallasMinimasRequeridas());

        return torRepositoy.save(nuevoTor);
    }
}
