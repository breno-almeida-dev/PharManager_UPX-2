package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.Antiviral;

/**
 * Repositório específico para a entidade Antiviral.
 * Herda as funcionalidades genéricas do GenericRepository.
 */
public class AntiviralRepository extends GenericRepository<Antiviral>{
	
    /**
     * Construtor do AntiviralRepository.
     *
     * @param entityManager O EntityManager responsável pelo gerenciamento das entidades.
     */
    public AntiviralRepository(EntityManager entityManager) {
        super(entityManager, Antiviral.class);
    }
}
