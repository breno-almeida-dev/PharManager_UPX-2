package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Representa um medicamento do tipo anticoagulante, utilizado para prevenir ou tratar condições relacionadas à coagulação sanguínea.
 */
@Entity
@Table(name = "anticoagulante")
public class Anticoagulante extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String tipoDeAcao; // Preventivo ou terapêutico
    
    @NotNull
    @Size(min = 1, max = 100)
    private String condicaoTratada; // Trombose, AVC

    /**
     * Construtor padrão.
     */
    public Anticoagulante() {}

    /**
     * Construtor com atributos específicos do anticoagulante.
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
     * @param tipoDeAcao Tipo de ação do anticoagulante.
     * @param condicaoTratada Condição médica tratada pelo anticoagulante.
     */
    public Anticoagulante(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, 
                          String fabricante, LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao, 
                          String tipoDeAcao, String condicaoTratada) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.tipoDeAcao = tipoDeAcao;
        this.condicaoTratada = condicaoTratada;
    }
    
    /**
     * Obtém o tipo de ação do anticoagulante.
     * 
     * @return O tipo de ação do anticoagulante.
     */
    public String getTipoDeAcao() {
        return tipoDeAcao;
    }

    /**
     * Define o tipo de ação do anticoagulante.
     * 
     * @param tipoDeAcao O novo tipo de ação.
     */
    public void setTipoDeAcao(String tipoDeAcao) {
        this.tipoDeAcao = tipoDeAcao;
    }

    /**
     * Obtém a condição médica tratada pelo anticoagulante.
     * 
     * @return A condição tratada pelo anticoagulante.
     */
    public String getCondicaoTratada() {
        return condicaoTratada;
    }

    /**
     * Define a condição médica tratada pelo anticoagulante.
     * 
     * @param condicaoTratada A nova condição tratada.
     */
    public void setCondicaoTratada(String condicaoTratada) {
        this.condicaoTratada = condicaoTratada;
    }
}
