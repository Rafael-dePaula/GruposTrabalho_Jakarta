package io.github.rafadepaula.grupostrabalho.model.entities;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Grupo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 65)
    private String nome;

    private Boolean ativo = true;

    @OneToMany(mappedBy = "grupo",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true)
    private List<Atuacao> atuacoes = new java.util.ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "lider_id")
    @JsonbTransient
    private Pessoa lider;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }

    public Pessoa getLider() {
        return lider;
    }

    public void setLider(Pessoa lider) {
        this.lider = lider;
    }

    //</editor-fold>

    public Grupo() {
    }

    public Grupo(String nome, Boolean ativo) {
        this.setNome(nome);
        this.setAtivo(ativo);
    }

}
