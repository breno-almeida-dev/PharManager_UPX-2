package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Representa um medicamento do tipo antibiótico, utilizado para tratar infecções bacterianas.
 */
@Entity
@Table(name = "antibiotico")
public class Antibiotico extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String espectroDeAcao; // Amplo ou estreito
    
    @NotNull
    @Size(min = 1, max = 100)
    private String tipoBacteriaAlvo; // Gram-positiva ou Gram-negativa
    
    @NotNull
    @Size(min = 1, max = 100)
    private String resistenciaBacteriana; // Sensível ou resistente

    /**
     * Construtor padrão.
     */
    public Antibiotico() {}

    /**
     * Construtor com atributos específicos do antibiótico.
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
     * @param espectroDeAcao Espectro de ação do antibiótico.
     * @param tipoBacteriaAlvo Tipo de bactéria alvo do antibiótico.
     * @param resistenciaBacteriana Resistência bacteriana ao antibiótico.
     */
    public Antibiotico(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, 
                       String fabricante, LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao,
                       String espectroDeAcao, String tipoBacteriaAlvo, String resistenciaBacteriana) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.espectroDeAcao = espectroDeAcao;
        this.tipoBacteriaAlvo = tipoBacteriaAlvo;
        this.resistenciaBacteriana = resistenciaBacteriana;
    }   
    
    /**
     * Obtém o espectro de ação do antibiótico.
     * 
     * @return O espectro de ação do antibiótico.
     */
    public String getEspectroDeAcao() {
        return espectroDeAcao;
    }

    /**
     * Define o espectro de ação do antibiótico.
     * 
     * @param espectroDeAcao O novo espectro de ação.
     */
    public void setEspectroDeAcao(String espectroDeAcao) {
        this.espectroDeAcao = espectroDeAcao;
    }

    /**
     * Obtém o tipo de bactéria alvo do antibiótico.
     * 
     * @return O tipo de bactéria alvo.
     */
    public String getTipoBacteriaAlvo() {
        return tipoBacteriaAlvo;
    }

    /**
     * Define o tipo de bactéria alvo do antibiótico.
     * 
     * @param tipoBacteriaAlvo O novo tipo de bactéria alvo.
     */
    public void setTipoBacteriaAlvo(String tipoBacteriaAlvo) {
        this.tipoBacteriaAlvo = tipoBacteriaAlvo;
    }

    /**
     * Obtém a resistência bacteriana ao antibiótico.
     * 
     * @return A resistência bacteriana.
     */
    public String getResistenciaBacteriana() {
        return resistenciaBacteriana;
    }

    /**
     * Define a resistência bacteriana ao antibiótico.
     * 
     * @param resistenciaBacteriana A nova resistência bacteriana.
     */
    public void setResistenciaBacteriana(String resistenciaBacteriana) {
        this.resistenciaBacteriana = resistenciaBacteriana;
    }
}
