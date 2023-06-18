package com.mac.musicdb.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "interprete", schema = "musica", catalog = "")
public class InterpreteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "TIPO")
    private Integer tipo;
    @OneToMany(mappedBy = "interpreteByInterprete")
    private List<CancionEntity> cancionsById;

    @ManyToOne @JoinColumn(name = "TIPO", referencedColumnName = "ID", insertable = false, updatable = false)
    private TipoInterpreteEntity tipoInterpreteByTipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterpreteEntity that = (InterpreteEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }

    public List<CancionEntity> getCancionsById() {
        return cancionsById;
    }

    public void setCancionsById(List<CancionEntity> cancionsById) {
        this.cancionsById = cancionsById;
    }
}
