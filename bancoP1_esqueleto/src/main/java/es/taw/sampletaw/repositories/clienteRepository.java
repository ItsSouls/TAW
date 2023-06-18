package es.taw.sampletaw.repositories;

import es.taw.sampletaw.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clienteRepository extends JpaRepository<ClienteEntity, Integer> {
}
