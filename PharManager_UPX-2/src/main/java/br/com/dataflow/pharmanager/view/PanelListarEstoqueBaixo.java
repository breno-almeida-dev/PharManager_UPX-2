package br.com.dataflow.pharmanager.view;

import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import br.com.dataflow.pharmanager.controller.MedicamentoController;
import br.com.dataflow.pharmanager.model.Medicamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelListarEstoqueBaixo extends JPanel {

    private MedicamentoController controller;
    private JTable tabela;
    private DefaultTableModel model;
    private JTextField txtLimite;

    public PanelListarEstoqueBaixo(EntityManager entityManager) {
        this.controller = new MedicamentoController(entityManager);
        setLayout(null);

        JLabel lblLimite = new JLabel("Limite de estoque:");
        lblLimite.setBounds(20, 20, 120, 25);
        add(lblLimite);

        txtLimite = new JTextField();
        txtLimite.setBounds(140, 20, 100, 25);
        add(txtLimite);

        JButton btnListar = new JButton("Listar Estoque Baixo");
        btnListar.setBounds(250, 20, 160, 25);
        add(btnListar);

        model = new DefaultTableModel(new String[]{"ID", "Nome", "Quantidade"}, 0);
        tabela = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20, 60, 600, 300);
        add(scroll);

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarEstoqueBaixo();
            }
        });
    }

    private void listarEstoqueBaixo() {
        model.setRowCount(0);
        try {
            int limite = Integer.parseInt(txtLimite.getText().trim());
            List<Medicamento> meds = controller.listarPorEstoqueBaixo(limite);
            for (Medicamento m : meds) {
                model.addRow(new Object[]{m.getId(), m.getNome(), m.getQuantidade()});
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe um valor numérico válido para o limite.");
        }
    }
}
