package io.github.rafadepaula.grupostrabalho.model.entities;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

// "SELECT p from Pessoa p WHERE NOT p.endereco.tipoLogradouro = 2"
@Entity
@NamedQueries({
        @NamedQuery(
                name = "Pessoa.fetchAll",
                query = "SELECT p FROM Pessoa p"),
        @NamedQuery(
                name = "Pessoa.fetchNames",
                query = "SELECT p.nome from Pessoa p"),
        @NamedQuery(
                name = "Pessoa.fetchNameAndAddress",
                query = "SELECT p.nome, p.endereco from Pessoa p"),
        @NamedQuery(
                name = "Pessoa.fetchLiveOnAvenue",
                query = "SELECT p from Pessoa p WHERE p.endereco.tipoLogradouro = 1"),
        @NamedQuery(
                name = "Pessoa.fetchNotLiveOnSquare",
                query = "SELECT p from Pessoa p WHERE NOT p.endereco.tipoLogradouro = 2"),
        @NamedQuery(
                name = "Pessoa.fetchNameAndPhone",
                query = "SELECT p.nome, t FROM Pessoa p, IN (p.telefones) t")
})
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 65)
    private String nome;

    @Column(length = 250)
    private String email;

    private LocalDate nascimento;

    @Transient
    private Byte idade;

    //    @OneToOne
    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
    private Endereco endereco;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
    private List<Telefone> telefones;

    @OneToMany(
            mappedBy = "pessoa",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Atuacao> atuacoes;

    @OneToMany(
            mappedBy = "lider",
            cascade = CascadeType.PERSIST)
    @JsonbProperty("lideranca")
    private List<Grupo> gruposLiderados;

    public void adicionarLideranca(Grupo grupo) {
        if (this.gruposLiderados == null)
            this.gruposLiderados = new ArrayList<>();

        grupo.setLider(this);
        this.gruposLiderados.add(grupo);
    }

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Pessoa() {
    }

    public Pessoa(String nome, String email, LocalDate nascimento) {
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
    }

    public Pessoa(String nome, String email, LocalDate nascimento, Endereco endereco, List<Telefone> telefones) {
        this.nome = nome;
        this.email = email;
        this.setNascimento(nascimento);
        this.endereco = endereco;
        this.telefones = telefones;
    }

    //</editor-fold>

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;

        this.idade = (byte) nascimento.until(
                LocalDate.now(),
                ChronoUnit.YEARS);
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Byte getIdade() {
        return idade;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        atuacoes.forEach(atuacao -> atuacao.setPessoa(this));
        this.atuacoes = atuacoes;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Grupo> getGruposLiderados() {
        return gruposLiderados;
    }

    public void setGruposLiderados(List<Grupo> gruposLiderados) {
        this.gruposLiderados = gruposLiderados;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Hash/Equals/toString">

    //</editor-fold>
}
