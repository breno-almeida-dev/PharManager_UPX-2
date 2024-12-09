package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Representa um medicamento do tipo anti-inflamatório, utilizado para reduzir inflamações no organismo.
 */
@Entity
@Table(name = "antiinflamatorio")
public class AntiInflamatorio extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String tipo;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String finalidade;
    
    /**
     * Construtor padrão.
     */
    public AntiInflamatorio() {}

    /**
     * Construtor com atributos específicos do anti-inflamatório.
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
     * @param tipo Tipo de anti-inflamatório.
     * @param finalidade Finalidade do anti-inflamatório.
     */
    public AntiInflamatorio(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, String fabricante, 
    		LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao, String tipo, String finalidade) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.tipo = tipo;
        this.finalidade = finalidade;
    }

    /**
     * Obtém o tipo de anti-inflamatório.
     * 
     * @return O tipo de anti-inflamatório.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo de anti-inflamatório.
     * 
     * @param tipo O novo tipo de anti-inflamatório.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtém a finalidade do anti-inflamatório.
     * 
     * @return A finalidade do anti-inflamatório.
     */
    public String getFinalidade() {
        return finalidade;
    }

    /**
     * Define a finalidade do anti-inflamatório.
     * 
     * @param finalidade A nova finalidade do anti-inflamatório.
     */
    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }
}
