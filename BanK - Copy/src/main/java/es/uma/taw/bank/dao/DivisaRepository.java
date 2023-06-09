package es.uma.taw.bank.dao;

import es.uma.taw.bank.entity.DivisaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DivisaRepository extends JpaRepository<DivisaEntity, Integer> {
    @Query("select d from DivisaEntity d where d.nombre=:nombre")
    public DivisaEntity buscarPorNombre(@Param("nombre") String nombre);

    @Query("select d from DivisaEntity d where d.id != :id")
    List<DivisaEntity> buscarSinMi(@Param("id") Integer id);
}
