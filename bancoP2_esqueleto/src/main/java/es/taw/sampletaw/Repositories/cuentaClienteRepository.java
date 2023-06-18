package es.taw.sampletaw.Repositories;

import es.taw.sampletaw.entity.CuentaclienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface cuentaClienteRepository extends JpaRepository<CuentaclienteEntity, Integer> {
    @Modifying
    @Transactional
    @Query("update CuentaclienteEntity c set c.rolclienteByRolid = 1 where c.cuentaclienteid = :id")
    public void cuentaactualizadaTitular (@Param("id")Integer id);
    @Modifying
    @Transactional
    @Query("update CuentaclienteEntity c set c.rolclienteByRolid = 2 where c.cuentaclienteid = :id")
    public void cuentaactualizadaAutorizado (@Param("id")Integer id);
}
