package com.app.OurMusic.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PersistanceManager {
    public static PersistanceManager instance;
    private final EntityManagerFactory entityManagerFactory;

    private PersistanceManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("amosoiu");
    }

    public static PersistanceManager getInstance() {
        if (instance == null) {
            instance = new PersistanceManager();
        }
        return instance;
    }

    public EntityManager getEntityManagerFactory() {
        return entityManagerFactory.createEntityManager();
    }
}
