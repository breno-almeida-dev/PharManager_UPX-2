package br.com.dataflow.pharmanager.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.*;

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

    // Construtores
    public Usuario() {
        this.estado = true; // Estado padrão do usuário é ativo ao ser criado
        this.dataHoraCriacao = LocalDateTime.now(); // Data de criação padrão para agora
    }

    public Usuario(String nome, String senha, String usuario) {
        this();
        this.nome = nome;
        setSenha(senha); // Validação da senha
        this.usuario = usuario;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha == null || senha.length() < 6) {
            throw new IllegalArgumentException("A senha deve ter pelo menos 6 caracteres.");
        }
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        if (usuario == null || usuario.isBlank()) {
            throw new IllegalArgumentException("O usuário não pode ser nulo ou vazio.");
        }
        this.usuario = usuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public LocalDateTime getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(LocalDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
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
}
