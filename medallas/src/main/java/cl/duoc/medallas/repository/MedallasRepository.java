package cl.duoc.medallas.repository;

import cl.duoc.medallas.model.Medalla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedallasRepository extends JpaRepository<Medalla, Long> {
}
