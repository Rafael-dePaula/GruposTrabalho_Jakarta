package io.github.rafadepaula.grupostrabalho.beans.grupo;

import io.github.rafadepaula.grupostrabalho.model.dtos.MembroDto;
import io.github.rafadepaula.grupostrabalho.model.entities.Grupo;

import javax.ejb.Local;
import java.time.LocalDate;
import java.util.List;

@Local
public interface GrupoBeanLocal {
    List<Grupo> fetchAllInactives();

    List<Object[]> fetchLeadersAndNames();

    List<String> fetchMemberNames(String nomeGrupo);

    List<Grupo> fetchLeadBy(String nomeLider);

    List<Object[]> fetchParticipationFrom(String nomeMembro);

    List<Grupo> fetchLike(String nomeGrupo);

    List<Object[]> fetchMembersCount();

    List<Object[]> fetchHasMoreThanMembers(Long total);

    List<String> fetchMembersNamesHasJoinAfter(Long grupoId, LocalDate dataInicio);

    List<MembroDto> fetchMembersHasJoinAfter(LocalDate dataInicio);

    List<MembroDto> fetchMembersHasJoinAfter(LocalDate dataInicio, Long grupoId);

    List<MembroDto> fetchMembersHasJoinAfter(LocalDate dataInicio, List<Long> grupoIds);

    List<String[]> fetchMembersWithoutEndDate();

    List<String[]> fetchAll();
}
