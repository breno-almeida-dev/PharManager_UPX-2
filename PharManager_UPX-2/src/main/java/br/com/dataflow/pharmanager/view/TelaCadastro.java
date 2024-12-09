package br.com.dataflow.pharmanager.view;

import javax.persistence.EntityManager;
import javax.swing.*;

import br.com.dataflow.pharmanager.model.Usuario;
import br.com.dataflow.pharmanager.repository.UsuarioRepository;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tela de cadastro para criação de novos usuários.
 * 
 * Esta classe representa a interface gráfica para registrar novos usuários
 * no sistema. Os dados do novo usuário (nome, usuário e senha) são salvos
 * no banco de dados.
 * 
 * Funcionalidades principais:
 * - Registro de novos usuários.
 * - Integração com a tela de login para atualização do estado após o cadastro.
 */
public class TelaCadastro extends JFrame {
    private JTextField txtNome, txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnSalvar;
    private TelaLogin telaLogin;
    private EntityManager entityManager;
    private UsuarioRepository usuarioRepository;

    /**
     * Construtor da classe TelaCadastro.
     * 
     * @param telaLogin Referência para a tela de login, permitindo comunicação entre as telas.
     * @param entityManager EntityManager para gerenciar a persistência de dados.
     */
    public TelaCadastro(TelaLogin telaLogin, EntityManager entityManager) {
        this.telaLogin = telaLogin;
        this.entityManager = entityManager;
        this.usuarioRepository = new UsuarioRepository(entityManager);

        setTitle("Cadastro de Usuário");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 80, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(100, 20, 200, 25);
        add(txtNome);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(20, 60, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 60, 200, 25);
        add(txtUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(20, 100, 80, 25);
        add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 100, 200, 25);
        add(txtSenha);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(130, 150, 100, 25);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });

        centralizarTela();
    }

    /**
     * Realiza o processo de cadastro de um novo usuário.
     * 
     * Valida os campos de entrada (nome, usuário e senha) e salva os dados
     * no banco de dados. Exibe mensagens informativas em caso de sucesso ou erro.
     */
    private void cadastrarUsuario() {
        String nome = txtNome.getText().trim();
        String usuarioStr = txtUsuario.getText().trim();
        String senhaStr = new String(txtSenha.getPassword()).trim();

        if (nome.isEmpty() || usuarioStr.isEmpty() || senhaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        try {
            Usuario usuario = new Usuario(nome, senhaStr, usuarioStr);
            usuarioRepository.salvar(usuario);

            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
            dispose();
            telaLogin.limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário: " + ex.getMessage());
        }
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
}
