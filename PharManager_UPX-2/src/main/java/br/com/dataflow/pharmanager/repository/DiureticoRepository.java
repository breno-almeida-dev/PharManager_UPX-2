package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.Diuretico;

/**
 * Repositório específico para a entidade Diurético.
 * Herda as funcionalidades genéricas do GenericRepository.
 */
public class DiureticoRepository extends GenericRepository<Diuretico>{
	
    /**
     * Construtor do DiureticoRepository.
     *
     * @param entityManager O EntityManager responsável pelo gerenciamento das entidades.
     */
    public DiureticoRepository(EntityManager entityManager) {
        super(entityManager, Diuretico.class);
    }
}
