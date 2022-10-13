package io.github.rafadepaula.grupostrabalho.model.dtos;

import java.time.LocalDate;

public class MembroDto {
    private String grupo;
    private String nome;
    private LocalDate inicio;

    public MembroDto(String nomeGrupo, LocalDate dataInicio, String nomeMembro) {
        this.grupo = nomeGrupo;
        this.inicio = dataInicio;
        this.nome = nomeMembro;
    }

    public MembroDto(String grupo, String nome) {
        this.grupo = grupo;
        this.nome = nome;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }
}
