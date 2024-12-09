package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.Antibiotico;

/**
 * Repositório específico para a entidade Antibiótico.
 * Herda as funcionalidades genéricas do GenericRepository.
 */
public class AntibioticoRepository extends GenericRepository<Antibiotico> {
	
    /**
     * Construtor do AntibioticoRepository.
     *
     * @param entityManager O EntityManager responsável pelo gerenciamento das entidades.
     */
    public AntibioticoRepository(EntityManager entityManager) {
        super(entityManager, Antibiotico.class);
    }
}
