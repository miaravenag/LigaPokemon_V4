package cl.duoc.tienda.service;

import cl.duoc.tienda.dto.TiendaDTO;
import cl.duoc.tienda.mapper.TiendaMapper;
import cl.duoc.tienda.model.Tienda;
import cl.duoc.tienda.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TiendaService {

    @Autowired
    private TiendaRepository tRepository;

    @Autowired
    private TiendaMapper tMapper;

    public List<Tienda> findAll(){
        return tRepository.findAll();
    }

    public TiendaDTO findID(Long id){
        Tienda t = tRepository.findById(id).orElse(null);
        return tMapper.toDTO(t);
    }

    public Tienda save(Tienda t){
        return tRepository.save(t);
    }

    public void delete(Long id){
        tRepository.deleteById(id);
    }

    public Tienda update(Long id, Tienda t){
        return tRepository.findById(id).map(existente -> {
            existente.setIdComprador(t.getIdComprador());
            existente.setIdArticulo(t.getIdArticulo());
            existente.setPrecioMonedas(t.getPrecioMonedas());
            return tRepository.save(existente);
        }).orElse(null);
    }
}