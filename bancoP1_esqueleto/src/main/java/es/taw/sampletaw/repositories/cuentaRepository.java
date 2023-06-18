package es.taw.sampletaw.repositories;

import es.taw.sampletaw.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface cuentaRepository extends JpaRepository<CuentaEntity,Integer> {
    @Query("select c from CuentaEntity c where c.cuentaid != :idpropio")
    public List<CuentaEntity>todasmenosyo(@Param("idpropio")Integer idpropio);

}
