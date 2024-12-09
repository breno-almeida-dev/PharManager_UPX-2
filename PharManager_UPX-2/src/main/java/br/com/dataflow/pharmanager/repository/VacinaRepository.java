package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.Vacina;

/**
 * Repositório específico para a entidade Vacina.
 * Herda as funcionalidades genéricas do GenericRepository.
 */
public class VacinaRepository extends GenericRepository<Vacina>{
	
    /**
     * Construtor do VacinaRepository.
     *
     * @param entityManager O EntityManager responsável pelo gerenciamento das entidades.
     */
    public VacinaRepository(EntityManager entityManager) {
        super(entityManager, Vacina.class);
    }
}
