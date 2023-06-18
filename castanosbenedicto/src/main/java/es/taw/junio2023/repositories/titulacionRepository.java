package es.taw.junio2023.repositories;

import es.taw.junio2023.entity.AsignaturaEntity;
import es.taw.junio2023.entity.TitulacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface titulacionRepository extends JpaRepository<TitulacionEntity,Short> {
    @Query("select t from TitulacionEntity t order by t.nombre, t.nivelEstudiosByNivel.idnivel")
    public List<TitulacionEntity> listatitulacionesordenada();

    @Query("select a from AsignaturaEntity a where a in :listaasig order by a.curso, a.cuatrimestre")
    public List<AsignaturaEntity> listaasignaturasordenada(@Param("listaasig")List<AsignaturaEntity>listaasig);

}
