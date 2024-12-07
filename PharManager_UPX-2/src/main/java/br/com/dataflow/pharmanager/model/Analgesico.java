package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "analgesico")
public class Analgesico extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String tipoDor;

    @NotNull
    @Size(min = 1, max = 100)
    private String atuacao;
    
    // Construtor padrão
    public Analgesico() {}

    // Construtor com atributos específicos
    public Analgesico(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, 
    		String fabricante, LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao, String tipoDor, String atuacao) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.tipoDor = tipoDor;
        this.atuacao = atuacao;
    }

    // Getters e Setters
    public String getTipoDor() {
        return tipoDor;
    }

    public void setTipoDor(String tipoDor) {
        this.tipoDor = tipoDor;
    }

    public String getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(String atuacao) {
        this.atuacao = atuacao;
    }
}