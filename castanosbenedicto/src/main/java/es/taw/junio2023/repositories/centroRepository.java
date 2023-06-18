package es.taw.junio2023.repositories;

import es.taw.junio2023.entity.CentroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface centroRepository extends JpaRepository<CentroEntity,Short> {
}
