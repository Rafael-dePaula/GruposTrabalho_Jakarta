package io.github.rafadepaula.grupostrabalho.entities;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Pessoa.findAll",
                query = "SELECT p FROM Pessoa p")
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

    @Embedded
    private Endereco endereco;

    @OneToMany(
            mappedBy = "pessoa",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Telefone> telefones;

    @OneToMany(
            mappedBy = "pessoa",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    private List<Atuacao> atuacoes;

    @OneToMany(
            mappedBy = "lider",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    @JsonbProperty("lideranca")
    private List<Grupo> gruposLiderados;

    public void adicionarLideranca(Grupo grupo) {
        if (this.gruposLiderados == null)
            this.gruposLiderados = new ArrayList<>();

        grupo.setLider(this);
        this.gruposLiderados.add(grupo);
    }

    ;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Pessoa() {
    }

    ;

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
        telefones.forEach(tel -> tel.setPessoa(this));
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
