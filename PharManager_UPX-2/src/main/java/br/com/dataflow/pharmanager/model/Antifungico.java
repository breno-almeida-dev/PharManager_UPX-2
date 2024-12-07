package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "antifungico")
public class Antifungico extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String tipoDeFungo;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String localDeAplicacao;
    
    // Construtor padrão
    public Antifungico() {}

    // Construtor com atributos específicos
    public Antifungico(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, String fabricante, 
    		LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao, String tipoDeFungo, String localDeAplicacao) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.tipoDeFungo = tipoDeFungo;
        this.localDeAplicacao = localDeAplicacao;
    }

    // Getters e Setters
    public String getTipoDeFungo() {
        return tipoDeFungo;
    }

    public void setTipoDeFungo(String tipoDeFungo) {
        this.tipoDeFungo = tipoDeFungo;
    }

    public String getLocalDeAplicacao() {
        return localDeAplicacao;
    }

    public void setLocalDeAplicacao(String localDeAplicacao) {
        this.localDeAplicacao = localDeAplicacao;
    }
}
