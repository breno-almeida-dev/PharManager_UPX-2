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

/**
 * Tela de login para autenticação de usuários.
 * 
 * Esta classe representa a interface gráfica para o processo de login, 
 * permitindo que os usuários insiram suas credenciais e sejam autenticados.
 * Oferece também a opção de abrir a tela de cadastro para criar novos usuários.
 * 
 * Funcionalidades principais:
 * - Autenticação de usuário.
 * - Navegação para a tela de cadastro em caso de usuário não registrado.
 * - Abertura da tela principal após login bem-sucedido.
 */
public class TelaLogin extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnLogin, btnCadastrar;
    private EntityManager entityManager;
    private UsuarioRepository usuarioRepository;

    /**
     * Construtor da classe TelaLogin.
     * Inicializa a interface gráfica, configura os componentes de entrada
     * e conecta o repositório de usuários.
     */
    public TelaLogin() {
        setTitle("Login");
        setSize(358, 283);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

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

    /**
     * Realiza o processo de login verificando as credenciais do usuário.
     * - Exibe mensagens de erro para campos vazios, credenciais inválidas ou senha incorreta.
     * - Abre a tela principal caso o login seja bem-sucedido.
     * - Permite ao usuário abrir a tela de cadastro caso o login falhe.
     */
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

    /**
     * Abre a tela de cadastro para registro de novos usuários.
     * 
     * A tela de cadastro é exibida em uma nova janela.
     */
    private void abrirTelaCadastro() {
        TelaCadastro telaCadastro = new TelaCadastro(this, entityManager);
        telaCadastro.setVisible(true);
    }

    /**
     * Limpa os campos de entrada de texto da tela de login.
     * 
     * Este método é utilizado para resetar os valores dos campos
     * após ações como o cadastro de um novo usuário.
     */
    public void limparCampos() {
        txtUsuario.setText("");
        txtSenha.setText("");
    }

    /**
     * Centraliza a janela na tela do monitor.
     * 
     * O posicionamento da janela é calculado com base nas dimensões da tela.
     */
    private void centralizarTela() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        setLocation(x, y);
    }

    /**
     * Método principal para executar a aplicação.
     * 
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaLogin().setVisible(true));
    }
}
