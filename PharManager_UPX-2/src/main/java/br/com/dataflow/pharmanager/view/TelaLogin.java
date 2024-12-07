package br.com.dataflow.pharmanager.view;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.*;

import br.com.dataflow.pharmanager.model.Usuario;
import br.com.dataflow.pharmanager.repository.UsuarioRepository;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnLogin, btnCadastrar;
    private EntityManager entityManager;
    private UsuarioRepository usuarioRepository;

    public TelaLogin() {
        setTitle("Login");
        setSize(358, 283);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Iniciando o EntityManager e Repository
        entityManager = Persistence.createEntityManagerFactory("medicamentoPU").createEntityManager();
        usuarioRepository = new UsuarioRepository(entityManager);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(44, 71, 61, 25);
        getContentPane().add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(91, 71, 160, 25);
        getContentPane().add(txtUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(50, 119, 39, 25);
        getContentPane().add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(91, 119, 160, 25);
        getContentPane().add(txtSenha);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(61, 177, 100, 25);
        getContentPane().add(btnLogin);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(180, 177, 100, 25);
        getContentPane().add(btnCadastrar);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setBounds(148, 11, 46, 25);
        getContentPane().add(lblNewLabel);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tentarLogin();
            }
        });

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });

        centralizarTela();
    }

    private void tentarLogin() {
        String usuarioStr = txtUsuario.getText().trim();
        String senhaStr = new String(txtSenha.getPassword()).trim();

        if (usuarioStr.isEmpty() || senhaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        Usuario usuario = usuarioRepository.buscarPorUsuario(usuarioStr);

        if (usuario == null) {
            int resposta = JOptionPane.showConfirmDialog(
                    this,
                    "Usuário não encontrado. Deseja cadastrar um novo usuário?",
                    "Cadastro",
                    JOptionPane.YES_NO_OPTION
            );
            if (resposta == JOptionPane.YES_OPTION) {
                abrirTelaCadastro();
            }
        } else {
            // Verifica a senha
            if (usuario.getSenha().equals(senhaStr)) {
                JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
                usuario.atualizarUltimoLogin();
                usuarioRepository.atualizar(usuario);
                dispose();

                // Aqui você deve abrir a TelaPrincipal
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "Senha incorreta!");
            }
        }
    }

    private void abrirTelaCadastro() {
        TelaCadastro telaCadastro = new TelaCadastro(this, entityManager);
        telaCadastro.setVisible(true);
    }

    public void limparCampos() {
        txtUsuario.setText("");
        txtSenha.setText("");
    }

    private void centralizarTela() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        setLocation(x, y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaLogin().setVisible(true));
    }
}
