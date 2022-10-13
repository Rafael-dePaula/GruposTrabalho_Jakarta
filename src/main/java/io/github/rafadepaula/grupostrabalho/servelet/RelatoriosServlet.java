package io.github.rafadepaula.grupostrabalho.servelet;

import io.github.rafadepaula.grupostrabalho.beans.consultas.ConsultasBeanLocal;
import io.github.rafadepaula.grupostrabalho.utils.HTMLBuilder;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;

@WebServlet(name = "RelatoriosServlet", value = "/Relatorios")
@Transactional
public class RelatoriosServlet extends HttpServlet {

    @Inject
    ConsultasBeanLocal consultasBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1> Estudo Dirigido: Jakarta Persistence Query Language </h1>");

        // Consulta 1.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 1.A: Quais as pessoas (dados completos) cadastradas? Por meio de Query",
                consultasBean.consulta1A()
        ));

        // Consulta 1.B
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 1.B: Quais as pessoas (dados completos) cadastradas? Por meio de TypedQuery",
                consultasBean.consulta1B()
        ));

        // Consulta 1.C
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 1.C: Quais as pessoas (dados completos) cadastradas? Por meio de NamedQuery",
                consultasBean.consulta1C()
        ));

        // Consulta 2.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 2.A: Quais os nomes das pessoas? Por meio de Query",
                consultasBean.consulta2A()
        ));

        // Consulta 2.B
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 2.B: Quais os nomes das pessoas? Por meio de TypedQuery",
                consultasBean.consulta2B()
        ));

        // Consulta 2.C
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 2.C: Quais os nomes das pessoas? Por meio de NamedQuery",
                consultasBean.consulta2C()
        ));

        // Consulta 3.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 3.A: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de Query",
                consultasBean.consulta3A()
        ));

        // Consulta 3.B
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 3.B: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de TypedQuery",
                consultasBean.consulta3B()
        ));

        // Consulta 3.C
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 3.C: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de NamedQuery",
                consultasBean.consulta3C()
        ));

        //Consulta 4.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 4.A: Quais pessoas (dados completos) moram em avenidas? Por meio de Query",
                consultasBean.consulta4A()
        ));

        //Consulta 4.B
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 4.B: Quais pessoas (dados completos) moram em avenidas? Por meio de TypedQuery",
                consultasBean.consulta4B()
        ));

        //Consulta 4.C
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 4.C: Quais pessoas (dados completos) moram em avenidas? Por meio de NamedQuery",
                consultasBean.consulta4C()
        ));

        // Consulta 5.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 5.A: Quais pessoas (dados completos) não moram em praças? Por meio de Query",
                consultasBean.consulta5A()
        ));

        // Consulta 5.B
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 5.B: Quais pessoas (dados completos) não moram em praças? Por meio de TypedQuery",
                consultasBean.consulta5B()
        ));

        // Consulta 5.C
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 5.C: Quais pessoas (dados completos) não moram em praças? Por meio de NamedQuery",
                consultasBean.consulta5C()
        ));

        // Consulta 6.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 6.A: Quais os nomes das pessoas e seus respectivos telefones (dados completos)? Por meio de Query",
                consultasBean.consulta6A()
        ));

        // Consulta 6.B
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 6.B: Quais os nomes das pessoas e seus respectivos telefones (dados completos)? Por meio de TypedQuery",
                consultasBean.consulta6B()
        ));

        // Consulta 6.C
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 6.C: Quais os nomes das pessoas e seus respectivos telefones (dados completos)? Por meio de NamedQuery",
                consultasBean.consulta6C()
        ));

        // Consulta 7
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 7: Quais as pessoas (dados completos) que nasceram entre abril de 2001 e abril de 2004?",
                consultasBean.consulta7(
                        LocalDate.of(2001, Month.APRIL, 1),
                        LocalDate.of(2004, Month.APRIL, 30))
        ));

        // Consulta 8.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 8.A: Quais pessoas (dados completos) têm telefone do estado do Paraná?",
                consultasBean.consulta8((byte) 41)
        ));

        // Consulta 8.B
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 8.B: Quais pessoas (dados completos) têm telefone do estado do Rio de Janeiro?",
                consultasBean.consulta8((byte) 22)
        ));

        // Consulta 9
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 9: Quais pessoas (dados completos) não possuem telefone?",
                consultasBean.consulta9()
        ));

        // Consulta 10
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 10: Quantos telefones cada pessoa (nome) tem?",
                consultasBean.consulta10()
        ));

        // Consulta 11
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 11: Quais grupos (dados completos) não estão ativos?",
                consultasBean.consulta11()
        ));

        // Consulta 12
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 12: Quais são os líderes (nomes) dos grupos (nomes)?",
                consultasBean.consulta12()
        ));

        // Consulta 13
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 13: Quais são os membros (nomes) do grupo com nome \"Estudo IV\" com\n" +
                        "ordenação alfabética inversa?",
                consultasBean.consulta13("Estudo IV")
        ));

        // Consulta 14
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 14: Quais são os grupos (dados completos) liderados por \"Beatriz Yana\"?",
                consultasBean.consulta14("Beatriz Yana")
        ));

        // Consulta 15
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 15: Quais são as datas de início e de término da atuação e os grupos (nomes) nos\n" +
                        "quais \"Cecília Xerxes\" é membro?",
                consultasBean.consulta15("Cecília Xerxes")
        ));

        // Consulta 16
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 16: Quais são os grupos (dados completos) que contêm \"II\" em seus nomes?",
                consultasBean.consulta16("II")
        ));

        // Consulta 17
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 17: Quais são os grupos (nomes) e os respectivos totais de membros distintos já alocados?",
                consultasBean.consulta17()
        ));

        // Consulta 18
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 18: Quais grupos (nomes) têm 3 ou mais atuações de membros e quanto são esses totais de atuações?",
                consultasBean.consulta18(3L)
        ));

        // Consulta 19
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 19: Quais membros (nomes) entraram a partir de 2012 no primeiro grupo?",
                consultasBean.consulta19(1L, LocalDate.of(2012, Month.JANUARY, 1))
        ));

        // Consulta 20
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 20: Quais os grupos (nomes), membros (nomes) e as respectivas datas de entrada daqueles que entraram a partir de 2012 em qualquer grupo?",
                consultasBean.consulta20(LocalDate.of(2012, Month.JANUARY, 1))
        ));

        // Consulta 21
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 21: Quais os grupos (nomes) e respectivos membros (nomes) que não possuem data de término de atuação em seus grupos?",
                consultasBean.consulta21()
        ));

        // Consulta 22
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 22: Quais são os grupos (nomes) e líderes (nomes) com respectivos membros (nomes)?",
                consultasBean.consulta22()
        ));

        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
