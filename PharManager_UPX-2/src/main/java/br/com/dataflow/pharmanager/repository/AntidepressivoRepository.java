package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.Antidepressivo;

public class AntidepressivoRepository extends GenericRepository<Antidepressivo>{
    public AntidepressivoRepository(EntityManager entityManager) {
        super(entityManager, Antidepressivo.class);
    }
}
