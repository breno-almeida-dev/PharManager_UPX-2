package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.Anticoagulante;

/**
 * Repositório específico para a entidade Anti-coagulante.
 * Herda as funcionalidades genéricas do GenericRepository.
 */
public class AnticoagulanteRepository extends GenericRepository<Anticoagulante>{
	
    /**
     * Construtor do AnticoagulanteRepository.
     *
     * @param entityManager O EntityManager responsável pelo gerenciamento das entidades.
     */
    public AnticoagulanteRepository(EntityManager entityManager) {
        super(entityManager, Anticoagulante.class);
    }
}
