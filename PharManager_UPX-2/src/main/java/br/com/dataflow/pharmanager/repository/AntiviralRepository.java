package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.Antiviral;

public class AntiviralRepository extends GenericRepository<Antiviral>{
    public AntiviralRepository(EntityManager entityManager) {
        super(entityManager, Antiviral.class);
    }
}
