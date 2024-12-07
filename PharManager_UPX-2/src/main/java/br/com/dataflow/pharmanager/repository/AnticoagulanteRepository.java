package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import br.com.dataflow.pharmanager.model.Anticoagulante;

public class AnticoagulanteRepository extends GenericRepository<Anticoagulante>{
    public AnticoagulanteRepository(EntityManager entityManager) {
        super(entityManager, Anticoagulante.class);
    }
}
