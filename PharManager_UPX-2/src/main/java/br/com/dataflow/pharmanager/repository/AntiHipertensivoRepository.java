package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.AntiHipertensivo;

/**
 * Repositório específico para a entidade Anti-hipertensivo.
 * Herda as funcionalidades genéricas do GenericRepository.
 */
public class AntiHipertensivoRepository extends GenericRepository<AntiHipertensivo>{
	
    /**
     * Construtor do AntiHipertensivoRepository.
     *
     * @param entityManager O EntityManager responsável pelo gerenciamento das entidades.
     */
    public AntiHipertensivoRepository(EntityManager entityManager) {
        super(entityManager, AntiHipertensivo.class);
    }
}
