package br.com.dataflow.pharmanager.view;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    private JPanel panelLateral, panelPrincipal;
    private CardLayout cardLayout;
    private EntityManager entityManager;

    public TelaPrincipal() {
        setTitle("Tela Principal");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Cria o EntityManager uma vez, para ser reutilizado
        entityManager = Persistence.createEntityManagerFactory("medicamentoPU").createEntityManager();

        panelLateral = new JPanel();
        panelLateral.setLayout(new BoxLayout(panelLateral, BoxLayout.Y_AXIS));

        // Botão para adicionar medicamento
        JButton btnAdicionarMedicamento = new JButton("Adicionar Medicamento");
        btnAdicionarMedicamento.addActionListener(e -> cardLayout.show(panelPrincipal, "EscolherTipoMedicamento"));
        panelLateral.add(btnAdicionarMedicamento);

        // Botão para listar todos os medicamentos
        JButton btnListar = new JButton("Listar Medicamentos");
        btnListar.addActionListener(e -> {
            PanelListarMedicamentos panelListar = new PanelListarMedicamentos(entityManager);
            panelPrincipal.add(panelListar, "ListarMedicamentos");
            cardLayout.show(panelPrincipal, "ListarMedicamentos");
        });
        panelLateral.add(Box.createVerticalStrut(20));
        panelLateral.add(btnListar);

        // Botão para buscar medicamento por ID
        JButton btnBuscar = new JButton("Buscar Medicamento por ID");
        btnBuscar.addActionListener(e -> {
            PanelBuscarMedicamento panelBuscar = new PanelBuscarMedicamento(entityManager);
            panelPrincipal.add(panelBuscar, "BuscarMedicamento");
            cardLayout.show(panelPrincipal, "BuscarMedicamento");
        });
        panelLateral.add(Box.createVerticalStrut(20));
        panelLateral.add(btnBuscar);

        // Botão para excluir medicamento
        JButton btnExcluir = new JButton("Excluir Medicamento por ID");
        btnExcluir.addActionListener(e -> {
            PanelExcluirMedicamento panelExcluir = new PanelExcluirMedicamento(entityManager);
            panelPrincipal.add(panelExcluir, "ExcluirMedicamento");
            cardLayout.show(panelPrincipal, "ExcluirMedicamento");
        });
        panelLateral.add(Box.createVerticalStrut(20));
        panelLateral.add(btnExcluir);

        // **Novos botões para as funcionalidades adicionais**

        // Listar por Categoria
        JButton btnListarPorCategoria = new JButton("Listar por Categoria");
        btnListarPorCategoria.addActionListener(e -> {
            PanelListarPorCategoria panelCat = new PanelListarPorCategoria(entityManager);
            panelPrincipal.add(panelCat, "ListarPorCategoria");
            cardLayout.show(panelPrincipal, "ListarPorCategoria");
        });
        panelLateral.add(Box.createVerticalStrut(20));
        panelLateral.add(btnListarPorCategoria);

        // Listar Próximos do Vencimento (2 meses)
        JButton btnProximosVenc = new JButton("Medicamentos Próximos do Vencimento");
        btnProximosVenc.addActionListener(e -> {
            PanelListarProximosVencimento panelProx = new PanelListarProximosVencimento(entityManager);
            panelPrincipal.add(panelProx, "ProximosVencimento");
            cardLayout.show(panelPrincipal, "ProximosVencimento");
        });
        panelLateral.add(Box.createVerticalStrut(20));
        panelLateral.add(btnProximosVenc);

        // Listar Medicamentos Vencidos
        JButton btnVencidos = new JButton("Medicamentos Vencidos");
        btnVencidos.addActionListener(e -> {
            PanelListarVencidos panelVenc = new PanelListarVencidos(entityManager);
            panelPrincipal.add(panelVenc, "Vencidos");
            cardLayout.show(panelPrincipal, "Vencidos");
        });
        panelLateral.add(Box.createVerticalStrut(20));
        panelLateral.add(btnVencidos);

        // Listar Medicamentos por Estoque Baixo
        JButton btnEstoqueBaixo = new JButton("Estoque Baixo");
        btnEstoqueBaixo.addActionListener(e -> {
            PanelListarEstoqueBaixo panelEstoque = new PanelListarEstoqueBaixo(entityManager);
            panelPrincipal.add(panelEstoque, "EstoqueBaixo");
            cardLayout.show(panelPrincipal, "EstoqueBaixo");
        });
        panelLateral.add(Box.createVerticalStrut(20));
        panelLateral.add(btnEstoqueBaixo);

        // Botão de Logout
        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(e -> {
            dispose();
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
        });
        panelLateral.add(Box.createVerticalStrut(20));
        panelLateral.add(btnLogout);

        panelPrincipal = new JPanel();
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);

        String[] tipos = {
                "Analgésico", "Antibiótico", "Anti-inflamatório",
                "Anti-Hipertensivo", "Anti-Fungico", "Anti-Depressivo",
                "Anti-Coagulante", "Vacina", "Antiviral", "Diuretico"
        };

        JPanel panelEscolherTipo = new JPanel();
        JLabel lblEscolherTipo = new JLabel("Escolha o tipo de medicamento:");
        JComboBox<String> comboBoxTipos = new JComboBox<>(tipos);
        JButton btnConfirmarTipo = new JButton("Confirmar");

        panelEscolherTipo.add(lblEscolherTipo);
        panelEscolherTipo.add(comboBoxTipos);
        panelEscolherTipo.add(btnConfirmarTipo);

        btnConfirmarTipo.addActionListener(e -> {
            String tipoSelecionado = (String) comboBoxTipos.getSelectedItem();
            PanelInserirMedicamento panelInserir = new PanelInserirMedicamento(tipoSelecionado, entityManager);
            panelPrincipal.add(panelInserir, "InserirMedicamento");
            cardLayout.show(panelPrincipal, "InserirMedicamento");
        });

        panelPrincipal.add(panelEscolherTipo, "EscolherTipoMedicamento");
        cardLayout.show(panelPrincipal, "EscolherTipoMedicamento");

        getContentPane().add(panelLateral, BorderLayout.WEST);
        getContentPane().add(panelPrincipal, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }
}
