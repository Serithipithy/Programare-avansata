package com.app.OurMusic.repository;

import com.app.OurMusic.model.UsersEntity;
import org.assertj.core.util.Throwables;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsersRepository {

    public int addUser(UsersEntity object) {
        EntityManager em = PersistanceManager.getInstance().getEntityManagerFactory();
        em.getTransaction().begin();

        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            Throwable rootCause = Throwables.getRootCause(e);

            if (rootCause instanceof SQLException) {
                // duplicate key

                if ("23505".equals(((SQLException) rootCause).getSQLState())) {
                    return 1;
                }
            }
            return -1;
        }
        em.clear();
        return 0;
    }

    public List<UsersEntity> getAllUsers() {
        EntityManager em = PersistanceManager.getInstance().getEntityManagerFactory();
        List<UsersEntity> usersEntityList;
        try {
            usersEntityList = em.createNamedQuery("Users.getAllUsers").getResultList();
        } catch (NoResultException e) {
            usersEntityList = null;
        }
        em.close();
        return usersEntityList;
    }

    public UsersEntity findByName(String name) {
        EntityManager em = PersistanceManager.getInstance().getEntityManagerFactory();
        List<UsersEntity> usersEntity;
        try {
            usersEntity = em.createNamedQuery("Users.findUserByName").setParameter("username", name).getResultList();
        } catch (NoResultException e) {
            usersEntity = null;
        }
        em.close();
        return usersEntity.get(0);
    }

    public int findByNameAndPass(String name, String password) {
        EntityManager em = PersistanceManager.getInstance().getEntityManagerFactory();
        List<UsersEntity> usersEntityList;
        try {
            usersEntityList = em.createNamedQuery("Users.findByNameAndPass").setParameter("username", name).setParameter("password", password).getResultList();
        } catch (NoResultException e) {
            usersEntityList = null;
        }
        em.close();
        return usersEntityList.size();
    }
}
