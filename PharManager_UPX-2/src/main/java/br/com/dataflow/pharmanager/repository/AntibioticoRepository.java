package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.Antibiotico;

public class AntibioticoRepository extends GenericRepository<Antibiotico> {
    public AntibioticoRepository(EntityManager entityManager) {
        super(entityManager, Antibiotico.class);
    }
}
