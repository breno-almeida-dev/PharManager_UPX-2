package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "antiinflamatorios")
public class AntiInflamatorio extends Medicamento {
    private String tipo;
    private String finalidade;

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }
}
