package io.github.rafadepaula.grupostrabalho.beans.dadosiniciais;

import io.github.rafadepaula.grupostrabalho.beans.pessoa.PessoaBeanLocal;
import io.github.rafadepaula.grupostrabalho.model.entities.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

@Singleton
@Startup
public class DadosIniciais implements DadosIniciaisLocal {

    @Inject
    PessoaBeanLocal pessoaBean;

    @PostConstruct
    @Override
    public void popularBanco() {
        /// POPULAR BANCO COM DADOS DE TESTES

        Grupo estudo1 = new Grupo("Estudo I", false);
        Grupo estudo2 = new Grupo("Estudo II", true);
        Grupo estudo3 = new Grupo("Estudo III", false);
        Grupo estudo4 = new Grupo("Estudo IV", true);


        // Ana Zaira

        Pessoa ana = new Pessoa(
                "Ana Zaira",
                "ana@mail.com",
                LocalDate.of(2001, 1, 1)
        );

        ana.setEndereco(new Endereco(
                Endereco.TipoLogradouro.RUA,
                "1",
                1111,
                "Humberto"
        ));

        ana.setTelefones(List.of(
                new Telefone((byte) 11, 11111111),
                new Telefone((byte) 12, 12121212),
                new Telefone((byte) 13, 13131313)
        ));

        ana.adicionarLideranca(estudo1);

        ana.setAtuacoes(List.of(
                new Atuacao(
                        LocalDate.of(2011, 1, 1),
                        LocalDate.of(2021, 11, 11),
                        estudo1),
                new Atuacao(
                        LocalDate.of(2012, 1, 1),
                        LocalDate.of(2022, 11, 11),
                        estudo1)
        ));

        // Beatriz Yana

        Pessoa beatriz = new Pessoa(
                "Beatriz Yana",
                "beatriz@mail.com",
                LocalDate.of(2002, 2, 2)
        );

        beatriz.setEndereco(new Endereco(
                Endereco.TipoLogradouro.AVENIDA,
                "2",
                2222,
                "Doisberto"
        ));

        beatriz.setTelefones(List.of(
                new Telefone((byte) 22, 22222222)
        ));

        beatriz.adicionarLideranca(estudo2);
        beatriz.adicionarLideranca(estudo4);

        beatriz.setAtuacoes(List.of(
                new Atuacao(
                        LocalDate.of(2012, 1, 2),
                        LocalDate.of(2021, 1, 12),
                        estudo1),
                new Atuacao(
                        LocalDate.of(2012, 1, 2),
                        estudo2),
                new Atuacao(
                        LocalDate.of(2012, 1, 4),
                        LocalDate.of(2024, 1, 14),
                        estudo4)
        ));

        // Cecília Xerxes
        Pessoa cecilia = new Pessoa(
                "Cecília Xerxes",
                "cecilia@mail.com",
                LocalDate.of(2003, 3, 3)
        );

        cecilia.setEndereco(new Endereco(
                Endereco.TipoLogradouro.AVENIDA,
                "3",
                3333,
                "Trêsberto"
        ));

        cecilia.adicionarLideranca(estudo3);

        cecilia.setAtuacoes(List.of(
                new Atuacao(
                        LocalDate.of(2013, 1, 3),
                        LocalDate.of(2021, 1, 13),
                        estudo1),
                new Atuacao(
                        LocalDate.of(2012, 1, 3),
                        LocalDate.of(2023, 1, 13),
                        estudo3),
                new Atuacao(
                        LocalDate.of(2012, 1, 4),
                        LocalDate.of(2024, 1, 14),
                        estudo4)
        ));

        // Débora Wendel

        Pessoa debora = new Pessoa(
                "Débora Wendel",
                "debora@mail.com",
                LocalDate.of(2004, 4, 4)
        );

        debora.setTelefones(List.of(
                        new Telefone((byte) 44, 44444444),
                        new Telefone((byte) 45, 45454545)
                )
        );

        debora.setEndereco(new Endereco(
                Endereco.TipoLogradouro.PRACA,
                "4",
                4444,
                "Quatroberto"
        ));

        debora.setAtuacoes(List.of(
                new Atuacao(
                        LocalDate.of(2014, 1, 4),
                        LocalDate.of(2021, 1, 14),
                        estudo1),
                new Atuacao(
                        LocalDate.of(2012, 1, 2),
                        estudo2),
                new Atuacao(
                        LocalDate.of(2012, 1, 3),
                        LocalDate.of(2023, 1, 13),
                        estudo3),
                new Atuacao(
                        LocalDate.of(2012, 1, 4),
                        LocalDate.of(2024, 1, 14),
                        estudo4)
        ));

        pessoaBean.salvar(ana);
        pessoaBean.salvar(beatriz);
        pessoaBean.salvar(cecilia);
        pessoaBean.salvar(debora);
    }

}
