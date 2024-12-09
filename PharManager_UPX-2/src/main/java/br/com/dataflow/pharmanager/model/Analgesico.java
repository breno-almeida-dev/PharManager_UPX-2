package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Representa um medicamento do tipo analgésico, utilizado para tratar diferentes tipos de dores.
 */
@Entity
@Table(name = "analgesico")
public class Analgesico extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String tipoDor;

    @NotNull
    @Size(min = 1, max = 100)
    private String atuacao;

    /**
     * Construtor padrão.
     */
    public Analgesico() {}

    /**
     * Construtor com atributos específicos do analgésico.
     *
     * @param nome Nome do medicamento.
     * @param categoria Categoria do medicamento.
     * @param composicao Composição química do medicamento.
     * @param dosagem Dosagem por unidade.
     * @param viaDeAdministracao Via de administração do medicamento.
     * @param quantidade Quantidade disponível em estoque.
     * @param fabricante Fabricante do medicamento.
     * @param dataFabricacao Data de fabricação do medicamento.
     * @param dataValidade Data de validade do medicamento.
     * @param efeitosColaterais Possíveis efeitos colaterais do medicamento.
     * @param indicacao Indicação do medicamento.
     * @param tipoDor Tipo de dor tratado pelo analgésico.
     * @param atuacao Modo de atuação do analgésico.
     */
    public Analgesico(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, 
    		String fabricante, LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao, String tipoDor, String atuacao) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.tipoDor = tipoDor;
        this.atuacao = atuacao;
    }

    /**
     * Obtém o tipo de dor tratado pelo analgésico.
     * 
     * @return O tipo de dor tratado.
     */
    public String getTipoDor() {
        return tipoDor;
    }

    /**
     * Define o tipo de dor tratado pelo analgésico.
     * 
     * @param tipoDor O novo tipo de dor.
     */
    public void setTipoDor(String tipoDor) {
        this.tipoDor = tipoDor;
    }

    /**
     * Obtém o modo de atuação do analgésico.
     * 
     * @return O modo de atuação do analgésico.
     */
    public String getAtuacao() {
        return atuacao;
    }

    /**
     * Define o modo de atuação do analgésico.
     * 
     * @param atuacao O novo modo de atuação.
     */
    public void setAtuacao(String atuacao) {
        this.atuacao = atuacao;
    }
}