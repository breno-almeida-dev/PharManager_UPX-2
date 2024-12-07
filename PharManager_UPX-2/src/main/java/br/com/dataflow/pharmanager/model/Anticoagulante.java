package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "anticoagulante")
public class Anticoagulante extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String tipoDeAcao; // Preventivo ou terapêutico
    
    @NotNull
    @Size(min = 1, max = 100)
    private String condicaoTratada; // Trombose, AVC

    // Construtor padrão
    public Anticoagulante() {}

    // Construtor com atributos específicos
    public Anticoagulante(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, String fabricante, 
    		LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao, String tipoDeAcao, String condicaoTratada) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.tipoDeAcao = tipoDeAcao;
        this.condicaoTratada = condicaoTratada;
    }
    
    // Getters e Setters
    public String getTipoDeAcao() {
        return tipoDeAcao;
    }

    public void setTipoDeAcao(String tipoDeAcao) {
        this.tipoDeAcao = tipoDeAcao;
    }

    public String getCondicaoTratada() {
        return condicaoTratada;
    }

    public void setCondicaoTratada(String condicaoTratada) {
        this.condicaoTratada = condicaoTratada;
    }
}
