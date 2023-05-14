package es.taw.starwars.repository;

import es.taw.starwars.entity.FraseCelebre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraseCelebreRespository extends JpaRepository<FraseCelebre, Integer> {
}
