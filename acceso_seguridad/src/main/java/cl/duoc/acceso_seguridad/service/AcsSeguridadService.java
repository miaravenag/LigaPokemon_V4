package cl.duoc.acceso_seguridad.service;

import cl.duoc.acceso_seguridad.dto.AcsSeguridadDTO;
import cl.duoc.acceso_seguridad.feign.EntrenadorFeing;
import cl.duoc.acceso_seguridad.mapper.AcsSeguridadMapper;
import cl.duoc.acceso_seguridad.model.AcsSeguridad;
import cl.duoc.acceso_seguridad.repository.AcsSeguridadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcsSeguridadService {

    @Autowired
    private AcsSeguridadRepository seguridadRepository;
    @Autowired
    private AcsSeguridadMapper seguridadMapper;
    @Autowired
    private EntrenadorFeing entrenadorFeign;

    public List<AcsSeguridad> findAll() {
        return seguridadRepository.findAll();
    }

    public AcsSeguridad findById(Long id) {
        return seguridadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el registro con id: " + id));
    }

    public AcsSeguridadDTO save(AcsSeguridadDTO dto, String contrasenaPura) {
        AcsSeguridad entidad = new AcsSeguridad();
        entidad.setNombreUsuario(dto.getNombreUsuario());
        entidad.setRolAsignado(dto.getRolAsignado());
        entidad.setContrasenaEncriptada(contrasenaPura);

        AcsSeguridad guardado = seguridadRepository.save(entidad);
        return seguridadMapper.toDTO(guardado);
    }

    public void delete(Long id) {
        AcsSeguridad existente = seguridadRepository.findById(id).orElse(null);
        if (existente != null) {
            seguridadRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se puede eliminar, ID no existe: " + id);
        }
    }

    public AcsSeguridadDTO update(Long id, AcsSeguridad datosNuevos) {
        AcsSeguridad existente = seguridadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el registro para actualizar"));

        existente.setNombreUsuario(datosNuevos.getNombreUsuario());
        existente.setContrasenaEncriptada(datosNuevos.getContrasenaEncriptada());
        existente.setRolAsignado(datosNuevos.getRolAsignado());

        AcsSeguridad guardado = seguridadRepository.save(existente);
        return seguridadMapper.toDTO(guardado);
    }
}
