package compulsory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerEntity {
    private static ManagerEntity entityManager=null;
    private EntityManagerFactory factory;
    private EntityManager em;

    ManagerEntity(){
        factory = Persistence.createEntityManagerFactory("default");
        em = factory.createEntityManager();
    }

    public static ManagerEntity getSingletonManager(){
        if(entityManager == null) {
            entityManager = new ManagerEntity();
        }
        return entityManager;
    }

    void close(){
        em.close();
        factory.close();
    }
}
