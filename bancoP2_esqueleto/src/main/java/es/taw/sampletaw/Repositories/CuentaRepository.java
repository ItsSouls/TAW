package es.taw.sampletaw.Repositories;

import es.taw.sampletaw.entity.CuentaEntity;
import es.taw.sampletaw.entity.TipocomisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CuentaRepository extends JpaRepository<CuentaEntity, Integer> {
    @Query("select c from CuentaEntity c where c.tipocomisionByComision.valor = :comision")
    public List<CuentaEntity> filtroporcomision(@Param("comision")Double comision);
    @Query("select c from CuentaEntity c where c.saldoactual > :saldo")
    public List<CuentaEntity> filtroporsaldo(@Param("saldo")Double saldo);

    @Query("select c from CuentaEntity c where c.saldoactual > :saldo and c.tipocomisionByComision.valor = :comision")
    public List<CuentaEntity> filtroporsaldocomision(@Param("saldo")Double saldo, @Param("comision")Double comision);

}
