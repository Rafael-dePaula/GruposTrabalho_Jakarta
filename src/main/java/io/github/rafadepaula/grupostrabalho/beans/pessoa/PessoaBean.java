package io.github.rafadepaula.grupostrabalho.beans.pessoa;
import io.github.rafadepaula.grupostrabalho.model.entities.Pessoa;
import io.github.rafadepaula.grupostrabalho.utils.EstadosDDD;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Stateless
@SuppressWarnings("ALL")
public class PessoaBean implements PessoaBeanLocal {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void salvar(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }

    @Override
    public List<Pessoa> fetchAll() {
        String query = "SELECT p from Pessoa p";
        return (List<Pessoa>) entityManager
                .createQuery(query)
                .getResultList();
    }

    @Override
    public List<Pessoa> fetchAllTyped() {
        String query = "SELECT p from Pessoa p";
        return entityManager
                .createQuery(query, Pessoa.class)
                .getResultList();
    }

    @Override
    public List<Pessoa> fetchAllNamed() {
        return entityManager
                .createNamedQuery("Pessoa.fetchAll", Pessoa.class)
                .getResultList();
    }


    @Override
    public List<String> fetchNames() {
        String query = "SELECT p.nome from Pessoa p";
        return (List<String>) entityManager
                .createQuery(query)
                .getResultList();
    }

    @Override
    public List<String> fetchNamesTyped() {
        String query = "SELECT p.nome from Pessoa p";
        return entityManager
                .createQuery(query, String.class)
                .getResultList();
    }

    @Override
    public List<String> fetchNamesNamed() {
        return entityManager
                .createNamedQuery("Pessoa.fetchNames")
                .getResultList();
    }


    @Override
    public List<Object[]> fetchNameAndAddress() {
        String query = "SELECT p.nome, p.endereco from Pessoa p";
        return (List<Object[]>) entityManager
                .createQuery(query)
                .getResultList();
    }

    @Override
    public List<Object[]> fetchNameAndAddressTyped() {
        String query = "SELECT p.nome, p.endereco from Pessoa p";
        return entityManager
                .createQuery(query, Object[].class)
                .getResultList();
    }

    @Override
    public List<Object[]> fetchNameAndAddressNamed() {
        return entityManager
                .createNamedQuery("Pessoa.fetchNameAndAddress")
                .getResultList();
    }


    @Override
    public List<Pessoa> fetchLiveOnAvenue() {
        String query = "SELECT p from Pessoa p WHERE p.endereco.tipoLogradouro = 1";
        return (List<Pessoa>) entityManager
                .createQuery(query)
                .getResultList();
    }

    @Override
    public List<Pessoa> fetchLiveOnAvenueTyped() {
        String query = "SELECT p from Pessoa p WHERE p.endereco.tipoLogradouro = 1";
        return entityManager
                .createQuery(query, Pessoa.class)
                .getResultList();
    }

    @Override
    public List<Pessoa> fetchLiveOnAvenueNamed() {
        return entityManager
                .createNamedQuery("Pessoa.fetchLiveOnAvenue")
                .getResultList();
    }


    @Override
    public List<Pessoa> fetchNotLiveOnSquare() {
        String query = "SELECT p from Pessoa p WHERE NOT p.endereco.tipoLogradouro = 2";
        return (List<Pessoa>) entityManager
                .createQuery(query)
                .getResultList();
    }

    @Override
    public List<Pessoa> fetchNotLiveOnSquareTyped() {
        String query = "SELECT p from Pessoa p WHERE NOT p.endereco.tipoLogradouro = 2";
        return entityManager
                .createQuery(query, Pessoa.class)
                .getResultList();
    }

    @Override
    public List<Pessoa> fetchNotLiveOnSquareNamed() {
        return entityManager
                .createNamedQuery("Pessoa.fetchNotLiveOnSquare")
                .getResultList();
    }

    @Override
    public List<Object[]> fetchNameAndPhone() {
        String query = "SELECT p.nome, t FROM Pessoa p, IN (p.telefones) t";
        return (List<Object[]>) entityManager
                .createQuery(query)
                .getResultList();
    }

    @Override
    public List<Object[]> fetchNameAndPhoneTyped() {
        String query = "SELECT p.nome, t FROM Pessoa p, IN (p.telefones) t";
        return entityManager
                .createQuery(query, Object[].class)
                .getResultList();
    }

    @Override
    public List<Object[]> fetchNameAndPhoneNamed() {
        return entityManager
                .createNamedQuery("Pessoa.fetchNameAndPhone")
                .getResultList();
    }

    @Override
    public List<Pessoa> fetchBornBetweenDates(LocalDate beginDate, LocalDate endDate) {
        String query = "SELECT p FROM Pessoa p WHERE p.nascimento BETWEEN :beginDate AND :endDate";
        return (List<Pessoa>) entityManager
                .createQuery(query)
                .setParameter("beginDate", beginDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }

    @Override
    public List<Pessoa> fetchSameStateOfDDD(Byte ddd) {
        String query = "SELECT p FROM Pessoa p, IN (p.telefones) t WHERE t.ddd IN :stateDDDs";
        Set<Byte> stateDDDs = EstadosDDD.getDDDsEstado(ddd);
        return entityManager
                .createQuery(query, Pessoa.class)
                .setParameter("stateDDDs", stateDDDs)
                .getResultList();
    }

    @Override
    public List<Pessoa> fetchAllWithoutPhonesNumbers() {
        String query = "SELECT p FROM Pessoa p WHERE p.telefones IS EMPTY";
        return entityManager
                .createQuery(query, Pessoa.class)
                .getResultList();
    }

    @Override
    public List<Object[]> fetchPhoneNumberCount() {
        String query = "SELECT p.nome, count(t.id) FROM Pessoa p, IN (p.telefones) t GROUP BY p.nome";
        return entityManager
                .createQuery(query, Object[].class)
                .getResultList();
    }

}
