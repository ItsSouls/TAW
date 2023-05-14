package es.taw.starwars.Repository;

import es.taw.starwars.entity.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanetaRepository extends JpaRepository<Planeta,Integer> {
    @Query("select c from Planeta c where c.clima= :clima")
    public List<Planeta> filtraclima(@Param("clima")String clima);

    @Query("select c from Planeta c where c.clima is not null")
    public List<Planeta> filtrardefault();
}
