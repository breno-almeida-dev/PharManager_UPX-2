package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Representa um medicamento do tipo antidepressivo, utilizado para tratar transtornos depressivos e outros relacionados.
 */
@Entity
@Table(name = "antidepressivo")
public class Antidepressivo extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String tipo;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String neurotransmissorAfetado;

    /**
     * Construtor padrão.
     */
    public Antidepressivo() {}

    /**
     * Construtor com atributos específicos do antidepressivo.
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
     * @param tipo Tipo de antidepressivo.
     * @param neurotransmissorAfetado Neurotransmissor afetado pelo antidepressivo.
     */
    public Antidepressivo(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, 
                          String fabricante, LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao, 
                          String tipo, String neurotransmissorAfetado) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.tipo = tipo;
        this.neurotransmissorAfetado = neurotransmissorAfetado;
    }
    
    /**
     * Obtém o tipo de antidepressivo.
     * 
     * @return O tipo de antidepressivo.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo de antidepressivo.
     * 
     * @param tipo O novo tipo de antidepressivo.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtém o neurotransmissor afetado pelo antidepressivo.
     * 
     * @return O neurotransmissor afetado.
     */
    public String getNeurotransmissorAfetado() {
        return neurotransmissorAfetado;
    }

    /**
     * Define o neurotransmissor afetado pelo antidepressivo.
     * 
     * @param neurotransmissorAfetado O novo neurotransmissor afetado.
     */
    public void setNeurotransmissorAfetado(String neurotransmissorAfetado) {
        this.neurotransmissorAfetado = neurotransmissorAfetado;
    }
}
