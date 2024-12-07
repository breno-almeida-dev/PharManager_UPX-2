package br.com.dataflow.pharmanager.controller;

import br.com.dataflow.pharmanager.model.Medicamento;
import br.com.dataflow.pharmanager.repository.MedicamentoRepository;
import java.util.List;
import javax.persistence.EntityManager;

public class MedicamentoController {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoController(EntityManager entityManager) {
        this.medicamentoRepository = new MedicamentoRepository(entityManager);
    }

    // Método para salvar um medicamento (já existia)
    public void salvar(Medicamento medicamento) throws Exception {
        if (medicamento == null) {
            throw new IllegalArgumentException("O medicamento não pode ser nulo.");
        }
        medicamentoRepository.salvar(medicamento);
    }

    // Método para excluir um medicamento (já existia)
    public void excluir(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido para exclusão.");
        }
        medicamentoRepository.excluir(id);
    }

    // Método para buscar um medicamento pelo ID (já existia)
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

    // Método para listar todos os medicamentos (já existia)
    public List<Medicamento> listar() {
        return medicamentoRepository.listarTodos();
    }

    // Novo: listar por categoria
    public List<Medicamento> listarPorCategoria(String categoria) {
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("Categoria inválida.");
        }
        return medicamentoRepository.listarPorCategoria(categoria);
    }

    // Novo: listar medicamentos próximos do vencimento (2 meses ~ 60 dias)
    public List<Medicamento> listarProximosVencimento() {
        return medicamentoRepository.listarProximosDoVencimento(60); // 60 dias de margem
    }

    // Novo: listar medicamentos já vencidos
    public List<Medicamento> listarVencidos() {
        return medicamentoRepository.listarVencidos(); 
    }

    // Novo: listar medicamentos com estoque abaixo de um determinado limite
    public List<Medicamento> listarPorEstoqueBaixo(int limite) {
        if (limite <= 0) {
            throw new IllegalArgumentException("Limite inválido.");
        }
        return medicamentoRepository.listarPorEstoqueBaixo(limite);
    }
}
