package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.Analgesico;

/**
 * Repositório específico para a entidade Analgésico.
 * Herda as funcionalidades genéricas do GenericRepository.
 */
public class AnalgesicoRepository extends GenericRepository<Analgesico> {

    /**
     * Construtor do AnalgesicoRepository.
     *
     * @param entityManager O EntityManager responsável pelo gerenciamento das entidades.
     */
    public AnalgesicoRepository(EntityManager entityManager) {
        super(entityManager, Analgesico.class);
    }
}
