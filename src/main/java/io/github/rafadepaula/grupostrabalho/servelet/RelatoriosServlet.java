package io.github.rafadepaula.grupostrabalho.servelet;

import io.github.rafadepaula.grupostrabalho.beans.grupo.GrupoBeanLocal;
import io.github.rafadepaula.grupostrabalho.beans.pessoa.PessoaBeanLocal;
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
    PessoaBeanLocal pessoaBean;

    @Inject
    GrupoBeanLocal grupoBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        PrintWriter out = response.getWriter();

        out.println("<html><head>" +
                "<link rel=\"stylesheet\" href=\"./static/css/relatorios.css\">" +
                "<style>" +
                "body { padding: 30px }" +
                "h1 { text-align: center }" +
                "details > pre{ " +
                "background-color: rgb(252, 252, 252);" +
                "border-radius: 20px;" +
                "padding: 10 50px;" +
                "box-shadow: 2px 2px grey;" +
                "border-left: 1px solid gray;" +
                "border-top: 1px solid gray;}; </style></head><body>");
        out.println("<h1> Estudo Dirigido: Jakarta Persistence Query Language </h1>");

        // Consulta 1.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 1.A: Quais as pessoas (dados completos) cadastradas? Por meio de Query",
                pessoaBean.fetchAll()
        ));

        // Consulta 1.B
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 1.B: Quais as pessoas (dados completos) cadastradas? Por meio de TypedQuery",
                pessoaBean.fetchAllTyped()
        ));

        // Consulta 1.C
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 1.C: Quais as pessoas (dados completos) cadastradas? Por meio de NamedQuery",
                pessoaBean.fetchAllNamed()
        ));

        // Consulta 2.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 2.A: Quais os nomes das pessoas? Por meio de Query",
                pessoaBean.fetchNames()
        ));

        // Consulta 2.B
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 2.B: Quais os nomes das pessoas? Por meio de TypedQuery",
                pessoaBean.fetchNamesTyped()
        ));

        // Consulta 2.C
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 2.C: Quais os nomes das pessoas? Por meio de NamedQuery",
                pessoaBean.fetchNamesNamed()
        ));

        // Consulta 3.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 3.A: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de Query",
                pessoaBean.fetchNameAndAddress()
        ));

        // Consulta 3.B
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 3.B: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de TypedQuery",
                pessoaBean.fetchNameAndAddressTyped()
        ));

        // Consulta 3.C
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 3.C: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de NamedQuery",
                pessoaBean.fetchNameAndAddressNamed()
        ));

        //Consulta 4.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 4.A: Quais pessoas (dados completos) moram em avenidas? Por meio de Query",
                pessoaBean.fetchLiveOnAvenue()
        ));

        //Consulta 4.B
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 4.B: Quais pessoas (dados completos) moram em avenidas? Por meio de TypedQuery",
                pessoaBean.fetchLiveOnAvenueTyped()
        ));

        //Consulta 4.C
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 4.C: Quais pessoas (dados completos) moram em avenidas? Por meio de NamedQuery",
                pessoaBean.fetchLiveOnAvenueNamed()
        ));

        // Consulta 5.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 5.A: Quais pessoas (dados completos) não moram em praças? Por meio de Query",
                pessoaBean.fetchNotLiveOnSquare()
        ));

        // Consulta 5.B
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 5.B: Quais pessoas (dados completos) não moram em praças? Por meio de TypedQuery",
                pessoaBean.fetchNotLiveOnSquareTyped()
        ));

        // Consulta 5.C
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 5.C: Quais pessoas (dados completos) não moram em praças? Por meio de NamedQuery",
                pessoaBean.fetchNotLiveOnSquareNamed()
        ));

        // Consulta 6.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 6.A: Quais os nomes das pessoas e seus respectivos telefones (dados completos)? Por meio de Query",
                pessoaBean.fetchNameAndPhone()
        ));

        // Consulta 6.B
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 6.B: Quais os nomes das pessoas e seus respectivos telefones (dados completos)? Por meio de TypedQuery",
                pessoaBean.fetchNameAndPhoneTyped()
        ));

        // Consulta 6.C
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 6.C: Quais os nomes das pessoas e seus respectivos telefones (dados completos)? Por meio de NamedQuery",
                pessoaBean.fetchNameAndPhoneNamed()
        ));

        // Consulta 7
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 7: Quais as pessoas (dados completos) que nasceram entre abril de 2001 e abril de 2004?",
                pessoaBean.fetchBornBetweenDates(
                        LocalDate.of(2001, Month.APRIL, 1),
                        LocalDate.of(2004, Month.APRIL, 30))
        ));

        // Consulta 8.A
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 8.A: Quais pessoas (dados completos) têm telefone do estado do Paraná?",
                pessoaBean.fetchSameStateOfDDD((byte) 41)
        ));

        // Consulta 8.B
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 8.B: Quais pessoas (dados completos) têm telefone do estado do Rio de Janeiro?",
                pessoaBean.fetchSameStateOfDDD((byte) 22)
        ));

        // Consulta 9
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 9: Quais pessoas (dados completos) não possuem telefone?",
                pessoaBean.fetchAllWithoutPhonesNumbers()
        ));

        // Consulta 10
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 10: Quantos telefones cada pessoa (nome) tem?",
                pessoaBean.fetchPhoneNumberCount()
        ));

        // Consulta 11
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 11: Quais grupos (dados completos) não estão ativos?",
                grupoBean.fetchAllInactives()
        ));

        // Consulta 12
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 12: Quais são os líderes (nomes) dos grupos (nomes)?",
                grupoBean.fetchLeadersAndNames()
        ));

        // Consulta 13
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 13: Quais são os membros (nomes) do grupo com nome \"Estudo IV\" com ordenação alfabética inversa?",
                grupoBean.fetchMemberNames("Estudo IV")
        ));

        // Consulta 14
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 14: Quais são os grupos (dados completos) liderados por \"Beatriz Yana\"?",
                grupoBean.fetchLeadBy("Beatriz Yana")
        ));

        // Consulta 15
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 15: Quais são as datas de início e de término da atuação e os grupos (nomes) nos quais \"Cecília Xerxes\" é membro?",
                grupoBean.fetchParticipationFrom("Cecília Xerxes")
        ));

        // Consulta 16
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 16: Quais são os grupos (dados completos) que contêm \"II\" em seus nomes?",
                grupoBean.fetchLike("II")
        ));

        // Consulta 17
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 17: Quais são os grupos (nomes) e os respectivos totais de membros distintos já alocados?",
                grupoBean.fetchMembersCount()
        ));

        // Consulta 18
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 18: Quais grupos (nomes) têm 3 ou mais atuações de membros e quanto são esses totais de atuações?",
                grupoBean.fetchHasMoreThanMembers(3L)
        ));

        // Consulta 19
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 19: Quais membros (nomes) entraram a partir de 2012 no primeiro grupo?",
                grupoBean.fetchMembersNamesHasJoinAfter(1L, LocalDate.of(2012, Month.JANUARY, 1))
        ));

        // Consulta 20
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 20: Quais os grupos (nomes), membros (nomes) e as respectivas datas de entrada daqueles que entraram a partir de 2012 em qualquer grupo?",
                grupoBean.fetchMembersHasJoinAfter(LocalDate.of(2012, Month.JANUARY, 1))
        ));

        // Consulta 21
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 21: Quais os grupos (nomes) e respectivos membros (nomes) que não possuem data de término de atuação em seus grupos?",
                grupoBean.fetchMembersWithoutEndDate()
        ));

        // Consulta 22
        out.println(HTMLBuilder.blocoRelatorioBuilder(
                "Consulta 22: Quais são os grupos (nomes) e líderes (nomes) com respectivos membros (nomes)?",
                grupoBean.fetchAll()
        ));

        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
