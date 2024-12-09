package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Representa um medicamento do tipo antiviral, utilizado para tratar infecções virais.
 */
@Entity
@Table(name = "antiviral")
public class Antiviral extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String tipoDeVirus;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String mecanismoDeAcao;
    
    /**
     * Construtor padrão.
     */
    public Antiviral() {}

    /**
     * Construtor com atributos específicos do antiviral.
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
     * @param tipoDeVirus Tipo de vírus que o medicamento combate.
     * @param mecanismoDeAcao Mecanismo de ação do antiviral.
     */
    public Antiviral(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, String fabricante, 
    		LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao, String tipoDeVirus, String mecanismoDeAcao) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.tipoDeVirus = tipoDeVirus;
        this.mecanismoDeAcao = mecanismoDeAcao;
    }

    /**
     * Obtém o tipo de vírus que o antiviral combate.
     * 
     * @return O tipo de vírus.
     */
    public String getTipoDeVirus() {
        return tipoDeVirus;
    }

    /**
     * Define o tipo de vírus que o antiviral combate.
     * 
     * @param tipoDeVirus O novo tipo de vírus.
     */
    public void setTipoDeVirus(String tipoDeVirus) {
        this.tipoDeVirus = tipoDeVirus;
    }

    /**
     * Obtém o mecanismo de ação do antiviral.
     * 
     * @return O mecanismo de ação.
     */
    public String getMecanismoDeAcao() {
        return mecanismoDeAcao;
    }

    /**
     * Define o mecanismo de ação do antiviral.
     * 
     * @param mecanismoDeAcao O novo mecanismo de ação.
     */
    public void setMecanismoDeAcao(String mecanismoDeAcao) {
        this.mecanismoDeAcao = mecanismoDeAcao;
    }
}
