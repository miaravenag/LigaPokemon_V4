package cl.duoc.inventario.service;

import cl.duoc.inventario.dto.InventarioDTO;
import cl.duoc.inventario.mapper.InventarioMapper;
import cl.duoc.inventario.model.Articulo;
import cl.duoc.inventario.model.Inventario;
import cl.duoc.inventario.repository.ArticuloRepository;
import cl.duoc.inventario.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private InventarioMapper inventarioMapper;

    public List<InventarioDTO> findAll() {
        return inventarioRepository.findAll()
                .stream()
                .map(inventarioMapper::toDTO)
                .toList();
    }

    public InventarioDTO findById(Long id) {
        return inventarioRepository.findById(id)
                .map(inventarioMapper::toDTO)
                .orElse(null);
    }

    public InventarioDTO save(InventarioDTO dto) {
        Articulo articulo = articuloRepository.findById(dto.getIdArticulo())
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));
        Inventario inv = new Inventario(null, dto.getUuidEntrenador(), articulo, dto.getCantidadDisponible());
        return inventarioMapper.toDTO(inventarioRepository.save(inv));
    }

    public InventarioDTO update(Long id, InventarioDTO dto) {
        return inventarioRepository.findById(id).map(inv -> {
            Articulo articulo = articuloRepository.findById(dto.getIdArticulo())
                    .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));
            inv.setUuidEntrenador(dto.getUuidEntrenador());
            inv.setArticulo(articulo);
            inv.setCantidadDisponible(dto.getCantidadDisponible());
            return inventarioMapper.toDTO(inventarioRepository.save(inv));
        }).orElse(null);
    }

    public void delete(Long id) {
        inventarioRepository.deleteById(id);
    }
}