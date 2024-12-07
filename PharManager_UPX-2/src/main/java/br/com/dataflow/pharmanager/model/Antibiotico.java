package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;

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

    public Antibiotico() {}

    // Construtor com atributos específicos
    public Antibiotico(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, String fabricante, LocalDate dataFabricacao, 
    		LocalDate dataValidade, String efeitosColaterais, String indicacao,String espectroDeAcao, String tipoBacteriaAlvo, String resistenciaBacteriana) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.espectroDeAcao = espectroDeAcao;
        this.tipoBacteriaAlvo = tipoBacteriaAlvo;
        this.resistenciaBacteriana = resistenciaBacteriana;
    }    
    
    // Getters e Setters
    public String getEspectroDeAcao() {
        return espectroDeAcao;
    }

    public void setEspectroDeAcao(String espectroDeAcao) {
        this.espectroDeAcao = espectroDeAcao;
    }

    public String getTipoBacteriaAlvo() {
        return tipoBacteriaAlvo;
    }

    public void setTipoBacteriaAlvo(String tipoBacteriaAlvo) {
        this.tipoBacteriaAlvo = tipoBacteriaAlvo;
    }

    public String getResistenciaBacteriana() {
        return resistenciaBacteriana;
    }

    public void setResistenciaBacteriana(String resistenciaBacteriana) {
        this.resistenciaBacteriana = resistenciaBacteriana;
    }
}
