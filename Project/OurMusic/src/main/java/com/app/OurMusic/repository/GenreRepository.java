package com.app.OurMusic.repository;

import com.app.OurMusic.model.GenreEntity;
import com.app.OurMusic.model.SongsEntity;
import org.assertj.core.util.Throwables;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GenreRepository {
    public int addSongInGenre(int songId, String genre) {
        EntityManager em = PersistanceManager.getInstance().getEntityManagerFactory();
        em.getTransaction().begin();

        GenreEntity object = new GenreEntity(genre, songId);
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

    public List<SongsEntity> getTopSongsGenre(String name) {
        EntityManager em = PersistanceManager.getInstance().getEntityManagerFactory();
        List<SongsEntity> songsEntityList;
        try {
            songsEntityList = em.createNamedQuery("Genre.getTopSongsGenre").setParameter("name", name).getResultList();
        } catch (NoResultException e) {
            songsEntityList = null;
        }
        em.close();
        return songsEntityList;
    }
}
