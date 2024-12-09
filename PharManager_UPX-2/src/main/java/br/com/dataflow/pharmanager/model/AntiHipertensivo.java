package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Representa um medicamento do tipo anti-hipertensivo, utilizado para tratar hipertensão arterial.
 */
@Entity
@Table(name = "antihipertensivo")
public class AntiHipertensivo extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String mecanismoDeAcao;
    
    /**
     * Construtor padrão.
     */
    public AntiHipertensivo() {}

    /**
     * Construtor com atributos específicos do anti-hipertensivo.
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
     * @param mecanismoDeAcao Mecanismo de ação do medicamento.
     */
    public AntiHipertensivo(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, 
    		String fabricante, LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao, String mecanismoDeAcao) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.mecanismoDeAcao = mecanismoDeAcao;
    }

    /**
     * Obtém o mecanismo de ação do anti-hipertensivo.
     * 
     * @return O mecanismo de ação.
     */
    public String getMecanismoDeAcao() {
        return mecanismoDeAcao;
    }

    /**
     * Define o mecanismo de ação do anti-hipertensivo.
     * 
     * @param mecanismoDeAcao O novo mecanismo de ação.
     */
    public void setMecanismoDeAcao(String mecanismoDeAcao) {
        this.mecanismoDeAcao = mecanismoDeAcao;
    }
}
