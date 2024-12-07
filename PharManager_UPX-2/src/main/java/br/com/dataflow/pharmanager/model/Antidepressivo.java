package br.com.dataflow.pharmanager.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "antidepressivo")
public class Antidepressivo extends Medicamento {
	
    @NotNull
    @Size(min = 1, max = 100)
    private String tipo;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String neurotransmissorAfetado;

    // Construtor padrão
    public Antidepressivo() {}

    // Construtor com atributos específicos
    public Antidepressivo(String nome, String categoria, String composicao, int dosagem, String viaDeAdministracao, int quantidade, String fabricante, 
    		LocalDate dataFabricacao, LocalDate dataValidade, String efeitosColaterais, String indicacao, String tipo, String neurotransmissorAfetado) {
        super(nome, categoria, composicao, dosagem, viaDeAdministracao, quantidade, fabricante, dataFabricacao, dataValidade, efeitosColaterais, indicacao);
        this.tipo = tipo;
        this.neurotransmissorAfetado = neurotransmissorAfetado;
    }
    
    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNeurotransmissorAfetado() {
        return neurotransmissorAfetado;
    }

    public void setNeurotransmissorAfetado(String neurotransmissorAfetado) {
        this.neurotransmissorAfetado = neurotransmissorAfetado;
    }
}
