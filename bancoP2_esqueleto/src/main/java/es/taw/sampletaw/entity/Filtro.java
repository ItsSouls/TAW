package es.taw.sampletaw.entity;

public class Filtro {
    Double comision;
    Double Saldo;

    public Filtro() {
        this.comision = null;
        Saldo = null;
    }


    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public Double getSaldo() {
        return Saldo;
    }

    public void setSaldo(Double saldo) {
        Saldo = saldo;
    }
}
