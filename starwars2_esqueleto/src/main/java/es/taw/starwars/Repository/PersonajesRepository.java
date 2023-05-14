package es.taw.starwars.Repository;

import es.taw.starwars.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajesRepository extends JpaRepository<Personaje,Integer> {
}
