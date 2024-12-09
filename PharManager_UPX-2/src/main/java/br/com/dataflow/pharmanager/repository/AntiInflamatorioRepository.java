package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.AntiInflamatorio;

/**
 * Repositório específico para a entidade Anti-inflamatório.
 * Herda as funcionalidades genéricas do GenericRepository.
 */
public class AntiInflamatorioRepository extends GenericRepository<AntiInflamatorio>{
	
    /**
     * Construtor do AntiInflamatorioRepository.
     *
     * @param entityManager O EntityManager responsável pelo gerenciamento das entidades.
     */
    public AntiInflamatorioRepository(EntityManager entityManager) {
        super(entityManager, AntiInflamatorio.class);
    }
}