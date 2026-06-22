package cl.duoc.pokedex.repository;

import cl.duoc.pokedex.model.Pokedex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokedexRepository extends JpaRepository<Pokedex, Long> {
}
