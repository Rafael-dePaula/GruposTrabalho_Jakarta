package io.github.rafadepaula.grupostrabalho.model.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Telefone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Byte ddd;
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    @JsonbTransient
    private Pessoa pessoa;

    public Telefone() {
    }

    public Telefone(Byte ddd, Integer numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    // </editor-fold>


    @Override
    public String toString() {
        return "(" + ddd +
                ") " + numero;
    }
}
