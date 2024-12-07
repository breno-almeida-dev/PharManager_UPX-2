package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vacina")
public class Vacina extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String tipoDeVacina;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String doencaAlvo;
    
    // Construtor padrão
    public Vacina() {}

    // Construtor com atributos específicos
    public Vacina(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, String fabricante, 
    		LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao, String tipoDeVacina, String doencaAlvo) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.tipoDeVacina = tipoDeVacina;
        this.doencaAlvo = doencaAlvo;
    }

    // Getters e Setters
    public String getTipoDeVacina() {
        return tipoDeVacina;
    }

    public void setTipoDeVacina(String tipoDeVacina) {
        this.tipoDeVacina = tipoDeVacina;
    }

    public String getDoencaAlvo() {
        return doencaAlvo;
    }

    public void setDoencaAlvo(String doencaAlvo) {
        this.doencaAlvo = doencaAlvo;
    }
}
