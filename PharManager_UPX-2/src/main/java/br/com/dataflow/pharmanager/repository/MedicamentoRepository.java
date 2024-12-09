package br.com.dataflow.pharmanager.repository;

import br.com.dataflow.pharmanager.model.Medicamento;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 * Repositório responsável pelas operações de persistência e consultas relacionadas aos medicamentos.
 */
public class MedicamentoRepository {
    private final EntityManager entityManager;

    /**
     * Construtor do MedicamentoRepository.
     *
     * @param entityManager O EntityManager responsável pelo gerenciamento de entidades.
     */
    public MedicamentoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Salva ou atualiza um medicamento no banco de dados.
     *
     * @param medicamento O medicamento a ser salvo ou atualizado.
     * @throws RuntimeException Se ocorrer um erro durante a transação.
     */
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
    
    /**
     * Atualiza um medicamento existente com base no ID.
     *
     * @param id O ID do medicamento a ser atualizado.
     * @param medicamento Os novos dados do medicamento.
     * @throws RuntimeException Se o medicamento não for encontrado ou ocorrer um erro durante a transação.
     */
    public void atualizar(Long id, Medicamento medicamento) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Medicamento existente = buscarPorId(id);
            if (existente == null) {
                throw new IllegalArgumentException("Medicamento com ID " + id + " não encontrado.");
            }

            // Atualiza os campos do medicamento existente
            existente.setNome(medicamento.getNome());
            existente.setCategoria(medicamento.getCategoria());
            existente.setComposicao(medicamento.getComposicao());
            existente.setDosagem(medicamento.getDosagem());
            existente.setViaDeAdministracao(medicamento.getViaDeAdministracao());
            existente.setQuantidade(medicamento.getQuantidade());
            existente.setFabricante(medicamento.getFabricante());
            existente.setDataFabricacao(medicamento.getDataFabricacao());
            existente.setDataValidade(medicamento.getDataValidade());
            existente.setEfeitosColaterais(medicamento.getEfeitosColaterais());
            existente.setIndicacao(medicamento.getIndicacao());

            entityManager.merge(existente); // Atualiza o registro no banco
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Reverte a transação em caso de erro
            }
            throw new RuntimeException("Erro ao atualizar o medicamento com ID " + id, e); // Propaga o erro
        }
    }

    /**
     * Lista todos os medicamentos presentes no banco de dados.
     *
     * @return Uma lista contendo todos os medicamentos.
     */
    public List<Medicamento> listarTodos() {
        TypedQuery<Medicamento> query = entityManager.createQuery("SELECT m FROM Medicamento m", Medicamento.class);
        return query.getResultList();
    }

    /**
     * Busca um medicamento pelo ID.
     *
     * @param id O ID do medicamento a ser buscado.
     * @return O medicamento correspondente ao ID ou {@code null} se não for encontrado.
     */
    public Medicamento buscarPorId(Long id) {
        return entityManager.find(Medicamento.class, id);
    }

    /**
     * Exclui um medicamento do banco de dados com base no ID.
     *
     * @param id O ID do medicamento a ser excluído.
     */
    public void excluir(Long id) {
        Medicamento medicamento = buscarPorId(id);
        if (medicamento != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(medicamento);
            entityManager.getTransaction().commit();
        }
    }

    /**
     * Lista medicamentos com base em sua categoria.
     *
     * @param categoria A categoria dos medicamentos a serem listados.
     * @return Uma lista de medicamentos pertencentes à categoria especificada.
     */
    public List<Medicamento> listarPorCategoria(String categoria) {
        TypedQuery<Medicamento> query = entityManager.createQuery(
            "SELECT m FROM Medicamento m WHERE m.categoria = :categoria", Medicamento.class);
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }

    /**
     * Lista medicamentos próximos ao vencimento dentro de um período especificado, excluindo os já vencidos.
     *
     * @param dias O número de dias para considerar como próximo ao vencimento.
     * @return Uma lista de medicamentos que estão próximos ao vencimento.
     */
    public List<Medicamento> listarProximosDoVencimento(int dias) {
        LocalDate dataLimite = LocalDate.now().plusDays(dias);
        LocalDate dataAtual = LocalDate.now();

        TypedQuery<Medicamento> query = entityManager.createQuery(
            "SELECT m FROM Medicamento m WHERE m.dataValidade > :dataAtual AND m.dataValidade <= :dataLimite", 
            Medicamento.class
        );
        query.setParameter("dataAtual", dataAtual);
        query.setParameter("dataLimite", dataLimite);
        return query.getResultList();
    }

    /**
     * Lista medicamentos cujo estoque está abaixo de um limite especificado.
     *
     * @param limite O limite mínimo de estoque.
     * @return Uma lista de medicamentos com estoque abaixo do limite.
     */
    public List<Medicamento> listarPorEstoqueBaixo(int limite) {
        TypedQuery<Medicamento> query = entityManager.createQuery(
            "SELECT m FROM Medicamento m WHERE m.quantidade < :limite", Medicamento.class);
        query.setParameter("limite", limite);
        return query.getResultList();
    }

    /**
     * Lista medicamentos que já estão vencidos.
     *
     * @return Uma lista de medicamentos cuja validade já expirou.
     */
    public List<Medicamento> listarVencidos() {
        TypedQuery<Medicamento> query = entityManager.createQuery(
            "SELECT m FROM Medicamento m WHERE m.dataValidade < CURRENT_DATE", Medicamento.class);
        return query.getResultList();
    }
}