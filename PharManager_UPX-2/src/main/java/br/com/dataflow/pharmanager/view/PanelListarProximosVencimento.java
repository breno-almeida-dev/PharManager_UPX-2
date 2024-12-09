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
 * Painel para listar medicamentos que estão próximos do vencimento.
 * 
 * Esta classe exibe uma interface gráfica que permite ao usuário visualizar medicamentos
 * cuja data de validade está próxima, dentro de um intervalo especificado em dias.
 */
public class PanelListarProximosVencimento extends JPanel {

    private MedicamentoController controller;
    private JTable tabela;
    private DefaultTableModel model;
    private JTextField txtDias;

    /**
     * Construtor da classe PanelListarProximosVencimento.
     * 
     * @param entityManager O EntityManager utilizado para gerenciar a conexão com o banco de dados.
     */
    public PanelListarProximosVencimento(EntityManager entityManager) {
        this.controller = new MedicamentoController(entityManager);
        setLayout(null);

        JLabel lblDias = new JLabel("Dias até o vencimento:");
        lblDias.setBounds(20, 20, 200, 25);
        add(lblDias);

        txtDias = new JTextField("60"); // Valor padrão
        txtDias.setBounds(200, 20, 50, 25);
        add(txtDias);

        JButton btnListar = new JButton("Listar Próximos a Vencer");
        btnListar.setBounds(270, 20, 200, 25);
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

    /**
     * Lista os medicamentos cuja validade está próxima com base no número de dias fornecido.
     * 
     * Obtém o número de dias a partir do campo de texto, consulta o controlador
     * para buscar os medicamentos e exibe os resultados na tabela.
     */
    private void listar() {
        try {
            int dias = Integer.parseInt(txtDias.getText().trim()); // Obtém os dias do campo de texto
            model.setRowCount(0);
            List<Medicamento> meds = controller.listarProximosVencimento(dias);
            for (Medicamento m : meds) {
                model.addRow(new Object[]{m.getId(), m.getNome(), m.getDataValidade()});
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um número válido para os dias.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
