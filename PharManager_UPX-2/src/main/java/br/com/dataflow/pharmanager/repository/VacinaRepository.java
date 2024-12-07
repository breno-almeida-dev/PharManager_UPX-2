package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.Vacina;

public class VacinaRepository extends GenericRepository<Vacina>{
    public VacinaRepository(EntityManager entityManager) {
        super(entityManager, Vacina.class);
    }
}
