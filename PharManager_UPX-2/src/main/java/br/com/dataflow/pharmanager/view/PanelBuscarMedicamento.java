package br.com.dataflow.pharmanager.view;

import javax.persistence.EntityManager;
import javax.swing.*;
import br.com.dataflow.pharmanager.controller.MedicamentoController;
import br.com.dataflow.pharmanager.model.Medicamento;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Painel para busca de medicamentos.
 * 
 * Esta classe fornece uma interface gráfica para buscar e exibir os dados de medicamentos no sistema.
 * O usuário pode inserir o ID de um medicamento para visualizar seus atributos detalhados.
 */
public class PanelBuscarMedicamento extends JPanel {

    private MedicamentoController controller;
    private JTextField txtId;
    private JTextArea txtResultado;

    /**
     * Construtor da classe PanelBuscarMedicamento.
     * 
     * @param entityManager O EntityManager utilizado para gerenciar a conexão com o banco de dados.
     */
    public PanelBuscarMedicamento(EntityManager entityManager) {
        this.controller = new MedicamentoController(entityManager);
        setLayout(null);

        JLabel lblId = new JLabel("ID do Medicamento:");
        lblId.setBounds(20, 20, 150, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(180, 20, 150, 25);
        add(txtId);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(180, 60, 100, 30);
        add(btnBuscar);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        scrollPane.setBounds(20, 100, 400, 200);
        add(scrollPane);

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarMedicamento();
            }
        });
    }

    /**
     * Realiza a busca de um medicamento pelo ID informado.
     * 
     * Exibe os dados do medicamento em um painel de texto caso ele seja encontrado.
     * Caso o ID seja inválido ou o medicamento não seja encontrado, exibe mensagens de erro apropriadas.
     */
    private void buscarMedicamento() {
        try {
            Long id = Long.parseLong(txtId.getText().trim());
            Medicamento med = controller.buscarPorId(id);
            txtResultado.setText("ID: " + med.getId() + "\n"
                    + "Nome: " + med.getNome() + "\n"
                    + "Categoria: " + med.getCategoria() + "\n"
                    + "Composição: " + med.getComposicao() + "\n"
                    + "Dosagem: " + med.getDosagem() + "\n"
                    + "Via Adm.: " + med.getViaDeAdministracao() + "\n"
                    + "Quantidade: " + med.getQuantidade() + "\n"
                    + "Fabricante: " + med.getFabricante() + "\n"
                    + "Data Fab.: " + med.getDataFabricacao() + "\n"
                    + "Validade: " + med.getDataValidade() + "\n"
                    + "Efeitos Colaterais: " + med.getEfeitosColaterais() + "\n"
                    + "Indicação: " + med.getIndicacao());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }
}
