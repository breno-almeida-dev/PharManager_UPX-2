package br.com.dataflow.pharmanager;

import javax.swing.SwingUtilities;
import br.com.dataflow.pharmanager.view.TelaLogin;

/**
 * Classe principal que inicializa a aplicação do gerenciador de estoque PharManager.
 * Responsável por criar a instância da tela de login e iniciar a interface.
 * 
 * A aplicação segue o fluxo:
 * - Tela de login.
 * - Acesso às funcionalidades após autenticação bem-sucedida. 
 * 
 * @author Breno Almeida
 * @author Edson Veiga
 * @author Matheus Leone
 * @author Lucas Yoshida
 * @version 1.0
 */
public class Pharmanager {

    /**
     * Método principal para inicializar o sistema PharManager.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        // Inicia a aplicação na tela de login
        SwingUtilities.invokeLater(() -> {
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
        });
    }
}