package io.github.rafadepaula.grupostrabalho.beans.grupo;


import io.github.rafadepaula.grupostrabalho.model.dtos.MembroDto;
import io.github.rafadepaula.grupostrabalho.model.entities.Grupo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class GrupoBean implements GrupoBeanLocal {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Grupo> fetchAllInactives() {
        String query = "SELECT g FROM Grupo g WHERE g.ativo = false";
        return entityManager
                .createQuery(query, Grupo.class)
                .getResultList();
    }

    @Override
    public List<Object[]> fetchLeadersAndNames() {
        String query = "SELECT g.nome, g.lider.nome FROM Grupo g";
        return entityManager
                .createQuery(query, Object[].class)
                .getResultList();
    }

    @Override
    public List<String> fetchMemberNames(String nomeGrupo) {
        String query = "SELECT a.pessoa.nome FROM Atuacao a WHERE a.grupo.nome = :nomeGrupo ORDER BY a.pessoa.nome DESC";
        return entityManager
                .createQuery(query, String.class)
                .setParameter("nomeGrupo", nomeGrupo)
                .getResultList();
    }

    @Override
    public List<Grupo> fetchLeadBy(String nomeLider) {
        String query = "SELECT g FROM Pessoa p, IN (p.gruposLiderados) g WHERE p.nome = :nomeLider";
        return entityManager
                .createQuery(query, Grupo.class)
                .setParameter("nomeLider", nomeLider)
                .getResultList();
    }

    @Override
    public List<Object[]> fetchParticipationFrom(String nomeMembro) {
        String query = "SELECT g.nome, a.inicio, a.termino FROM Grupo g, IN (g.atuacoes) a WHERE a.pessoa.nome = :nomeMembro";
        return entityManager
                .createQuery(query, Object[].class)
                .setParameter("nomeMembro", nomeMembro)
                .getResultList();
    }

    @Override
    public List<Grupo> fetchLike(String nomeGrupo) {
        String query = "SELECT g FROM Grupo g WHERE g.nome LIKE :nomeGrupo";
        return entityManager
                .createQuery(query, Grupo.class)
                .setParameter("nomeGrupo", '%' + nomeGrupo + '%')
                .getResultList();
    }

    @Override
    public List<Object[]> fetchMembersCount() {
        String query = "SELECT g.nome, COUNT(DISTINCT a.pessoa.id) FROM Grupo g, IN (g.atuacoes) a GROUP BY g.nome";
        return entityManager
                .createQuery(query, Object[].class)
                .getResultList();
    }

    @Override
    public List<Object[]> fetchHasMoreThanMembers(Long total) {
        String query = "SELECT g.nome, COUNT(a.id) FROM Grupo g, IN (g.atuacoes) a GROUP BY g.nome HAVING COUNT(a.id) >= :total";
        return entityManager
                .createQuery(query, Object[].class)
                .setParameter("total", total)
                .getResultList();
    }

    @Override
    public List<String> fetchMembersNamesHasJoinAfter(Long grupoId, LocalDate dataInicio) {
        String query = "SELECT DISTINCT a.pessoa.nome FROM Atuacao a WHERE a.grupo.id = :grupoId AND a.inicio >= :dataInicio";
        return entityManager
                .createQuery(query, String.class)
                .setParameter("grupoId", grupoId)
                .setParameter("dataInicio", dataInicio)
                .getResultList();
    }

    @Override
    public List<MembroDto> fetchMembersHasJoinAfter(LocalDate dataInicio) {
        String query = "SELECT new io.github.rafadepaula.grupostrabalho.model.dtos.MembroDto(a.grupo.nome, a.inicio, a.pessoa.nome) FROM Atuacao a WHERE a.inicio >= :dataInicio ORDER BY a.grupo.nome, a.inicio";
        return entityManager
                .createQuery(query, MembroDto.class)
                .setParameter("dataInicio", dataInicio)
                .getResultList();
    }

    @Override
    public List<MembroDto> fetchMembersHasJoinAfter(LocalDate dataInicio, Long grupoId) {
        String query = "SELECT new io.github.rafadepaula.grupostrabalho.model.dtos.MembroDto(a.grupo.nome, a.inicio, a.pessoa.nome) FROM Atuacao a WHERE a.inicio >= :dataInicio AND a.grupo.id = :grupoId  ORDER BY a.grupo.nome, a.inicio";
        return entityManager
                .createQuery(query, MembroDto.class)
                .setParameter("dataInicio", dataInicio)
                .setParameter("grupoId", grupoId)
                .getResultList();
    }

    @Override
    public List<MembroDto> fetchMembersHasJoinAfter(LocalDate dataInicio, List<Long> grupoIds) {
        String query = "SELECT new io.github.rafadepaula.grupostrabalho.model.dtos.MembroDto(a.grupo.nome, a.inicio, a.pessoa.nome) FROM Atuacao a WHERE a.inicio >= :dataInicio AND a.grupo.id IN :grupoIds  ORDER BY a.grupo.nome, a.inicio";
        return entityManager
                .createQuery(query, MembroDto.class)
                .setParameter("dataInicio", dataInicio)
                .setParameter("grupoIds", grupoIds)
                .getResultList();
    }

    @Override
    public List<String[]> fetchMembersWithoutEndDate() {
        String query = "SELECT a.grupo.nome, a.pessoa.nome FROM Atuacao a WHERE a.termino IS NULL";
        return (List<String[]>) entityManager
                .createQuery(query)
                .getResultList();
    }

    @Override
    public List<String[]> fetchAll() {
        String query = "SELECT g.nome, g.lider.nome, p.nome FROM Atuacao a JOIN a.grupo g JOIN a.pessoa p ORDER BY g.nome, g.lider.nome, p.nome";
        return (List<String[]>) entityManager
                .createQuery(query)
                .getResultList();

    }

}
