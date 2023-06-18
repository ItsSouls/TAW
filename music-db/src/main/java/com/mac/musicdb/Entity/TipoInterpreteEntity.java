package com.mac.musicdb.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "tipo interprete", schema = "musica", catalog = "")
public class TipoInterpreteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(mappedBy = "tipoInterpreteByTipo")
    private Collection<InterpreteEntity> interpretesById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoInterpreteEntity that = (TipoInterpreteEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }

    public Collection<InterpreteEntity> getInterpretesById() {
        return interpretesById;
    }

    public void setInterpretesById(Collection<InterpreteEntity> interpretesById) {
        this.interpretesById = interpretesById;
    }
}
