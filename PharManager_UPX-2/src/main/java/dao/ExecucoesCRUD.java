package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExecucoesCRUD<T> {
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("MedicamentoPU");

    public void save(T entity) {
        EntityManager em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public T find(Class<T> clazz, Long id) {
        EntityManager em = EMF.createEntityManager();
        try {
            return em.find(clazz, id);
        } finally {
            em.close();
        }
    }

    public List<T> findAll(Class<T> clazz) {
        EntityManager em = EMF.createEntityManager();
        try {
            String query = "FROM " + clazz.getName();
            return em.createQuery(query, clazz).getResultList();
        } finally {
            em.close();
        }
    }

    public void delete(T entity) {
        EntityManager em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
