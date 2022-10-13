package io.github.rafadepaula.grupostrabalho.beans.pessoa;

import io.github.rafadepaula.grupostrabalho.entities.Grupo;
import io.github.rafadepaula.grupostrabalho.entities.Pessoa;
import jakarta.ejb.Local;

import java.time.LocalDate;
import java.util.List;

@Local
public abstract class PessoaBeanLocal {
    public abstract void salvar(Pessoa pessoa);

    public abstract List<Pessoa> consulta1A();

    public abstract List<String> consulta2A();

    public abstract List<Object[]> consulta3A();

    public abstract List<Pessoa> consulta4A();

    public abstract List<Pessoa> consulta5A();

    public abstract List<Object[]> consulta6A();

    public abstract List<Pessoa> consulta7(LocalDate begin, LocalDate end);

    public abstract List<Pessoa> consulta8(Byte ddd);

    public abstract List<Pessoa> consulta9();

    public abstract List<String> consulta10();

    public abstract List<Grupo> consulta11();

    public abstract List<String[]> consulta12();

    public abstract List<String> consulta13(String nomeGrupo);

    public abstract List<Grupo> consulta14(String nomeLider);

    public abstract List<Object[]> consulta15(String nomeMembro);


    public abstract List<Grupo> consulta16(String nome);

    public abstract List<Object[]> consulta17();

    public abstract List<Object[]> consulta18(Long total);

    public abstract List<String> consulta19(Long grupoId, LocalDate dataInicio);
}
