package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "diureticos")
public class Diuretico extends Medicamento {
    private String tipo;
    private String condicaoTratada;

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCondicaoTratada() {
        return condicaoTratada;
    }

    public void setCondicaoTratada(String condicaoTratada) {
        this.condicaoTratada = condicaoTratada;
    }
}
