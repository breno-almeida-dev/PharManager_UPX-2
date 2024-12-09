package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Representa um medicamento do tipo diurético, utilizado para tratar condições relacionadas ao excesso de fluidos no corpo.
 */
@Entity
@Table(name = "diuretico")
public class Diuretico extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String tipo;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String condicaoTratada;
    
    /**
     * Construtor padrão.
     */
    public Diuretico() {}

    /**
     * Construtor com atributos específicos do diurético.
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
     * @param tipo Tipo de diurético.
     * @param condicaoTratada Condição tratada pelo diurético.
     */
    public Diuretico(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, String fabricante, 
    		LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao, String tipo, String condicaoTratada) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.tipo = tipo;
        this.condicaoTratada = condicaoTratada;
    }

    /**
     * Obtém o tipo de diurético.
     * 
     * @return O tipo de diurético.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo de diurético.
     * 
     * @param tipo O novo tipo de diurético.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtém a condição tratada pelo diurético.
     * 
     * @return A condição tratada pelo diurético.
     */
    public String getCondicaoTratada() {
        return condicaoTratada;
    }

    /**
     * Define a condição tratada pelo diurético.
     * 
     * @param condicaoTratada A nova condição tratada pelo diurético.
     */
    public void setCondicaoTratada(String condicaoTratada) {
        this.condicaoTratada = condicaoTratada;
    }
}
