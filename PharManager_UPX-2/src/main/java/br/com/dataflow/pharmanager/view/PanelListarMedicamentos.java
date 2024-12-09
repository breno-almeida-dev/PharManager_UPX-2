package br.com.dataflow.pharmanager.view;

import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import br.com.dataflow.pharmanager.controller.MedicamentoController;
import br.com.dataflow.pharmanager.model.Medicamento;
import java.awt.*;
import java.util.List;

/**
 * Painel para listar todos os medicamentos cadastrados.
 * 
 * Esta classe fornece uma interface gráfica que exibe uma lista de todos os medicamentos
 * cadastrados no sistema, com detalhes como ID, nome, categoria, quantidade e validade.
 */
public class PanelListarMedicamentos extends JPanel {

    private MedicamentoController controller;
    private JTable tabelaMedicamentos;
    private DefaultTableModel tableModel;

    /**
     * Construtor da classe PanelListarMedicamentos.
     * 
     * @param entityManager O EntityManager utilizado para gerenciar a conexão com o banco de dados.
     */
    public PanelListarMedicamentos(EntityManager entityManager) {
        this.controller = new MedicamentoController(entityManager);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new String[]{"ID", "Nome", "Categoria", "Quantidade", "Validade"}, 0);
        tabelaMedicamentos = new JTable(tableModel);
        add(new JScrollPane(tabelaMedicamentos), BorderLayout.CENTER);

        JButton btnCarregar = new JButton("Carregar Lista");
        btnCarregar.addActionListener(e -> carregarLista());
        add(btnCarregar, BorderLayout.SOUTH);
    }

    /**
     * Carrega a lista de medicamentos no painel.
     * 
     * Este método busca os medicamentos do banco de dados e os adiciona à tabela.
     */
    private void carregarLista() {
        tableModel.setRowCount(0);
        List<Medicamento> medicamentos = controller.listar();
        for (Medicamento m : medicamentos) {
            tableModel.addRow(new Object[]{
                    m.getId(),
                    m.getNome(),
                    m.getCategoria(),
                    m.getQuantidade(),
                    m.getDataValidade()
            });
        }
    }
}
