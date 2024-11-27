package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "antidepressivos")
public class Antidepressivo extends Medicamento {
    private String tipo;
    private String neurotransmissorAfetado;

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
