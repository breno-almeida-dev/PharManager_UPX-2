package model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String senha;
    private String usuario;
    private boolean estado;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime ultimoLogin;
    

    // Construtores
    public Usuario() {
    	this.estado = true;
    }

    public Usuario(int id, String nome, String senha, String usuario, boolean estado, LocalDateTime dataHoraCriacao, LocalDateTime ultimoLogin) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.usuario = usuario;
        this.estado = estado;
        this.dataHoraCriacao = dataHoraCriacao;
        this.ultimoLogin = ultimoLogin;        
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
    	this.nome = nome;
    }
    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    public boolean getEstado() {
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
}
