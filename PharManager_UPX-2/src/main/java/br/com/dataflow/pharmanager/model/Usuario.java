package br.com.dataflow.pharmanager.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Representa um usuário do sistema.
 * 
 * Contém informações como nome, usuário, senha, estado (ativo/inativo),
 * e datas de criação e último login.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 100)
    private String nome;

    @NotNull
    @Size(min = 1, max = 100)
    private String senha;

    @NotNull
    @Size(min = 1, max = 100)
    private String usuario;

    private boolean estado;

    private LocalDateTime dataHoraCriacao;

    private LocalDateTime ultimoLogin;

    /**
     * Construtor padrão.
     * 
     * Inicializa o estado do usuário como ativo e a data de criação como a data e hora atuais.
     */
    public Usuario() {
        this.estado = true; // Estado padrão do usuário é ativo ao ser criado
        this.dataHoraCriacao = LocalDateTime.now(); // Data de criação padrão para agora
    }

    /**
     * Construtor que inicializa os atributos obrigatórios do usuário.
     * 
     * @param nome    O nome do usuário.
     * @param senha   A senha do usuário (mínimo de 6 caracteres).
     * @param usuario O nome de usuário para login.
     */
    public Usuario(String nome, String senha, String usuario) {
        this();
        this.nome = nome;
        setSenha(senha); // Validação da senha
        this.usuario = usuario;
    }
    
    /**
     * Atualiza a data do último login para a data e hora atuais.
     */
    public void atualizarUltimoLogin() {
        this.ultimoLogin = LocalDateTime.now();
    }

    /**
     * Método para desativar um usuário.
     */
    public void desativarUsuario() {
        this.estado = false;
    }


    /**
     * Obtém o ID do usuário.
     * 
     * @return O ID do usuário.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do usuário.
     * 
     * @param id O novo ID do usuário.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do usuário.
     * 
     * @return O nome do usuário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     * 
     * @param nome O novo nome do usuário.
     */
    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    /**
     * Obtém a senha do usuário.
     * 
     * @return A senha do usuário.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     * 
     * @param senha A nova senha do usuário (mínimo de 6 caracteres).
     */
    public void setSenha(String senha) {
        if (senha == null || senha.length() < 6) {
            throw new IllegalArgumentException("A senha deve ter pelo menos 6 caracteres.");
        }
        this.senha = senha;
    }

    /**
     * Obtém o nome de usuário.
     * 
     * @return O nome de usuário.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define o nome de usuário.
     * 
     * @param usuario O novo nome de usuário.
     */
    public void setUsuario(String usuario) {
        if (usuario == null || usuario.isBlank()) {
            throw new IllegalArgumentException("O usuário não pode ser nulo ou vazio.");
        }
        this.usuario = usuario;
    }

    /**
     * Obtém o estado do usuário (ativo/inativo).
     * 
     * @return {@code true} se o usuário estiver ativo, caso contrário {@code false}.
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Define o estado do usuário.
     * 
     * @param estado O novo estado do usuário.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Obtém a data e hora de criação do usuário.
     * 
     * @return A data e hora de criação do usuário.
     */
    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    /**
     * Define a data e hora de criação do usuário.
     * 
     * @param dataHoraCriacao A nova data e hora de criação do usuário.
     */
    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    /**
     * Obtém a data e hora do último login do usuário.
     * 
     * @return A data e hora do último login.
     */
    public LocalDateTime getUltimoLogin() {
        return ultimoLogin;
    }

    /**
     * Define a data e hora do último login do usuário.
     * 
     * @param ultimoLogin A nova data e hora do último login.
     */
    public void setUltimoLogin(LocalDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

}
