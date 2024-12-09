package br.com.dataflow.pharmanager.view;

import javax.persistence.EntityManager;
import javax.swing.*;
import br.com.dataflow.pharmanager.model.*;
import br.com.dataflow.pharmanager.controller.MedicamentoController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Painel para atualização de medicamentos.
 * 
 * Esta classe fornece uma interface gráfica para buscar e atualizar os dados de medicamentos existentes no sistema.
 * Permite ao usuário buscar um medicamento pelo ID e alterar seus atributos antes de salvar as alterações.
 */
public class PanelAtualizarMedicamento extends JPanel {

    private JTextField txtId, txtNome, txtCategoria, txtComposicao, txtDosagem, txtViaAdministracao,
            txtQuantidade, txtFabricante, txtDataFabricacao, txtDataValidade, txtEfeitosColaterais, txtIndicacao;
    private MedicamentoController controller;
    private Medicamento medicamentoAtual;

    /**
     * Construtor da classe PanelAtualizarMedicamento.
     * 
     * @param entityManager O EntityManager utilizado para gerenciar a conexão com o banco de dados.
     */
    public PanelAtualizarMedicamento(EntityManager entityManager) {
        this.controller = new MedicamentoController(entityManager);
        setLayout(null);
        criarFormulario();
    }

    /**
     * Cria o formulário para entrada e exibição dos dados do medicamento.
     * 
     * O formulário inclui campos para todos os atributos do medicamento, bem como botões para buscar e atualizar.
     */
    private void criarFormulario() {
        int y = 20;
        int labelWidth = 200;
        int fieldWidth = 150;
        int fieldHeight = 25;
        int labelX = 20;
        int fieldX = 220;
        int gap = 40;

        JLabel lblId = new JLabel("ID do Medicamento:");
        lblId.setBounds(labelX, y, labelWidth, fieldHeight);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(fieldX, y, fieldWidth, fieldHeight);
        add(txtId);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(fieldX + 170, y, 100, fieldHeight);
        btnBuscar.addActionListener(e -> buscarMedicamento());
        add(btnBuscar);

        y += gap;

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(labelX, y, labelWidth, fieldHeight);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(fieldX, y, fieldWidth, fieldHeight);
        add(txtNome);

        y += gap;

        JLabel lblCategoria = new JLabel("Categoria:");
        lblCategoria.setBounds(labelX, y, labelWidth, fieldHeight);
        add(lblCategoria);

        txtCategoria = new JTextField();
        txtCategoria.setBounds(fieldX, y, fieldWidth, fieldHeight);
        txtCategoria.setEditable(false);
        add(txtCategoria);

        y += gap;

        JLabel lblComposicao = new JLabel("Composição (substâncias):");
        lblComposicao.setBounds(labelX, y, labelWidth, fieldHeight);
        add(lblComposicao);

        txtComposicao = new JTextField();
        txtComposicao.setBounds(fieldX, y, fieldWidth, fieldHeight);
        add(txtComposicao);

        y += gap;

        JLabel lblDosagem = new JLabel("Dosagem (mg, mL, etc.):");
        lblDosagem.setBounds(labelX, y, labelWidth, fieldHeight);
        add(lblDosagem);

        txtDosagem = new JTextField();
        txtDosagem.setBounds(fieldX, y, fieldWidth, fieldHeight);
        add(txtDosagem);

        y += gap;

        JLabel lblViaAdministracao = new JLabel("Via de Administração:");
        lblViaAdministracao.setBounds(labelX, y, labelWidth, fieldHeight);
        add(lblViaAdministracao);

        txtViaAdministracao = new JTextField();
        txtViaAdministracao.setBounds(fieldX, y, fieldWidth, fieldHeight);
        add(txtViaAdministracao);

        y += gap;

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(labelX, y, labelWidth, fieldHeight);
        add(lblQuantidade);

        txtQuantidade = new JTextField();
        txtQuantidade.setBounds(fieldX, y, fieldWidth, fieldHeight);
        add(txtQuantidade);

        y += gap;

        JLabel lblFabricante = new JLabel("Fabricante:");
        lblFabricante.setBounds(labelX, y, labelWidth, fieldHeight);
        add(lblFabricante);

        txtFabricante = new JTextField();
        txtFabricante.setBounds(fieldX, y, fieldWidth, fieldHeight);
        add(txtFabricante);

        y += gap;

        JLabel lblDataFabricacao = new JLabel("Data de Fabricação (dd/MM/yyyy):");
        lblDataFabricacao.setBounds(labelX, y, labelWidth, fieldHeight);
        add(lblDataFabricacao);

        txtDataFabricacao = new JTextField();
        txtDataFabricacao.setBounds(fieldX, y, fieldWidth, fieldHeight);
        add(txtDataFabricacao);

        y += gap;

        JLabel lblDataValidade = new JLabel("Data de Validade (dd/MM/yyyy):");
        lblDataValidade.setBounds(labelX, y, labelWidth, fieldHeight);
        add(lblDataValidade);

        txtDataValidade = new JTextField();
        txtDataValidade.setBounds(fieldX, y, fieldWidth, fieldHeight);
        add(txtDataValidade);

        y += gap;

        JLabel lblEfeitosColaterais = new JLabel("Efeitos Colaterais:");
        lblEfeitosColaterais.setBounds(labelX, y, labelWidth, fieldHeight);
        add(lblEfeitosColaterais);

        txtEfeitosColaterais = new JTextField();
        txtEfeitosColaterais.setBounds(fieldX, y, fieldWidth, fieldHeight);
        add(txtEfeitosColaterais);

        y += gap;

        JLabel lblIndicacao = new JLabel("Indicação:");
        lblIndicacao.setBounds(labelX, y, labelWidth, fieldHeight);
        add(lblIndicacao);

        txtIndicacao = new JTextField();
        txtIndicacao.setBounds(fieldX, y, fieldWidth, fieldHeight);
        add(txtIndicacao);

        y += gap;

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(fieldX, y + gap, 150, fieldHeight);
        btnAtualizar.addActionListener(e -> atualizarMedicamento());
        add(btnAtualizar);
    }

    /**
     * Busca um medicamento no banco de dados pelo ID informado.
     * 
     * Exibe os dados do medicamento nos campos apropriados do formulário. Caso o ID seja inválido ou o medicamento
     * não seja encontrado, exibe mensagens de erro apropriadas.
     */
    private void buscarMedicamento() {
        try {
            Long id = Long.parseLong(txtId.getText().trim());
            medicamentoAtual = controller.buscarPorId(id);

            if (medicamentoAtual == null) {
                JOptionPane.showMessageDialog(this, "Medicamento não encontrado.");
                return;
            }

            txtNome.setText(medicamentoAtual.getNome());
            txtCategoria.setText(medicamentoAtual.getCategoria());
            txtComposicao.setText(medicamentoAtual.getComposicao());
            txtDosagem.setText(String.valueOf(medicamentoAtual.getDosagem()));
            txtViaAdministracao.setText(medicamentoAtual.getViaDeAdministracao());
            txtQuantidade.setText(String.valueOf(medicamentoAtual.getQuantidade()));
            txtFabricante.setText(medicamentoAtual.getFabricante());
            txtDataFabricacao.setText(medicamentoAtual.getDataFabricacao().toString());
            txtDataValidade.setText(medicamentoAtual.getDataValidade().toString());
            txtEfeitosColaterais.setText(medicamentoAtual.getEfeitosColaterais());
            txtIndicacao.setText(medicamentoAtual.getIndicacao());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar medicamento: " + ex.getMessage());
        }
    }

    /**
     * Atualiza os dados do medicamento carregado no formulário.
     * 
     * Valida os dados de entrada, atualiza o objeto do medicamento e salva as alterações no banco de dados.
     * Caso o medicamento não esteja carregado ou ocorra algum erro, exibe mensagens informativas.
     */
    private void atualizarMedicamento() {
        if (medicamentoAtual == null) {
            JOptionPane.showMessageDialog(this, "Nenhum medicamento foi carregado para atualizar.");
            return;
        }

        try {
            medicamentoAtual.setNome(txtNome.getText());
            medicamentoAtual.setComposicao(txtComposicao.getText());
            medicamentoAtual.setDosagem(Integer.parseInt(txtDosagem.getText()));
            medicamentoAtual.setViaDeAdministracao(txtViaAdministracao.getText());
            medicamentoAtual.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
            medicamentoAtual.setFabricante(txtFabricante.getText());

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            medicamentoAtual.setDataFabricacao(LocalDate.parse(txtDataFabricacao.getText(), fmt));
            medicamentoAtual.setDataValidade(LocalDate.parse(txtDataValidade.getText(), fmt));

            medicamentoAtual.setEfeitosColaterais(txtEfeitosColaterais.getText());
            medicamentoAtual.setIndicacao(txtIndicacao.getText());

            controller.atualizar(medicamentoAtual.getId(), medicamentoAtual);

            JOptionPane.showMessageDialog(this, "Medicamento atualizado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar o medicamento: " + ex.getMessage());
        }
    }
}
