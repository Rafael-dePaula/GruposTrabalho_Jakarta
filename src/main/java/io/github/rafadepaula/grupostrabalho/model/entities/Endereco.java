package io.github.rafadepaula.grupostrabalho.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Endereco implements Serializable {
    public enum TipoLogradouro {
        RUA,
        AVENIDA,
        PRACA,
        OUTRO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private TipoLogradouro tipoLogradouro;

    @Column(length = 150)
    private String logradouro;

    private Integer numero;

    @Column(length = 25)
    private String bairro;

    public Endereco() {
    }

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Endereco(TipoLogradouro tipoLogradouro, String logradouro, Integer numero, String bairro) {
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


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
}
