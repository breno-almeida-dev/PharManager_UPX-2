package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.Antidepressivo;

/**
 * Repositório específico para a entidade Antidepressivo.
 * Herda as funcionalidades genéricas do GenericRepository.
 */
public class AntidepressivoRepository extends GenericRepository<Antidepressivo>{
	
    /**
     * Construtor do AntidepressivoRepository.
     *
     * @param entityManager O EntityManager responsável pelo gerenciamento das entidades.
     */
    public AntidepressivoRepository(EntityManager entityManager) {
        super(entityManager, Antidepressivo.class);
    }
}
