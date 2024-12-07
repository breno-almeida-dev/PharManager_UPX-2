package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.Analgesico;

public class AnalgesicoRepository extends GenericRepository<Analgesico>{
    public AnalgesicoRepository(EntityManager entityManager) {
        super(entityManager, Analgesico.class);
    }
}