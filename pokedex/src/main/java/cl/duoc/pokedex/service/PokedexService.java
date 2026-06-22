package cl.duoc.pokedex.service;

import cl.duoc.pokedex.dto.PokedexDTO;
import cl.duoc.pokedex.mapper.PokedexMapper;
import cl.duoc.pokedex.model.Pokedex;
import cl.duoc.pokedex.repository.PokedexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokedexService {
    @Autowired
    private PokedexRepository pokeRepository;
    @Autowired
    private PokedexMapper pokeMapper;

    public List<PokedexDTO> findAll() {
        return pokeRepository.findAll()
                .stream()
                .map(pokeMapper::toDTO)
                .toList();
    }

    public PokedexDTO findId(Long id) {
        Pokedex pokedex = pokeRepository.findById(id).orElse(null);
        return pokeMapper.toDTO(pokedex);
    }

    public Pokedex save(Pokedex p) {
        return pokeRepository.save(p);
    }

    public void delete(Long id) {
        pokeRepository.deleteById(id);
    }

    public Pokedex update(Long id, Pokedex p) {
        Pokedex pokeNuevo = pokeRepository.findById(id).orElse(null);
        if (pokeNuevo == null) return null;

        pokeNuevo.setIdEspecie(p.getIdEspecie());
        pokeNuevo.setNombrePokemon(p.getNombrePokemon());
        pokeNuevo.setTipoPrimario(p.getTipoPrimario());
        pokeNuevo.setTipoSecundario(p.getTipoSecundario());
        pokeNuevo.setPuntosVidaBase(p.getPuntosVidaBase());

        return pokeRepository.save(pokeNuevo);
    }
}
