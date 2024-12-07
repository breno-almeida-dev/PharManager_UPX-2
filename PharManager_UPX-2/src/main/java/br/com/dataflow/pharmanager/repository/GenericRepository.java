package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class GenericRepository<T> {
    private final EntityManager entityManager;
    private final Class<T> clazz;

    public GenericRepository(EntityManager entityManager, Class<T> clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    public void salvar(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public List<T> listarTodos() {
        return entityManager.createQuery("SELECT e FROM " + clazz.getSimpleName() + " e", clazz).getResultList();
    }

    public T buscarPorId(Long id) {
        return entityManager.find(clazz, id);
    }

    public void atualizar(T entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void excluir(Long id) {
        T entity = buscarPorId(id);
        if (entity != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        }
    }
}
