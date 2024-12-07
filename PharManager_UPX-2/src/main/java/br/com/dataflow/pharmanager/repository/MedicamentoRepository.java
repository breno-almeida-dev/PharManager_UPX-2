package br.com.dataflow.pharmanager.repository;

import br.com.dataflow.pharmanager.model.Medicamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class MedicamentoRepository {
    private final EntityManager entityManager;

    // Construtor para injeção do EntityManager    
    public MedicamentoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Método para salvar ou atualizar um Medicamento
    public void salvar(Medicamento medicamento) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            if (medicamento.getId() == null) {
                entityManager.persist(medicamento); // Novo registro
            } else {
                entityManager.merge(medicamento); // Atualiza registro existente
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Reverte a transação em caso de erro
            }
            throw new RuntimeException("Erro ao salvar o medicamento", e); // Propaga o erro
        }
    }

    // Método para listar todos os medicamentos
    public List<Medicamento> listarTodos() {
        TypedQuery<Medicamento> query = entityManager.createQuery("SELECT m FROM Medicamento m", Medicamento.class);
        return query.getResultList();
    }

    // Método para buscar um Medicamento por ID
    public Medicamento buscarPorId(Long id) {
        return entityManager.find(Medicamento.class, id);
    }

    // Método para excluir um Medicamento pelo ID
    public void excluir(Long id) {
        Medicamento medicamento = buscarPorId(id);
        if (medicamento != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(medicamento);
            entityManager.getTransaction().commit();
        }
    }

    // Método para listar medicamentos por categoria
    public List<Medicamento> listarPorCategoria(String categoria) {
        TypedQuery<Medicamento> query = entityManager.createQuery(
            "SELECT m FROM Medicamento m WHERE m.categoria = :categoria", Medicamento.class);
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }

    // Método para listar medicamentos próximos ao vencimento
    public List<Medicamento> listarProximosDoVencimento(int dias) {
        TypedQuery<Medicamento> query = entityManager.createQuery(
            "SELECT m FROM Medicamento m WHERE m.dataValidade <= CURRENT_DATE + :dias", Medicamento.class);
        query.setParameter("dias", dias);
        return query.getResultList();
    }

    // Método para listar medicamentos com estoque abaixo de um limite
    public List<Medicamento> listarPorEstoqueBaixo(int limite) {
        TypedQuery<Medicamento> query = entityManager.createQuery(
            "SELECT m FROM Medicamento m WHERE m.quantidade < :limite", Medicamento.class);
        query.setParameter("limite", limite);
        return query.getResultList();
    }
    
    public List<Medicamento> listarVencidos() {
        TypedQuery<Medicamento> query = entityManager.createQuery(
            "SELECT m FROM Medicamento m WHERE m.dataValidade < CURRENT_DATE", Medicamento.class);
        return query.getResultList();
    }
}