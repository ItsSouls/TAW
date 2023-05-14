package es.taw.starwars.Repository;

import es.taw.starwars.entity.FamiliaEspecie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaRepository extends JpaRepository<FamiliaEspecie,Integer> {
}
