package cl.duoc.acceso_seguridad.repository;

import cl.duoc.acceso_seguridad.model.AcsSeguridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcsSeguridadRepository extends JpaRepository<AcsSeguridad, Long> {
}
