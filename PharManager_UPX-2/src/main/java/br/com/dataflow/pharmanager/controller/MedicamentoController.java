package br.com.dataflow.pharmanager.controller;

import br.com.dataflow.pharmanager.model.Medicamento;
import br.com.dataflow.pharmanager.repository.MedicamentoRepository;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Controlador para gerenciar operações relacionadas a Medicamentos.
 * Fornece métodos para salvar, excluir, buscar e listar medicamentos,
 * bem como para filtrar por categoria, validade e estoque.
 */
public class MedicamentoController {

    private final MedicamentoRepository medicamentoRepository;

    /**
     * Construtor do MedicamentoController.
     *
     * @param entityManager O EntityManager para gerenciar entidades.
     */
    public MedicamentoController(EntityManager entityManager) {
        this.medicamentoRepository = new MedicamentoRepository(entityManager);
    }

    /**
     * Salva um novo medicamento no repositório.
     *
     * @param medicamento O medicamento a ser salvo.
     * @throws Exception Se o medicamento for nulo ou ocorrer um erro durante a persistência.
     */
    public void salvar(Medicamento medicamento) throws Exception {
        if (medicamento == null) {
            throw new IllegalArgumentException("O medicamento não pode ser nulo.");
        }
        medicamentoRepository.salvar(medicamento);
    }
    
    /**
     * Atualiza um medicamento existente com base no ID.
     *
     * @param id O ID do medicamento a ser atualizado.
     * @param medicamento Os novos dados do medicamento.
     * @throws Exception Se o medicamento for nulo, o ID for inválido, ou ocorrer um erro durante a atualização.
     */
    public void atualizar(Long id, Medicamento medicamento) throws Exception {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("O ID do medicamento deve ser válido.");
        }
        if (medicamento == null) {
            throw new IllegalArgumentException("O medicamento não pode ser nulo.");
        }
        medicamentoRepository.atualizar(id, medicamento);
    }

    /**
     * Exclui um medicamento do repositório com base no ID fornecido.
     *
     * @param id O ID do medicamento a ser excluído.
     * @throws Exception Se o ID for inválido ou ocorrer um erro durante a exclusão.
     */
    public void excluir(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido para exclusão.");
        }
        medicamentoRepository.excluir(id);
    }

    /**
     * Busca um medicamento no repositório com base no ID fornecido.
     *
     * @param id O ID do medicamento a ser buscado.
     * @return O medicamento encontrado.
     * @throws Exception Se o ID for inválido ou o medicamento não for encontrado.
     */
    public Medicamento buscarPorId(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido para busca.");
        }
        Medicamento medicamento = medicamentoRepository.buscarPorId(id);
        if (medicamento == null) {
            throw new Exception("Medicamento não encontrado para o ID: " + id);
        }
        return medicamento;
    }

    /**
     * Lista todos os medicamentos presentes no repositório.
     *
     * @return Uma lista de todos os medicamentos.
     */
    public List<Medicamento> listar() {
        return medicamentoRepository.listarTodos();
    }

    /**
     * Lista os medicamentos que pertencem à categoria especificada.
     *
     * @param categoria A categoria dos medicamentos a serem listados.
     * @return Uma lista de medicamentos da categoria especificada.
     * @throws IllegalArgumentException Se a categoria for nula ou vazia.
     */
    public List<Medicamento> listarPorCategoria(String categoria) {
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("Categoria inválida.");
        }
        return medicamentoRepository.listarPorCategoria(categoria);
    }

    /**
     * Lista os medicamentos que estão próximos do vencimento, dentro de um período especificado.
     * Apenas medicamentos que ainda não estão vencidos serão retornados.
     *
     * @param dias Número de dias a partir da data atual para considerar como próximo do vencimento.
     * @return Lista de medicamentos que estão próximos ao vencimento.
     */
    public List<Medicamento> listarProximosVencimento(int dias) {
        return medicamentoRepository.listarProximosDoVencimento(dias);
    }

    /**
     * Lista os medicamentos que já estão vencidos.
     *
     * @return Lista de medicamentos já vencidos.
     */
    public List<Medicamento> listarVencidos() {
        return medicamentoRepository.listarVencidos(); 
    }

    /**
     * Lista os medicamentos cujo estoque está abaixo de um determinado limite.
     *
     * @param limite O limite mínimo de estoque.
     * @return Lista de medicamentos com estoque abaixo do limite especificado.
     * @throws IllegalArgumentException Se o limite for menor ou igual a zero.
     */
    public List<Medicamento> listarPorEstoqueBaixo(int limite) {
        if (limite <= 0) {
            throw new IllegalArgumentException("Limite inválido.");
        }
        return medicamentoRepository.listarPorEstoqueBaixo(limite);
    }
}
