package br.com.dataflow.pharmanager.view;

import javax.persistence.EntityManager;
import javax.swing.*;
import br.com.dataflow.pharmanager.controller.MedicamentoController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Painel para exclusão de medicamentos.
 * 
 * Esta classe fornece uma interface gráfica para que o usuário exclua medicamentos do sistema,
 * informando o ID do medicamento a ser excluído.
 */
public class PanelExcluirMedicamento extends JPanel {

    private MedicamentoController controller;
    private JTextField txtId;

    /**
     * Construtor da classe PanelExcluirMedicamento.
     * 
     * @param entityManager O EntityManager utilizado para gerenciar a conexão com o banco de dados.
     */
    public PanelExcluirMedicamento(EntityManager entityManager) {
        this.controller = new MedicamentoController(entityManager);
        setLayout(null);

        JLabel lblId = new JLabel("ID do Medicamento a excluir:");
        lblId.setBounds(20, 20, 200, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(220, 20, 150, 25);
        add(txtId);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(220, 60, 100, 30);
        add(btnExcluir);

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirMedicamento();
            }
        });
    }

    /**
     * Exclui um medicamento com base no ID informado.
     * 
     * Este método é acionado quando o botão de exclusão é pressionado. 
     * Ele valida o ID fornecido, realiza a exclusão e exibe mensagens apropriadas.
     */
    private void excluirMedicamento() {
        try {
            Long id = Long.parseLong(txtId.getText().trim());
            controller.excluir(id);
            JOptionPane.showMessageDialog(this, "Medicamento excluído com sucesso!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir: " + ex.getMessage());
        }
    }
}
