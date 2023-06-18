package com.mac.musicdb.Entity;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "cancion", schema = "musica", catalog = "")
public class CancionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "ID_DISCO")
    private Integer idDisco;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "DURACION")
    private Time duracion;
    @Basic
    @Column(name = "PISTA")
    private Integer pista;
    @Basic
    @Column(name = "NUMERODISCO")
    private Integer numerodisco;
    @Basic
    @Column(name = "INTERPRETE")
    private Integer interprete;

    @ManyToOne @JoinColumn(name = "ID_DISCO", referencedColumnName = "ID", insertable = false, updatable = false)
    private DiscoEntity discoByIdDisco;

    @ManyToOne @JoinColumn(name = "INTERPRETE", referencedColumnName = "ID", insertable = false, updatable = false)
    private InterpreteEntity interpreteByInterprete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(Integer idDisco) {
        this.idDisco = idDisco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public Integer getPista() {
        return pista;
    }

    public void setPista(Integer pista) {
        this.pista = pista;
    }

    public Integer getNumerodisco() {
        return numerodisco;
    }

    public void setNumerodisco(Integer numerodisco) {
        this.numerodisco = numerodisco;
    }

    public Integer getInterprete() {
        return interprete;
    }

    public void setInterprete(Integer interprete) {
        this.interprete = interprete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CancionEntity that = (CancionEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idDisco != null ? !idDisco.equals(that.idDisco) : that.idDisco != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (duracion != null ? !duracion.equals(that.duracion) : that.duracion != null) return false;
        if (pista != null ? !pista.equals(that.pista) : that.pista != null) return false;
        if (numerodisco != null ? !numerodisco.equals(that.numerodisco) : that.numerodisco != null) return false;
        if (interprete != null ? !interprete.equals(that.interprete) : that.interprete != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idDisco != null ? idDisco.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (duracion != null ? duracion.hashCode() : 0);
        result = 31 * result + (pista != null ? pista.hashCode() : 0);
        result = 31 * result + (numerodisco != null ? numerodisco.hashCode() : 0);
        result = 31 * result + (interprete != null ? interprete.hashCode() : 0);
        return result;
    }
}
