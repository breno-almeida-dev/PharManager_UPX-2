package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Representa um medicamento do tipo vacina, utilizado para prevenir doenças específicas.
 */
@Entity
@Table(name = "vacina")
public class Vacina extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String tipoDeVacina;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String doencaAlvo;
    
    /**
     * Construtor padrão.
     */
    public Vacina() {}

    /**
     * Construtor com atributos específicos da vacina.
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
     * @param tipoDeVacina Tipo da vacina.
     * @param doencaAlvo Doença-alvo da vacina.
     */
    public Vacina(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, String fabricante, 
    		LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao, String tipoDeVacina, String doencaAlvo) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.tipoDeVacina = tipoDeVacina;
        this.doencaAlvo = doencaAlvo;
    }

    /**
     * Obtém o tipo da vacina.
     * 
     * @return O tipo da vacina.
     */
    public String getTipoDeVacina() {
        return tipoDeVacina;
    }

    /**
     * Define o tipo da vacina.
     * 
     * @param tipoDeVacina O novo tipo da vacina.
     */
    public void setTipoDeVacina(String tipoDeVacina) {
        this.tipoDeVacina = tipoDeVacina;
    }

    /**
     * Obtém a doença-alvo da vacina.
     * 
     * @return A doença-alvo da vacina.
     */
    public String getDoencaAlvo() {
        return doencaAlvo;
    }

    /**
     * Define a doença-alvo da vacina.
     * 
     * @param doencaAlvo A nova doença-alvo da vacina.
     */
    public void setDoencaAlvo(String doencaAlvo) {
        this.doencaAlvo = doencaAlvo;
    }
}
