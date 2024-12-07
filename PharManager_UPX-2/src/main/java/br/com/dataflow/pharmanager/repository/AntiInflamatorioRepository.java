package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.AntiInflamatorio;

public class AntiInflamatorioRepository extends GenericRepository<AntiInflamatorio>{
    public AntiInflamatorioRepository(EntityManager entityManager) {
        super(entityManager, AntiInflamatorio.class);
    }
}