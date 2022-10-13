package io.github.rafadepaula.grupostrabalho.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;

import java.io.Serializable;

@Embeddable
public class Endereco implements Serializable {
    public enum TipoLogradouro {
        RUA,
        AVENIDA,
        PRACA,
        OUTRO
    }

    @Enumerated
    private TipoLogradouro tipoLogradouro;

    @Column(length = 150)
    private String logradouro;

    private Integer numero;

    @Column(length = 25)
    private String bairro;

    public Endereco() {
    }

    ;

    public Endereco(TipoLogradouro tipoLogradouro, String logradouro, Integer numero, String bairro) {
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    //</editor-fold>


    @Override
    public String toString() {
        return "Endereco{" +
                "tipoLogradouro=" + tipoLogradouro +
                ", logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}
