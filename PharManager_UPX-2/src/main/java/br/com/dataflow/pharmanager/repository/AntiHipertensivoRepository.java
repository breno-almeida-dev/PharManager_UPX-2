package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.AntiHipertensivo;

public class AntiHipertensivoRepository extends GenericRepository<AntiHipertensivo>{
    public AntiHipertensivoRepository(EntityManager entityManager) {
        super(entityManager, AntiHipertensivo.class);
    }
}
