package br.com.dataflow.pharmanager.view;

import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import br.com.dataflow.pharmanager.controller.MedicamentoController;
import br.com.dataflow.pharmanager.model.Medicamento;
import java.awt.*;
import java.util.List;

public class PanelListarMedicamentos extends JPanel {

    private MedicamentoController controller;
    private JTable tabelaMedicamentos;
    private DefaultTableModel tableModel;

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
