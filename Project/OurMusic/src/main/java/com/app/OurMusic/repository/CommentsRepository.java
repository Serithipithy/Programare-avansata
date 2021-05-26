package com.app.OurMusic.repository;

import com.app.OurMusic.model.CommentEntity;
import org.assertj.core.util.Throwables;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CommentsRepository {
    public int addComment(CommentEntity object) {
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

    public List<CommentEntity> getCommentForSong(int songId) {
        EntityManager em = PersistanceManager.getInstance().getEntityManagerFactory();
        List<CommentEntity> commentEntityList;

        try {
            commentEntityList = em.createNamedQuery("Comment.getCommentForSong").setParameter("songId", songId).getResultList();
        } catch (NoResultException e) {
            commentEntityList = null;
        }
        em.close();
        return commentEntityList;
    }
}
