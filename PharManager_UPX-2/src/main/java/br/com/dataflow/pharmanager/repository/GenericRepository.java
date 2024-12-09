package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Repositório genérico para gerenciar operações de persistência em entidades.
 * 
 * @param <T> O tipo da entidade que será gerenciada pelo repositório.
 */
public abstract class GenericRepository<T> {
    private final EntityManager entityManager;
    private final Class<T> clazz;

    /**
     * Construtor do GenericRepository.
     *
     * @param entityManager O EntityManager responsável pelo gerenciamento de entidades.
     * @param clazz A classe da entidade que será gerenciada.
     */
    public GenericRepository(EntityManager entityManager, Class<T> clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    /**
     * Salva uma nova entidade no banco de dados.
     *
     * @param entity A entidade a ser salva.
     */
    public void salvar(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    /**
     * Lista todas as entidades do tipo especificado.
     *
     * @return Uma lista contendo todas as entidades.
     */
    public List<T> listarTodos() {
        return entityManager.createQuery("SELECT e FROM " + clazz.getSimpleName() + " e", clazz).getResultList();
    }

    /**
     * Busca uma entidade pelo ID.
     *
     * @param id O ID da entidade a ser buscada.
     * @return A entidade correspondente ao ID ou {@code null} se não for encontrada.
     */
    public T buscarPorId(Long id) {
        return entityManager.find(clazz, id);
    }

    /**
     * Atualiza uma entidade existente no banco de dados.
     *
     * @param entity A entidade a ser atualizada.
     */
    public void atualizar(T entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    /**
     * Exclui uma entidade do banco de dados com base no ID.
     *
     * @param id O ID da entidade a ser excluída.
     */
    public void excluir(Long id) {
        T entity = buscarPorId(id);
        if (entity != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        }
    }
}