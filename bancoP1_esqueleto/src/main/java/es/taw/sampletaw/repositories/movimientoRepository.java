package es.taw.sampletaw.repositories;

import es.taw.sampletaw.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface movimientoRepository extends JpaRepository<MovimientoEntity, Integer> {
}
