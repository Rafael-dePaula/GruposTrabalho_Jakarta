package io.github.rafadepaula.grupostrabalho.servelet;

import io.github.rafadepaula.grupostrabalho.beans.pessoa.PessoaBean;
import io.github.rafadepaula.grupostrabalho.utils.HTMLBuilder;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;

@WebServlet(name = "RelatoriosServlet", value = "/Relatorios")
public class RelatoriosServlet extends HttpServlet {
    @Inject
    PessoaBean pessoaBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1> Estudo Dirigido: Jakarta Persistence Query Language </h1>");

        // Consulta 1.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 1.A: Quais as pessoas (dados completos) cadastradas? Por meio de Query",
                pessoaBean.consulta1A()));

        //Consulta 2.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 2.A: Quais os nomes das pessoas? Por meio de Query",
                pessoaBean.consulta2A()
        ));

        // Consulta 3.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 3.A: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de Query",
                pessoaBean.consulta3A()
        ));

        //Consulta 4.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 4.A: Quais pessoas (dados completos) moram em avenidas? Por meio de Query",
                pessoaBean.consulta4A()
        ));

        // Consulta 5.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 5.A: Quais pessoas (dados completos) não moram em praças? Por meio de Query",
                pessoaBean.consulta5A()
        ));

        // Consulta 6.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 6.A: Quais os nomes das pessoas e seus respectivos telefones (dados completos)? Por meio de Query",
                pessoaBean.consulta6A()
        ));

        // Consulta 7
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 7: Quais as pessoas (dados completos) que nasceram entre abril de 2001 e abril de 2004?",
                pessoaBean.consulta7(
                        LocalDate.of(2001, Month.APRIL, 1),
                        LocalDate.of(2004, Month.APRIL, 30))
        ));

        // Consulta 8.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 8.A: Quais pessoas (dados completos) têm telefone do estado do Paraná?",
                pessoaBean.consulta8((byte) 41)
        ));

        // Consulta 8.B
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 8.B: Quais pessoas (dados completos) têm telefone do estado do Rio de Janeiro?",
                pessoaBean.consulta8((byte) 22)
        ));

        // Consulta 9
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 9: Quais pessoas (dados completos) não possuem telefone?",
                pessoaBean.consulta9()
        ));

        // Consulta 10
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 10: Quantos telefones cada pessoa (nome) tem?",
                pessoaBean.consulta10()
        ));

        // Consulta 11
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 11: Quais grupos (dados completos) não estão ativos?",
                pessoaBean.consulta11()
        ));

        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 12: Quais são os líderes (nomes) dos grupos (nomes)?",
                pessoaBean.consulta12()
        ));

        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 13: Quais são os membros (nomes) do grupo com nome \"Estudo IV\" com\n" +
                        "ordenação alfabética inversa?",
                pessoaBean.consulta13("Estudo IV")
        ));

        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 14: Quais são os grupos (dados completos) liderados por \"Beatriz Yana\"?",
                pessoaBean.consulta14("Beatriz Yana")
        ));

        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 15: Quais são as datas de início e de término da atuação e os grupos (nomes) nos\n" +
                        "quais \"Cecília Xerxes\" é membro?",
                pessoaBean.consulta15("Cecília Xerxes")
        ));

        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 16: Quais são os grupos (dados completos) que contêm \"II\" em seus nomes?",
                pessoaBean.consulta16("II")
        ));

        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 17: Quais são os grupos (nomes) e os respectivos totais de membros distintos já alocados?",
                pessoaBean.consulta17()
        ));

        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 18: Quais grupos (nomes) têm 3 ou mais atuações de membros e quanto são esses totais de atuações?",
                pessoaBean.consulta18(3L)
        ));

        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 19: Quais membros (nomes) entraram a partir de 2012 no primeiro grupo?",
                pessoaBean.consulta19(1L, LocalDate.of(2012, Month.JANUARY, 1))
        ));

        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 20: Quais os grupos (nomes), membros (nomes) e as respectivas datas de entrada daqueles que entraram a partir de 2012 em qualquer grupo?",
                pessoaBean.consulta20(LocalDate.of(2012, Month.JANUARY, 1))
        ));

        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
