package io.github.rafadepaula.grupostrabalho.beans.consultas;


import io.github.rafadepaula.grupostrabalho.model.dtos.MembroDto;
import io.github.rafadepaula.grupostrabalho.model.entities.Grupo;
import io.github.rafadepaula.grupostrabalho.model.entities.Pessoa;
import io.github.rafadepaula.grupostrabalho.utils.EstadosDDD;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@SuppressWarnings("ALL")
@Stateless
public class ConsultasBean implements ConsultasBeanLocal {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Pessoa> consulta1A() {
        return (List<Pessoa>) entityManager
                .createQuery("SELECT p from Pessoa p")
                .getResultList();
    }

    @Override
    public List<Pessoa> consulta1B() {
        return entityManager
                .createQuery("SELECT p from Pessoa p", Pessoa.class)
                .getResultList();
    }

    @Override
    public List<Pessoa> consulta1C() {
        return entityManager
                .createNamedQuery("Pessoa.consulta01")
                .getResultList();
    }

    @Override
    public List<String> consulta2A() {
        return (List<String>) entityManager
                .createQuery("SELECT p.nome from Pessoa p")
                .getResultList();
    }

    @Override
    public List<String> consulta2B() {
        return entityManager
                .createQuery("SELECT p.nome from Pessoa p", String.class)
                .getResultList();
    }

    @Override
    public List<String> consulta2C() {
        return entityManager
                .createNamedQuery("Pessoa.consulta02")
                .getResultList();
    }

    @Override
    public List<Object[]> consulta3A() {
        return (List<Object[]>) entityManager
                .createQuery("SELECT p.nome, p.endereco from Pessoa p")
                .getResultList();
    }

    @Override
    public List<Object[]> consulta3B() {
        return entityManager
                .createQuery("SELECT p.nome, p.endereco from Pessoa p", Object[].class)
                .getResultList();
    }

    @Override
    public List<Object[]> consulta3C() {
        return entityManager
                .createNamedQuery("Pessoa.consulta03")
                .getResultList();
    }

    @Override
    public List<Pessoa> consulta4A() {
        return (List<Pessoa>) entityManager
                .createQuery("SELECT p from Pessoa p WHERE p.endereco.tipoLogradouro = 1")
                .getResultList();
    }

    @Override
    public List<Pessoa> consulta4B() {
        return entityManager
                .createQuery("SELECT p from Pessoa p WHERE p.endereco.tipoLogradouro = 1", Pessoa.class)
                .getResultList();
    }

    @Override
    public List<Pessoa> consulta4C() {
        return entityManager
                .createNamedQuery("Pessoa.consulta04")
                .getResultList();
    }


    @Override
    public List<Pessoa> consulta5A() {
        return (List<Pessoa>) entityManager
                .createQuery("SELECT p from Pessoa p WHERE NOT p.endereco.tipoLogradouro = 2")
                .getResultList();
    }

    @Override
    public List<Pessoa> consulta5B() {
        return entityManager
                .createQuery("SELECT p from Pessoa p WHERE NOT p.endereco.tipoLogradouro = 2", Pessoa.class)
                .getResultList();
    }

    @Override
    public List<Pessoa> consulta5C() {
        return entityManager
                .createNamedQuery("Pessoa.consulta05")
                .getResultList();
    }

    @Override
    public List<Object[]> consulta6A() {
        return (List<Object[]>) entityManager
                .createQuery("SELECT p.nome, t FROM Pessoa p, IN (p.telefones) t")
                .getResultList();
    }

    @Override
    public List<Object[]> consulta6B() {
        return entityManager
                .createQuery("SELECT p.nome, t FROM Pessoa p, IN (p.telefones) t", Object[].class)
                .getResultList();
    }

    @Override
    public List<Object[]> consulta6C() {
        return entityManager
                .createNamedQuery("Pessoa.consulta06")
                .getResultList();
    }

    @Override
    public List<Pessoa> consulta7(LocalDate beginDate, LocalDate endDate) {
        return (List<Pessoa>) entityManager
                .createQuery("SELECT p FROM Pessoa p WHERE p.nascimento BETWEEN :beginDate AND :endDate")
                .setParameter("beginDate", beginDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }

    @Override
    public List<Pessoa> consulta8(Byte ddd) {
        Set<Byte> stateDDDs = EstadosDDD.getDDDsEstado(ddd);
        return (List<Pessoa>) entityManager
                .createQuery("SELECT p FROM Pessoa p, IN (p.telefones) t WHERE t.ddd IN :stateDDDs")
                .setParameter("stateDDDs", stateDDDs)
                .getResultList();
    }

    @Override
    public List<Pessoa> consulta9() {
        return (List<Pessoa>) entityManager
                .createQuery("SELECT p FROM Pessoa p WHERE p.telefones IS EMPTY")
                .getResultList();
    }

    @Override
    public List<String> consulta10() {
        return (List<String>) entityManager
                // "select c,count(c) from Conta c group by c.id"
                .createQuery("SELECT p.nome, count(t.id) FROM Pessoa p, IN (p.telefones) t GROUP BY p.nome")
                .getResultList();
    }

    @Override
    public List<Grupo> consulta11() {
        return (List<Grupo>) entityManager
                .createQuery("SELECT g FROM Grupo g WHERE g.ativo = false")
                .getResultList();
    }

    @Override
    public List<String[]> consulta12() {
        return (List<String[]>) entityManager
                .createQuery("SELECT g.nome, g.lider.nome FROM Grupo g")
                .getResultList();
    }

    @Override
    public List<String> consulta13(String nomeGrupo) {
        String query = "SELECT a.pessoa.nome FROM Atuacao a WHERE a.grupo.nome = :nomeGrupo ORDER BY a.pessoa.nome DESC";
        return (List<String>) entityManager
                .createQuery(query)
                .setParameter("nomeGrupo", nomeGrupo)
                .getResultList();
    }

    @Override
    public List<Grupo> consulta14(String nomeLider) {
        String query = "SELECT g FROM Pessoa p, IN (p.gruposLiderados) g WHERE p.nome = :nomeLider";
        return (List<Grupo>) entityManager
                .createQuery(query)
                .setParameter("nomeLider", nomeLider)
                .getResultList();
    }

    @Override
    public List<Object[]> consulta15(String nomeMembro) {
        String query = "SELECT g.nome, a.inicio, a.termino FROM Grupo g, IN (g.atuacoes) a WHERE a.pessoa.nome = :nomeMembro";
        return (List<Object[]>) entityManager
                .createQuery(query)
                .setParameter("nomeMembro", nomeMembro)
                .getResultList();
    }

    @Override
    public List<Grupo> consulta16(String nomeGrupo) {
        String query = "SELECT g FROM Grupo g WHERE g.nome LIKE :nomeGrupo";
        return (List<Grupo>) entityManager
                .createQuery(query)
                .setParameter("nomeGrupo", '%' + nomeGrupo + '%')
                .getResultList();
    }

    @Override
    public List<Object[]> consulta17() {
        String query = "SELECT g.nome, COUNT(DISTINCT a.pessoa.id) FROM Grupo g, IN (g.atuacoes) a GROUP BY g.nome";
        return (List<Object[]>) entityManager
                .createQuery(query)
                .getResultList();
    }

    @Override
    public List<Object[]> consulta18(Long total) {
        String query = "SELECT g.nome, COUNT(a.id) FROM Grupo g, IN (g.atuacoes) a GROUP BY g.nome HAVING COUNT(a.id) >= :total";
        return (List<Object[]>) entityManager
                .createQuery(query)
                .setParameter("total", total)
                .getResultList();
    }

    @Override
    public List<String> consulta19(Long grupoId, LocalDate dataInicio) {
        String query = "SELECT DISTINCT a.pessoa.nome FROM Atuacao a WHERE a.grupo.id = :grupoId AND a.inicio >= :dataInicio";
        return (List<String>) entityManager
                .createQuery(query)
                .setParameter("grupoId", grupoId)
                .setParameter("dataInicio", dataInicio)
                .getResultList();
    }

    @Override
    public List<MembroDto> consulta20(LocalDate dataInicio) {
        String query = "SELECT new io.github.rafadepaula.grupostrabalho.model.dtos.MembroDto(a.grupo.nome, a.inicio, a.pessoa.nome) FROM Atuacao a WHERE a.inicio >= :dataInicio";
        return (List<MembroDto>) entityManager
                .createQuery(query)
                .setParameter("dataInicio", dataInicio)
                .getResultList();
    }

    @Override
    public List<String[]> consulta21() {
        String query = "SELECT a.grupo.nome, a.pessoa.nome FROM Atuacao a WHERE a.termino IS NULL";
        return (List<String[]>) entityManager
                .createQuery(query)
                .getResultList();
    }

    @Override
    public List<String[]> consulta22() {
        String query = "SELECT g.nome, g.lider.nome, p.nome FROM Atuacao a JOIN a.grupo g JOIN a.pessoa p ORDER BY g.nome, g.lider.nome, p.nome";
        return (List<String[]>) entityManager
                .createQuery(query)
                .getResultList();

    }
}