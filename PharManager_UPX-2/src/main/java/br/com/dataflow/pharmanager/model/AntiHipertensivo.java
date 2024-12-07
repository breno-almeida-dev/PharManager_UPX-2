package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "antihipertensivo")
public class AntiHipertensivo extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String mecanismoDeAcao;
    
    // Construtor padrão
    public AntiHipertensivo() {}

    // Construtor com atributos específicos
    public AntiHipertensivo(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, 
    		String fabricante, LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao, String mecanismoDeAcao) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.mecanismoDeAcao = mecanismoDeAcao;
    }

    // Getters e Setters
    public String getMecanismoDeAcao() {
        return mecanismoDeAcao;
    }

    public void setMecanismoDeAcao(String mecanismoDeAcao) {
        this.mecanismoDeAcao = mecanismoDeAcao;
    }
}
