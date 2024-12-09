package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Representa um medicamento do tipo antifúngico, utilizado para tratar infecções causadas por fungos.
 */
@Entity
@Table(name = "antifungico")
public class Antifungico extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String tipoDeFungo;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String localDeAplicacao;
    
    /**
     * Construtor padrão.
     */
    public Antifungico() {}

    /**
     * Construtor com atributos específicos do antifúngico.
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
     * @param tipoDeFungo Tipo de fungo que o medicamento combate.
     * @param localDeAplicacao Local de aplicação do medicamento.
     */
    public Antifungico(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, String fabricante, 
    		LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao, String tipoDeFungo, String localDeAplicacao) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.tipoDeFungo = tipoDeFungo;
        this.localDeAplicacao = localDeAplicacao;
    }

    /**
     * Obtém o tipo de fungo que o antifúngico combate.
     * 
     * @return O tipo de fungo.
     */
    public String getTipoDeFungo() {
        return tipoDeFungo;
    }

    /**
     * Define o tipo de fungo que o antifúngico combate.
     * 
     * @param tipoDeFungo O novo tipo de fungo.
     */
    public void setTipoDeFungo(String tipoDeFungo) {
        this.tipoDeFungo = tipoDeFungo;
    }

    /**
     * Obtém o local de aplicação do antifúngico.
     * 
     * @return O local de aplicação.
     */
    public String getLocalDeAplicacao() {
        return localDeAplicacao;
    }

    /**
     * Define o local de aplicação do antifúngico.
     * 
     * @param localDeAplicacao O novo local de aplicação.
     */
    public void setLocalDeAplicacao(String localDeAplicacao) {
        this.localDeAplicacao = localDeAplicacao;
    }
}
