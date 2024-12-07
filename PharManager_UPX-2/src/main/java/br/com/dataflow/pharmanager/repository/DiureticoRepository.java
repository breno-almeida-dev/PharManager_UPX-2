package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.Diuretico;

public class DiureticoRepository extends GenericRepository<Diuretico>{
    public DiureticoRepository(EntityManager entityManager) {
        super(entityManager, Diuretico.class);
    }
}
