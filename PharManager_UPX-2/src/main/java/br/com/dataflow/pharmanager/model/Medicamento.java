package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "medicamento")
public abstract class Medicamento {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String nome;
    
    @Column(nullable = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String categoria; // Analgésico, Antibiótico, Anti-inflamatório, etc.
    
    @NotNull
    @Size(min = 1, max = 100)
    private String composicao; // Principais substâncias químicas.

    @Column(nullable = false)
    @Min(1)
    private int dosagem; // Quantidade por unidade (mg, mL, etc.).
    
    @Column(nullable = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String viaDeAdministracao; // Oral, injetável, tópica, etc.
    
    @Column(nullable = false)
    @NotNull
    @Min(1)
    private int quantidade;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String fabricante;   
    
    @Column(nullable = false)
    @NotNull
    private LocalDate dataFabricacao;
    
    @Column(nullable = false)
    @NotNull
    private LocalDate dataValidade;

    @NotNull
    @Size(min = 1, max = 100)
    private String efeitosColaterais; // Possíveis reações adversas.

    private String indicacao; // Doenças ou condições tratadas.
    
    // Construtor padrão
    public Medicamento() {}

    // Construtor com atributos obrigatórios
    public Medicamento(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, 
    		int quantidade, String fabricante, LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao) {
        this.nome = nome;
        this.categoria = categoria;
        this.composicao = composicao;
        this.dosagem = dosagem;
        this.viaDeAdministracao = viaDeAdministracao;
        this.quantidade = quantidade;
        this.fabricante = fabricante;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.efeitosColaterais = efeitosColaterais;
        this.indicacao = indicacao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }
    
    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getComposicao() {
        return composicao;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    public int getDosagem() {
        return dosagem;
    }

    public void setDosagem(int dosagem) {
        this.dosagem = dosagem;
    }

    public String getViaDeAdministracao() {
        return viaDeAdministracao;
    }

    public void setViaDeAdministracao(String viaDeAdministracao) {
        this.viaDeAdministracao = viaDeAdministracao;
    }

    public String getEfeitosColaterais() {
        return efeitosColaterais;
    }

    public void setEfeitosColaterais(String efeitosColaterais) {
        this.efeitosColaterais = efeitosColaterais;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }    
}