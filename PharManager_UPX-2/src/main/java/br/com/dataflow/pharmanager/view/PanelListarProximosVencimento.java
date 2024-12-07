package br.com.dataflow.pharmanager.view;

import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import br.com.dataflow.pharmanager.controller.MedicamentoController;
import br.com.dataflow.pharmanager.model.Medicamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelListarProximosVencimento extends JPanel {

    private MedicamentoController controller;
    private JTable tabela;
    private DefaultTableModel model;

    public PanelListarProximosVencimento(EntityManager entityManager) {
        this.controller = new MedicamentoController(entityManager);
        setLayout(null);

        JButton btnListar = new JButton("Listar Próximos a Vencer");
        btnListar.setBounds(20, 20, 200, 25);
        add(btnListar);

        model = new DefaultTableModel(new String[]{"ID", "Nome", "Validade"}, 0);
        tabela = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20, 60, 600, 300);
        add(scroll);

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listar();
            }
        });
    }

    private void listar() {
        model.setRowCount(0);
        List<Medicamento> meds = controller.listarProximosVencimento();
        for (Medicamento m : meds) {
            model.addRow(new Object[]{m.getId(), m.getNome(), m.getDataValidade()});
        }
    }
}
