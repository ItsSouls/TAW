package es.taw.junio2023.repositories;

import es.taw.junio2023.entity.AsignaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepository extends JpaRepository<AsignaturaEntity, Short> {
}
