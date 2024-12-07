package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "antiviral")
public class Antiviral extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String tipoDeVirus;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String mecanismoDeAcao;
    
    // Construtor padrão
    public Antiviral() {}

    // Construtor com atributos específicos
    public Antiviral(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, String fabricante, 
    		LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao, String tipoDeVirus, String mecanismoDeAcao) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.tipoDeVirus = tipoDeVirus;
        this.mecanismoDeAcao = mecanismoDeAcao;
    }

    // Getters e Setters
    public String getTipoDeVirus() {
        return tipoDeVirus;
    }

    public void setTipoDeVirus(String tipoDeVirus) {
        this.tipoDeVirus = tipoDeVirus;
    }

    public String getMecanismoDeAcao() {
        return mecanismoDeAcao;
    }

    public void setMecanismoDeAcao(String mecanismoDeAcao) {
        this.mecanismoDeAcao = mecanismoDeAcao;
    }
}
