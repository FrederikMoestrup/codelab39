package dat.daos;


import dat.entities.Poem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class PoemDAO {

    private static PoemDAO instance;
    private static EntityManagerFactory emf;

    public PoemDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Poem createPoem(Poem poem) {

        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(poem);
            em.getTransaction().commit();
        }
        return poem;
    }

    public Poem deletePoem(Poem poem) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(poem);
            em.getTransaction().commit();
        }
        return poem;
    }

    public Poem updatePoem(Poem poem) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(poem);
            em.getTransaction().commit();
        }
        return poem;
    }

    public Poem getPoem(long id) {
        try(EntityManager em = emf.createEntityManager()) {
            return em.find(Poem.class, id);
        }
    }

    public List<Poem> getAllPoems() {
        try(EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT p FROM Poem p", Poem.class).getResultList();
        }
    }

}
