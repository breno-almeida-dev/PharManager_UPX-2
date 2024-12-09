package br.com.dataflow.pharmanager.view;

import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import br.com.dataflow.pharmanager.controller.MedicamentoController;
import br.com.dataflow.pharmanager.model.Medicamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Painel para listar medicamentos vencidos.
 * 
 * Esta classe fornece uma interface gráfica que permite ao usuário visualizar
 * todos os medicamentos cujo prazo de validade já expirou.
 */
public class PanelListarVencidos extends JPanel {

    private MedicamentoController controller;
    private JTable tabela;
    private DefaultTableModel model;

    /**
     * Construtor da classe PanelListarVencidos.
     * 
     * @param entityManager O EntityManager utilizado para gerenciar a conexão com o banco de dados.
     */
    public PanelListarVencidos(EntityManager entityManager) {
        this.controller = new MedicamentoController(entityManager);
        setLayout(null);

        JButton btnListar = new JButton("Listar Medicamentos Vencidos");
        btnListar.setBounds(20, 20, 200, 25);
        add(btnListar);

        model = new DefaultTableModel(new String[]{"ID", "Nome", "Data Validade"}, 0);
        tabela = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20, 60, 600, 300);
        add(scroll);

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarVencidos();
            }
        });
    }

    /**
     * Lista os medicamentos que já estão vencidos.
     * 
     * Este método consulta o controlador para buscar os medicamentos vencidos
     * e os exibe na tabela presente no painel.
     */
    private void listarVencidos() {
        model.setRowCount(0);
        List<Medicamento> meds = controller.listarVencidos();
        for (Medicamento m : meds) {
            model.addRow(new Object[]{m.getId(), m.getNome(), m.getDataValidade()});
        }
    }
}
