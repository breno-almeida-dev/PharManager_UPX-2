package gui;

import dao.UsuarioDAO;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class TelaLogin extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtSenha;
    private JButton btnLogin;
    private JButton btnCadastro;

    public TelaLogin() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Campos e Botões
        JLabel lblUsername = new JLabel("Usuário:");
        JLabel lblSenha = new JLabel("Senha:");
        txtUsername = new JTextField();
        txtSenha = new JPasswordField();
        btnLogin = new JButton("Login");
        btnCadastro = new JButton("Cadastro");

        // Adicionar Componentes
        add(lblUsername);
        add(txtUsername);
        add(lblSenha);
        add(txtSenha);
        add(btnLogin);
        add(btnCadastro);

        // Ações dos Botões
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });

        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastro telaCadastro = new TelaCadastro();
                telaCadastro.setVisible(true);
                dispose();
            }
        });
    }

    private void realizarLogin() {
        String username = txtUsername.getText();
        String senha = new String(txtSenha.getPassword());

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/meubanco", "user", "password")) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            Usuario usuario = usuarioDAO.loginUsuario(username, senha);

            if (usuario != null) {
                JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
                // Redirecionar para a próxima tela
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
        });
    }
}
