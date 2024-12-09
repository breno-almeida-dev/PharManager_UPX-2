package br.com.dataflow.pharmanager.view;

import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import br.com.dataflow.pharmanager.controller.MedicamentoController;
import br.com.dataflow.pharmanager.model.Medicamento;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Painel para listar medicamentos por categoria.
 * 
 * Esta classe fornece uma interface gráfica para que o usuário selecione uma categoria
 * e veja uma lista de medicamentos pertencentes a ela, com detalhes como ID, nome, quantidade e validade.
 */
public class PanelListarPorCategoria extends JPanel {

    private JComboBox<String> comboBoxCategoria;
    private JTable tabela;
    private DefaultTableModel model;
    private MedicamentoController controller;

    /**
     * Construtor da classe PanelListarPorCategoria.
     * 
     * @param entityManager O EntityManager utilizado para gerenciar a conexão com o banco de dados.
     */
    public PanelListarPorCategoria(EntityManager entityManager) {
        this.controller = new MedicamentoController(entityManager);
        setLayout(new BorderLayout());
        setBackground(new Color(5, 81, 66));

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new FlowLayout());
        panelTop.setBackground(new Color(5, 81, 66));

        String[] categorias = {"Analgésico", "Antibiótico", "Anti-inflamatório", "Anti-Hipertensivo", "Anti-Fungico", 
                                "Anti-Depressivo", "Anti-Coagulante", "Vacina", "Antiviral", "Diuretico"};

        JLabel lblCategoria = new JLabel("Categoria:");
        lblCategoria.setForeground(Color.WHITE);
        panelTop.add(lblCategoria);

        comboBoxCategoria = new JComboBox<>(categorias);
        panelTop.add(comboBoxCategoria);

        JButton btnListar = new JButton("Listar");
        btnListar.setBackground(new Color(255, 255, 239));
        btnListar.setForeground(Color.BLACK);
        btnListar.addActionListener(e -> listar());
        panelTop.add(btnListar);

        add(panelTop, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"ID", "Nome", "Categoria", "Quantidade", "Validade"}, 0);
        tabela = new JTable(model);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }

    /**
     * Lista os medicamentos pertencentes à categoria selecionada.
     * 
     * Este método busca os medicamentos no banco de dados com base na categoria escolhida
     * e exibe os resultados na tabela.
     */
    private void listar() {
        model.setRowCount(0);
        String categoria = comboBoxCategoria.getSelectedItem().toString();
        List<Medicamento> meds = controller.listarPorCategoria(categoria);
        for (Medicamento m : meds) {
            model.addRow(new Object[]{m.getId(), m.getNome(), m.getCategoria(), m.getQuantidade(), m.getDataValidade()});
        }
    }
}
