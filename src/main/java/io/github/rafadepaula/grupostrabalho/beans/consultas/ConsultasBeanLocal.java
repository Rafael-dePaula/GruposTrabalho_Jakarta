package io.github.rafadepaula.grupostrabalho.beans.consultas;

import io.github.rafadepaula.grupostrabalho.model.dtos.MembroDto;
import io.github.rafadepaula.grupostrabalho.model.entities.Grupo;
import io.github.rafadepaula.grupostrabalho.model.entities.Pessoa;

import javax.ejb.Local;
import java.time.LocalDate;
import java.util.List;

@Local
public interface ConsultasBeanLocal {
    List<Pessoa> consulta1A();

    List<Pessoa> consulta1B();

    List<Pessoa> consulta1C();

    List<String> consulta2A();

    List<String> consulta2B();

    List<String> consulta2C();

    List<Object[]> consulta3A();

    List<Object[]> consulta3B();

    List<Object[]> consulta3C();

    List<Pessoa> consulta4A();

    List<Pessoa> consulta4B();

    List<Pessoa> consulta4C();

    List<Pessoa> consulta5A();

    List<Pessoa> consulta5B();

    List<Pessoa> consulta5C();

    List<Object[]> consulta6A();

    List<Object[]> consulta6B();

    List<Object[]> consulta6C();

    List<Pessoa> consulta7(LocalDate begin, LocalDate end);

    List<Pessoa> consulta8(Byte ddd);

    List<Pessoa> consulta9();

    List<String> consulta10();

    List<Grupo> consulta11();

    List<String[]> consulta12();

    List<String> consulta13(String nomeGrupo);

    List<Grupo> consulta14(String nomeLider);

    List<Object[]> consulta15(String nomeMembro);


    List<Grupo> consulta16(String nome);

    List<Object[]> consulta17();

    List<Object[]> consulta18(Long total);

    List<String> consulta19(Long grupoId, LocalDate dataInicio);

    List<MembroDto> consulta20(LocalDate dataInicio);

    List<String[]> consulta21();

    List<String[]> consulta22();
}
