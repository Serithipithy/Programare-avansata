package com.app.OurMusic.repository;

import com.app.OurMusic.model.SongsEntity;
import org.assertj.core.util.Throwables;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SongsRepository {
    public int addSong(SongsEntity object) {
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

    public List<SongsEntity> getTopSongs() {
        EntityManager em = PersistanceManager.getInstance().getEntityManagerFactory();
        List<SongsEntity> songsEntityList;
        try {
            songsEntityList = em.createNamedQuery("Songs.getTopSongs").getResultList();
        } catch (NoResultException e) {
            songsEntityList = null;
        }
        em.close();
        return songsEntityList;
    }

    public List<SongsEntity> getSongsById(int id) {
        EntityManager em = PersistanceManager.getInstance().getEntityManagerFactory();
        List<SongsEntity> songsEntityList;
        try {
            songsEntityList = em.createNamedQuery("Songs.getSongsById").setParameter("id", id).getResultList();
        } catch (NoResultException e) {
            songsEntityList = null;
        }
        em.close();
        return songsEntityList;
    }

    public int deleteByTitle(String name) {
        EntityManager em = PersistanceManager.getInstance().getEntityManagerFactory();
        em.getTransaction().begin();
        int deletedCount = em.createNamedQuery("Songs.deleteByTitle").setParameter("title", name).executeUpdate();
        em.getTransaction().commit();
        em.close();
        return deletedCount;
    }

    public int deleteBySongId(int id) {
        EntityManager em = PersistanceManager.getInstance().getEntityManagerFactory();
        em.getTransaction().begin();
        int deletedCount = em.createNamedQuery("Songs.deleteById").setParameter("id_song", id).executeUpdate();
        em.getTransaction().commit();
        em.close();
        return deletedCount;
    }

    //vote song
    public int updateSongVotes(int id) {
        EntityManager em = PersistanceManager.getInstance().getEntityManagerFactory();
        em.getTransaction().begin();
        int updatedCount = em.createNamedQuery("Songs.updateSongVotes").setParameter("id", id).executeUpdate();
        em.getTransaction().commit();
        em.close();
        return updatedCount;
    }

}
