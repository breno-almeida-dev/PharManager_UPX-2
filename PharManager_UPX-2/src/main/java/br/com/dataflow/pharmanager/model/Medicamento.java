package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Representa um medicamento genérico no sistema.
 * 
 * Esta classe é abstrata e serve como base para subclasses que representam tipos específicos
 * de medicamentos. Contém atributos comuns a todos os medicamentos, como nome, categoria,
 * composição, dosagem, via de administração, e datas de fabricação e validade.
 */
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
    
    /**
     * Construtor padrão.
     */
    public Medicamento() {}

    /**
     * Construtor que inicializa os atributos obrigatórios do medicamento.
     * 
     * @param nome              O nome do medicamento.
     * @param categoria         A categoria do medicamento (e.g., Analgésico, Antibiótico).
     * @param composicao        A composição do medicamento.
     * @param dosagem           A dosagem do medicamento (e.g., mg, mL).
     * @param viaDeAdministracao A via de administração do medicamento (e.g., Oral, Injetável).
     * @param quantidade        A quantidade disponível do medicamento.
     * @param fabricante        O fabricante do medicamento.
     * @param dataFabricacao    A data de fabricação do medicamento.
     * @param dataValidade      A data de validade do medicamento.
     * @param efeitosColaterais Os possíveis efeitos colaterais do medicamento.
     * @param indicacao         A indicação de uso do medicamento.
     */
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

    /**
     * Obtém o ID do medicamento.
     * 
     * @return O ID do medicamento.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do medicamento.
     * 
     * @param id O novo ID do medicamento.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome do medicamento.
     * 
     * @return O nome do medicamento.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do medicamento.
     * 
     * @param nome O novo nome do medicamento.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o fabricante do medicamento.
     * 
     * @return O fabricante do medicamento.
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * Define o fabricante do medicamento.
     * 
     * @param fabricante O novo fabricante do medicamento.
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * Obtém a data de fabricação do medicamento.
     * 
     * @return A data de fabricação do medicamento.
     */
    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    /**
     * Define a data de fabricação do medicamento.
     * 
     * @param dataFabricacao A nova data de fabricação do medicamento.
     */
    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    /**
     * Obtém a data de validade do medicamento.
     * 
     * @return A data de validade do medicamento.
     */
    public LocalDate getDataValidade() {
        return dataValidade;
    }

    /**
     * Define a data de validade do medicamento.
     * 
     * @param dataValidade A nova data de validade do medicamento.
     */
    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    /**
     * Obtém a categoria do medicamento.
     * 
     * @return A categoria do medicamento.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Define a categoria do medicamento.
     * 
     * @param categoria A nova categoria do medicamento.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtém a composição do medicamento.
     * 
     * @return A composição do medicamento.
     */
    public String getComposicao() {
        return composicao;
    }

    /**
     * Define a composição do medicamento.
     * 
     * @param composicao A nova composição do medicamento.
     */
    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    /**
     * Obtém a dosagem do medicamento.
     * 
     * @return A dosagem do medicamento.
     */
    public int getDosagem() {
        return dosagem;
    }

    /**
     * Define a dosagem do medicamento.
     * 
     * @param dosagem A nova dosagem do medicamento.
     */
    public void setDosagem(int dosagem) {
        this.dosagem = dosagem;
    }

    /**
     * Obtém a via de administração do medicamento.
     * 
     * @return A via de administração do medicamento.
     */
    public String getViaDeAdministracao() {
        return viaDeAdministracao;
    }

    /**
     * Define a via de administração do medicamento.
     * 
     * @param viaDeAdministracao A nova via de administração do medicamento.
     */
    public void setViaDeAdministracao(String viaDeAdministracao) {
        this.viaDeAdministracao = viaDeAdministracao;
    }

    /**
     * Obtém os efeitos colaterais do medicamento.
     * 
     * @return Os efeitos colaterais do medicamento.
     */
    public String getEfeitosColaterais() {
        return efeitosColaterais;
    }

    /**
     * Define os efeitos colaterais do medicamento.
     * 
     * @param efeitosColaterais Os novos efeitos colaterais do medicamento.
     */
    public void setEfeitosColaterais(String efeitosColaterais) {
        this.efeitosColaterais = efeitosColaterais;
    }

    /**
     * Obtém a indicação do medicamento.
     * 
     * @return A indicação do medicamento.
     */
    public String getIndicacao() {
        return indicacao;
    }

    /**
     * Define a indicação do medicamento.
     * 
     * @param indicacao A nova indicação do medicamento.
     */
    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }

    /**
     * Obtém a quantidade disponível do medicamento.
     * 
     * @return A quantidade do medicamento.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade disponível do medicamento.
     * 
     * @param quantidade A nova quantidade do medicamento.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}