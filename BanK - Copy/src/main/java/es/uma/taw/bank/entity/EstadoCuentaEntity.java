package es.uma.taw.bank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ESTADO_CUENTA", schema = "taw", catalog = "")
public class EstadoCuentaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "TIPO", nullable = false, length = 20)
    private String tipo;
    @OneToMany(mappedBy = "estadoCuentaByEstadoCuentaId")
    private List<CuentaBancoEntity> cuentaBancosById;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadoCuentaEntity that = (EstadoCuentaEntity) o;

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
}
