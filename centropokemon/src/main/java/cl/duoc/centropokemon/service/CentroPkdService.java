package cl.duoc.centropokemon.service;

import cl.duoc.centropokemon.dto.CentroPkDTO;
import cl.duoc.centropokemon.mapper.CentroPkMapper;
import cl.duoc.centropokemon.model.CentroPk;
import cl.duoc.centropokemon.repository.CentroPkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CentroPkdService {

    private final CentroPkRepository centroPkRepository;
    private final CentroPkMapper centroPkMapper;

    public List<CentroPkDTO> findAll() {
        return centroPkRepository.findAll().stream()
                .map(centroPkMapper::toDTO).collect(Collectors.toList());
    }

    public CentroPkDTO findById(Long id) {
        CentroPk c = centroPkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Centro Pokémon no encontrado con id: " + id));
        return centroPkMapper.toDTO(c);
    }

    public CentroPkDTO save(CentroPkDTO dto) {
        return centroPkMapper.toDTO(centroPkRepository.save(centroPkMapper.toEntity(dto)));
    }

    public CentroPkDTO update(Long id, CentroPkDTO dto) {
        centroPkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Centro Pokémon no encontrado con id: " + id));
        CentroPk c = centroPkMapper.toEntity(dto);
        c.setId(id);
        return centroPkMapper.toDTO(centroPkRepository.save(c));
    }

    public void delete(Long id) {
        centroPkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Centro Pokémon no encontrado con id: " + id));
        centroPkRepository.deleteById(id);
    }

    // Reportes
    public List<CentroPkDTO> findByCiudad(String ciudad) {
        return centroPkRepository.findByCiudad(ciudad).stream()
                .map(centroPkMapper::toDTO).collect(Collectors.toList());
    }

    public List<CentroPkDTO> findByRegion(String region) {
        return centroPkRepository.findByRegion(region).stream()
                .map(centroPkMapper::toDTO).collect(Collectors.toList());
    }

}