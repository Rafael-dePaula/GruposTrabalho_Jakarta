package io.github.rafadepaula.grupostrabalho.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Telefone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Byte ddd;
    private Integer numero;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Telefone() {
    }

    public Telefone(Byte ddd, Integer numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    //</editor-fold>


    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getDdd() {
        return ddd;
    }

    public void setDdd(Byte ddd) {
        this.ddd = ddd;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    // </editor-fold>
}
