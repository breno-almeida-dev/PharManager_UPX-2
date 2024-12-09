package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.Antifungico;

/**
 * Repositório específico para a entidade Antifúngico.
 * Herda as funcionalidades genéricas do GenericRepository.
 */
public class AntifungicoRepository extends GenericRepository<Antifungico>{
	
    /**
     * Construtor do AntifungicoRepository.
     *
     * @param entityManager O EntityManager responsável pelo gerenciamento das entidades.
     */
    public AntifungicoRepository(EntityManager entityManager) {
        super(entityManager, Antifungico.class);
    }
}
