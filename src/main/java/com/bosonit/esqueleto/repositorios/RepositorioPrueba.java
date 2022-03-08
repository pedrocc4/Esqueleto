package com.bosonit.esqueleto.repositorios;

import com.bosonit.esqueleto.entidades.Prueba;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class RepositorioPrueba {
    @PersistenceContext
    EntityManager em;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Optional<Prueba> buscar(long id) {
        return Optional.ofNullable(em.find(Prueba.class, id));
    }

    public void guardar(Prueba prueba) {
        em.persist(prueba);
    }
}
