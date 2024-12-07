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

public class PanelListarPorCategoria extends JPanel {

    private MedicamentoController controller;
    private JTextField txtCategoria;
    private JTable tabela;
    private DefaultTableModel model;

    public PanelListarPorCategoria(EntityManager entityManager) {
        this.controller = new MedicamentoController(entityManager);
        setLayout(null);

        JLabel lblCat = new JLabel("Categoria:");
        lblCat.setBounds(20, 20, 100, 25);
        add(lblCat);

        txtCategoria = new JTextField();
        txtCategoria.setBounds(120, 20, 150, 25);
        add(txtCategoria);

        JButton btnListar = new JButton("Listar");
        btnListar.setBounds(280, 20, 100, 25);
        add(btnListar);

        model = new DefaultTableModel(new String[]{"ID", "Nome", "Categoria", "Quantidade", "Validade"}, 0);
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
        String categoria = txtCategoria.getText().trim();
        List<Medicamento> meds = controller.listarPorCategoria(categoria);
        for (Medicamento m : meds) {
            model.addRow(new Object[]{m.getId(), m.getNome(), m.getCategoria(), m.getQuantidade(), m.getDataValidade()});
        }
    }
}
