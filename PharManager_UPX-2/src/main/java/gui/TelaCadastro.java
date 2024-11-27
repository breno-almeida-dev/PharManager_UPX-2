package gui;

import dao.UsuarioDAO;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class TelaCadastro extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtSenha;
    private JButton btnSalvar;

    public TelaCadastro() {
        setTitle("Cadastro");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Campos e Botões
        JLabel lblUsername = new JLabel("Usuário:");
        JLabel lblSenha = new JLabel("Senha:");
        txtUsername = new JTextField();
        txtSenha = new JPasswordField();
        btnSalvar = new JButton("Salvar");

        // Adicionar Componentes
        add(lblUsername);
        add(txtUsername);
        add(lblSenha);
        add(txtSenha);
        add(new JLabel());
        add(btnSalvar);

        // Ação do Botão
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarCadastro();
            }
        });
    }

    private void realizarCadastro() {
        String username = txtUsername.getText();
        String senha = new String(txtSenha.getPassword());

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/meubanco", "user", "password")) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            Usuario usuario = new Usuario(username, senha);

            if (usuarioDAO.cadastrarUsuario(usuario)) {
                JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.");
        }
    }
}
