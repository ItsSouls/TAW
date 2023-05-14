package es.taw.starwars.Repository;

import es.taw.starwars.entity.Especie;
import es.taw.starwars.entity.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EspecieRepository extends JpaRepository<Especie,Integer> {
    @Query("select e.planeta from Especie e where e.especieId= :id")
    public Planeta buscarplaneta(@Param("id")Integer id);
}
