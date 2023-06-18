package com.mac.musicdb.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "disco", schema = "musica", catalog = "")
public class DiscoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "TITULO")
    private String titulo;
    @Basic
    @Column(name = "ARTISTA/COMPOSITOR")
    private String artistaCompositor;
    @Basic
    @Column(name = "DISCOGRAFIA")
    private String discografia;
    @Basic
    @Column(name = "ESTILO")
    private String estilo;
    @Basic
    @Column(name = "ANO")
    private Timestamp ano;
    @Basic
    @Column(name = "FORMATO")
    private String formato;
    @Basic
    @Column(name = "NUMERODEDISCOS")
    private Integer numerodediscos;
    @OneToMany(mappedBy = "discoByIdDisco")
    private List<CancionEntity> cancionsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtistaCompositor() {
        return artistaCompositor;
    }

    public void setArtistaCompositor(String artistaCompositor) {
        this.artistaCompositor = artistaCompositor;
    }

    public String getDiscografia() {
        return discografia;
    }

    public void setDiscografia(String discografia) {
        this.discografia = discografia;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Timestamp getAno() {
        return ano;
    }

    public void setAno(Timestamp ano) {
        this.ano = ano;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Integer getNumerodediscos() {
        return numerodediscos;
    }

    public void setNumerodediscos(Integer numerodediscos) {
        this.numerodediscos = numerodediscos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscoEntity that = (DiscoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (artistaCompositor != null ? !artistaCompositor.equals(that.artistaCompositor) : that.artistaCompositor != null)
            return false;
        if (discografia != null ? !discografia.equals(that.discografia) : that.discografia != null) return false;
        if (estilo != null ? !estilo.equals(that.estilo) : that.estilo != null) return false;
        if (ano != null ? !ano.equals(that.ano) : that.ano != null) return false;
        if (formato != null ? !formato.equals(that.formato) : that.formato != null) return false;
        if (numerodediscos != null ? !numerodediscos.equals(that.numerodediscos) : that.numerodediscos != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (artistaCompositor != null ? artistaCompositor.hashCode() : 0);
        result = 31 * result + (discografia != null ? discografia.hashCode() : 0);
        result = 31 * result + (estilo != null ? estilo.hashCode() : 0);
        result = 31 * result + (ano != null ? ano.hashCode() : 0);
        result = 31 * result + (formato != null ? formato.hashCode() : 0);
        result = 31 * result + (numerodediscos != null ? numerodediscos.hashCode() : 0);
        return result;
    }

    public List<CancionEntity> getCancionsById() {
        return cancionsById;
    }

    public void setCancionsById(List<CancionEntity> cancionsById) {
        this.cancionsById = cancionsById;
    }
}
