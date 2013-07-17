package ru.t_systems.demail.dao.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractDAO {

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getCurrentSession() {
        return entityManager;
    }
}
