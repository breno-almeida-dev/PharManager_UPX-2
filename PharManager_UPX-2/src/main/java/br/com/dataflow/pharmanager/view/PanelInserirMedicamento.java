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
 * Painel para inserir novos medicamentos.
 * 
 * Esta classe fornece uma interface gráfica para inserir as informações de um novo medicamento no sistema.
 * Permite a seleção do tipo de medicamento e ajusta os campos do formulário de acordo com o tipo selecionado.
 */
public class PanelInserirMedicamento extends JPanel {

    private JTextField txtNome, txtCategoria, txtComposicao, txtDosagem, txtViaAdministracao, txtQuantidade,
            txtFabricante, txtDataFabricacao, txtDataValidade, txtEfeitosColaterais, txtIndicacao;
    private JTextField txtTipoDor, txtAtuacao; // Analgésico
    private JTextField txtEspectroDeAcao, txtTipoBacteriaAlvo, txtResistenciaBacteriana; // Antibiótico
    private JTextField txtTipo_AntiInflamatorio, txtFinalidade_AntiInflamatorio; // Anti-inflamatório
    private JTextField txtTipo_Antidepressivo, txtNeurotransmissorAfetado; // Antidepressivo
    private JTextField txtTipoDeFungo, txtLocalDeAplicacao; // Antifungico
    private JTextField txtMecanismoDeAcao_AntiHipertensivo; // AntiHipertensivo
    private JTextField txtTipo_Diuretico, txtCondicaoTratada_Diuretico; // Diuretico
    private JTextField txtTipoDeVirus_Antiviral, txtMecanismoDeAcao_Antiviral; // Antiviral
    private JTextField txtTipoDeVacina, txtDoencaAlvo; // Vacina
    private JTextField txtTipoDeAcao_Anticoagulante, txtCondicaoTratada_Anticoagulante; // Anticoagulante

    private String tipoSelecionado;
    private MedicamentoController controller;

    /**
     * Construtor da classe PanelInserirMedicamento.
     * 
     * @param tipoSelecionado O tipo de medicamento a ser inserido, utilizado para ajustar os campos específicos do formulário.
     * @param entityManager O EntityManager utilizado para gerenciar a conexão com o banco de dados.
     */
    public PanelInserirMedicamento(String tipoSelecionado, EntityManager entityManager) {
        this.tipoSelecionado = tipoSelecionado;
        this.controller = new MedicamentoController(entityManager);
        setLayout(null);
        criarFormulario();
    }

    /**
     * Cria o formulário de entrada de dados do medicamento.
     * 
     * O formulário inclui campos comuns a todos os medicamentos, bem como campos específicos 
     * que variam de acordo com o tipo de medicamento selecionado.
     */
    private void criarFormulario() {
        int y = 20;
        int labelWidth = 200;
        int fieldWidth = 150;
        int fieldHeight = 25;
        int labelX = 20;
        int fieldX = 220;
        int gap = 40;

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

        txtCategoria = new JTextField(tipoSelecionado);
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

        int yTipo = y; 

        if (tipoSelecionado.equals("Analgésico")) {
            JLabel lblTipoDor = new JLabel("Tipo de dor:");
            lblTipoDor.setBounds(20, yTipo, 200, 25);
            this.add(lblTipoDor);

            txtTipoDor = new JTextField();
            txtTipoDor.setBounds(220, yTipo, 150, 25);
            this.add(txtTipoDor);

            yTipo += gap;

            JLabel lblAtuacao = new JLabel("Atuação:");
            lblAtuacao.setBounds(20, yTipo, 200, 25);
            this.add(lblAtuacao);

            txtAtuacao = new JTextField();
            txtAtuacao.setBounds(220, yTipo, 150, 25);
            this.add(txtAtuacao);

            yTipo += gap;

        } else if (tipoSelecionado.equals("Antibiótico")) {
            JLabel lblEspectroDeAcao = new JLabel("Espectro de ação:");
            lblEspectroDeAcao.setBounds(20, yTipo, 200, 25);
            this.add(lblEspectroDeAcao);

            txtEspectroDeAcao = new JTextField();
            txtEspectroDeAcao.setBounds(220, yTipo, 150, 25);
            this.add(txtEspectroDeAcao);

            yTipo += gap;

            JLabel lblBacteriaAlvo = new JLabel("Bactéria alvo:");
            lblBacteriaAlvo.setBounds(20, yTipo, 200, 25);
            this.add(lblBacteriaAlvo);

            txtTipoBacteriaAlvo = new JTextField();
            txtTipoBacteriaAlvo.setBounds(220, yTipo, 150, 25);
            this.add(txtTipoBacteriaAlvo);

            yTipo += gap;

            JLabel lblResistenciaBacteriana = new JLabel("Resistência bacteriana:");
            lblResistenciaBacteriana.setBounds(20, yTipo, 200, 25);
            this.add(lblResistenciaBacteriana);

            txtResistenciaBacteriana = new JTextField();
            txtResistenciaBacteriana.setBounds(220, yTipo, 150, 25);
            this.add(txtResistenciaBacteriana);

            yTipo += gap;

        } else if (tipoSelecionado.equals("Anti-inflamatório")) {
            JLabel lblTipoInflam = new JLabel("Tipo:");
            lblTipoInflam.setBounds(20, yTipo, 200, 25);
            this.add(lblTipoInflam);

            txtTipo_AntiInflamatorio = new JTextField();
            txtTipo_AntiInflamatorio.setBounds(220, yTipo, 150, 25);
            this.add(txtTipo_AntiInflamatorio);

            yTipo += gap;

            JLabel lblFinalidade = new JLabel("Finalidade:");
            lblFinalidade.setBounds(20, yTipo, 200, 25);
            this.add(lblFinalidade);

            txtFinalidade_AntiInflamatorio = new JTextField();
            txtFinalidade_AntiInflamatorio.setBounds(220, yTipo, 150, 25);
            this.add(txtFinalidade_AntiInflamatorio);

            yTipo += gap;

        } else if (tipoSelecionado.equals("Anti-Hipertensivo")) {
            JLabel lblMecanismo = new JLabel("Mecanismo de ação:");
            lblMecanismo.setBounds(20, yTipo, 200, 25);
            this.add(lblMecanismo);

            txtMecanismoDeAcao_AntiHipertensivo = new JTextField();
            txtMecanismoDeAcao_AntiHipertensivo.setBounds(220, yTipo, 150, 25);
            this.add(txtMecanismoDeAcao_AntiHipertensivo);

            yTipo += gap;

        } else if (tipoSelecionado.equals("Anti-Fungico")) {
            JLabel lblTipoFungo = new JLabel("Tipo de fungo:");
            lblTipoFungo.setBounds(20, yTipo, 200, 25);
            this.add(lblTipoFungo);

            txtTipoDeFungo = new JTextField();
            txtTipoDeFungo.setBounds(220, yTipo, 150, 25);
            this.add(txtTipoDeFungo);

            yTipo += gap;

            JLabel lblLocalAplicacao = new JLabel("Local de aplicação:");
            lblLocalAplicacao.setBounds(20, yTipo, 200, 25);
            this.add(lblLocalAplicacao);

            txtLocalDeAplicacao = new JTextField();
            txtLocalDeAplicacao.setBounds(220, yTipo, 150, 25);
            this.add(txtLocalDeAplicacao);

            yTipo += gap;

        } else if (tipoSelecionado.equals("Anti-Depressivo")) {
            JLabel lblTipoDep = new JLabel("Tipo:");
            lblTipoDep.setBounds(20, yTipo, 200, 25);
            this.add(lblTipoDep);

            txtTipo_Antidepressivo = new JTextField();
            txtTipo_Antidepressivo.setBounds(220, yTipo, 150, 25);
            this.add(txtTipo_Antidepressivo);

            yTipo += gap;

            JLabel lblNeurot = new JLabel("Neurotransmissor afetado:");
            lblNeurot.setBounds(20, yTipo, 200, 25);
            this.add(lblNeurot);

            txtNeurotransmissorAfetado = new JTextField();
            txtNeurotransmissorAfetado.setBounds(220, yTipo, 150, 25);
            this.add(txtNeurotransmissorAfetado);

            yTipo += gap;

        } else if (tipoSelecionado.equals("Anti-Coagulante")) {
            JLabel lblTipoAcao = new JLabel("Tipo de ação:");
            lblTipoAcao.setBounds(20, yTipo, 200, 25);
            this.add(lblTipoAcao);

            txtTipoDeAcao_Anticoagulante = new JTextField();
            txtTipoDeAcao_Anticoagulante.setBounds(220, yTipo, 150, 25);
            this.add(txtTipoDeAcao_Anticoagulante);

            yTipo += gap;

            JLabel lblCondicaoTratada = new JLabel("Condição tratada:");
            lblCondicaoTratada.setBounds(20, yTipo, 200, 25);
            this.add(lblCondicaoTratada);

            txtCondicaoTratada_Anticoagulante = new JTextField();
            txtCondicaoTratada_Anticoagulante.setBounds(220, yTipo, 150, 25);
            this.add(txtCondicaoTratada_Anticoagulante);

            yTipo += gap;

        } else if (tipoSelecionado.equals("Vacina")) {
            JLabel lblTipoVacina = new JLabel("Tipo de vacina:");
            lblTipoVacina.setBounds(20, yTipo, 200, 25);
            this.add(lblTipoVacina);

            txtTipoDeVacina = new JTextField();
            txtTipoDeVacina.setBounds(220, yTipo, 150, 25);
            this.add(txtTipoDeVacina);

            yTipo += gap;

            JLabel lblDoencaAlvo = new JLabel("Doença alvo:");
            lblDoencaAlvo.setBounds(20, yTipo, 200, 25);
            this.add(lblDoencaAlvo);

            txtDoencaAlvo = new JTextField();
            txtDoencaAlvo.setBounds(220, yTipo, 150, 25);
            this.add(txtDoencaAlvo);

            yTipo += gap;

        } else if (tipoSelecionado.equals("Antiviral")) {
            JLabel lblTipoVirus = new JLabel("Tipo de vírus:");
            lblTipoVirus.setBounds(20, yTipo, 200, 25);
            this.add(lblTipoVirus);

            txtTipoDeVirus_Antiviral = new JTextField();
            txtTipoDeVirus_Antiviral.setBounds(220, yTipo, 150, 25);
            this.add(txtTipoDeVirus_Antiviral);

            yTipo += gap;

            JLabel lblMecAcaoAntiv = new JLabel("Mecanismo de ação:");
            lblMecAcaoAntiv.setBounds(20, yTipo, 200, 25);
            this.add(lblMecAcaoAntiv);

            txtMecanismoDeAcao_Antiviral = new JTextField();
            txtMecanismoDeAcao_Antiviral.setBounds(220, yTipo, 150, 25);
            this.add(txtMecanismoDeAcao_Antiviral);

            yTipo += gap;

        } else if (tipoSelecionado.equals("Diuretico")) {
            JLabel lblTipoDiuretico = new JLabel("Tipo:");
            lblTipoDiuretico.setBounds(20, yTipo, 200, 25);
            this.add(lblTipoDiuretico);

            txtTipo_Diuretico = new JTextField();
            txtTipo_Diuretico.setBounds(220, yTipo, 150, 25);
            this.add(txtTipo_Diuretico);

            yTipo += gap;

            JLabel lblCondicaoDiuretico = new JLabel("Condição tratada:");
            lblCondicaoDiuretico.setBounds(20, yTipo, 200, 25);
            this.add(lblCondicaoDiuretico);

            txtCondicaoTratada_Diuretico = new JTextField();
            txtCondicaoTratada_Diuretico.setBounds(220, yTipo, 150, 25);
            this.add(txtCondicaoTratada_Diuretico);

            yTipo += gap;
        }

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(220, yTipo + gap, 150, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarMedicamento();
            }
        });
    }

    /**
     * Lida com a ação de salvar o medicamento.
     * 
     * Valida os dados inseridos pelo usuário, cria um objeto do tipo de medicamento apropriado
     * e chama o controlador para salvar o medicamento no banco de dados.
     */
    private void salvarMedicamento() {
        try {
            String nome = txtNome.getText();
            String categoria = txtCategoria.getText();
            String composicao = txtComposicao.getText();
            int dosagem = Integer.parseInt(txtDosagem.getText());
            String viaAdministracao = txtViaAdministracao.getText();
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            String fabricante = txtFabricante.getText();

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataFabricacao = LocalDate.parse(txtDataFabricacao.getText(), fmt);
            LocalDate dataValidade = LocalDate.parse(txtDataValidade.getText(), fmt);

            String efeitosColaterais = txtEfeitosColaterais.getText();
            String indicacao = txtIndicacao.getText();

            Medicamento medicamento;

            if (tipoSelecionado.equals("Analgésico")) {
                String tipoDor = txtTipoDor.getText();
                String atuacao = txtAtuacao.getText();
                medicamento = new Analgesico(nome, categoria, composicao, dosagem, viaAdministracao,
                        quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais,
                        indicacao, tipoDor, atuacao);

            } else if (tipoSelecionado.equals("Antibiótico")) {
                String espectro = txtEspectroDeAcao.getText();
                String bacteriaAlvo = txtTipoBacteriaAlvo.getText();
                String resistencia = txtResistenciaBacteriana.getText();
                medicamento = new Antibiotico(nome, categoria, composicao, dosagem, viaAdministracao,
                        quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais,
                        indicacao, espectro, bacteriaAlvo, resistencia);

            } else if (tipoSelecionado.equals("Anti-inflamatório")) {
                String tipoAntiInflamatorio = txtTipo_AntiInflamatorio.getText();
                String finalidadeAI = txtFinalidade_AntiInflamatorio.getText();
                medicamento = new AntiInflamatorio(nome, categoria, composicao, dosagem, viaAdministracao,
                        quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais,
                        indicacao, tipoAntiInflamatorio, finalidadeAI);

            } else if (tipoSelecionado.equals("Anti-Hipertensivo")) {
                String mecAcao = txtMecanismoDeAcao_AntiHipertensivo.getText();
                medicamento = new AntiHipertensivo(nome, categoria, composicao, dosagem, viaAdministracao,
                        quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais,
                        indicacao, mecAcao);

            } else if (tipoSelecionado.equals("Anti-Fungico")) {
                String tipoFungo = txtTipoDeFungo.getText();
                String localAplic = txtLocalDeAplicacao.getText();
                medicamento = new Antifungico(nome, categoria, composicao, dosagem, viaAdministracao,
                        quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais,
                        indicacao, tipoFungo, localAplic);

            } else if (tipoSelecionado.equals("Anti-Depressivo")) {
                String tipoDep = txtTipo_Antidepressivo.getText();
                String neurot = txtNeurotransmissorAfetado.getText();
                medicamento = new Antidepressivo(nome, categoria, composicao, dosagem, viaAdministracao,
                        quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais,
                        indicacao, tipoDep, neurot);

            } else if (tipoSelecionado.equals("Anti-Coagulante")) {
                String tipoAcao = txtTipoDeAcao_Anticoagulante.getText();
                String condTratadaAntic = txtCondicaoTratada_Anticoagulante.getText();
                medicamento = new Anticoagulante(nome, categoria, composicao, dosagem, viaAdministracao,
                        quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais,
                        indicacao, tipoAcao, condTratadaAntic);

            } else if (tipoSelecionado.equals("Vacina")) {
                String tipoVac = txtTipoDeVacina.getText();
                String doenca = txtDoencaAlvo.getText();
                medicamento = new Vacina(nome, categoria, composicao, dosagem, viaAdministracao,
                        quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais,
                        indicacao, tipoVac, doenca);

            } else if (tipoSelecionado.equals("Antiviral")) {
                String tipoVirus = txtTipoDeVirus_Antiviral.getText();
                String mecAcaoAntiv = txtMecanismoDeAcao_Antiviral.getText();
                medicamento = new Antiviral(nome, categoria, composicao, dosagem, viaAdministracao,
                        quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais,
                        indicacao, tipoVirus, mecAcaoAntiv);

            } else if (tipoSelecionado.equals("Diuretico")) {
                String tipoDiur = txtTipo_Diuretico.getText();
                String condTratDiur = txtCondicaoTratada_Diuretico.getText();
                medicamento = new Diuretico(nome, categoria, composicao, dosagem, viaAdministracao,
                        quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais,
                        indicacao, tipoDiur, condTratDiur);

            } else {
                throw new IllegalArgumentException("Tipo de medicamento não implementado!");
            }
            controller.salvar(medicamento);
            
            JOptionPane.showMessageDialog(this, "Medicamento salvo com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao processar os dados: " + ex.getMessage());
        }
    }
}
