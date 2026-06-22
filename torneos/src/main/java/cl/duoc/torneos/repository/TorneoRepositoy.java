package cl.duoc.torneos.repository;

import cl.duoc.torneos.model.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneoRepositoy extends JpaRepository<Torneo, Long> {
}
