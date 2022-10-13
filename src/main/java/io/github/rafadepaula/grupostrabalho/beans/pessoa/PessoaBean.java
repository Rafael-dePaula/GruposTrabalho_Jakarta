package io.github.rafadepaula.grupostrabalho.beans.pessoa;


import io.github.rafadepaula.grupostrabalho.model.entities.Pessoa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PessoaBean implements PessoaBeanLocal {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void salvar(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }
}
