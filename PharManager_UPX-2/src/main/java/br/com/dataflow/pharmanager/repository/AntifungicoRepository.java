package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.Antifungico;

public class AntifungicoRepository extends GenericRepository<Antifungico>{
    public AntifungicoRepository(EntityManager entityManager) {
        super(entityManager, Antifungico.class);
    }
}
