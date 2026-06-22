package cl.duoc.centropokemon.repository;

import cl.duoc.centropokemon.model.CentroPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CentroPkRepository extends JpaRepository<CentroPk, Long> {

    //1: Centros por ciudad
    List<CentroPk> findByCiudad(String ciudad);

    //2: Centros por región
    List<CentroPk> findByRegion(String region);

    //3: Centros disponibles
    List<CentroPk> findByDisponible(boolean disponible);

    //4: Centros con más atenciones que un mínimo
    @Query("SELECT c FROM CentroPk c WHERE c.totalAtenciones >= :minAtenciones")
    List<CentroPk> findMasActivos(@Param("minAtenciones") int minAtenciones);
}