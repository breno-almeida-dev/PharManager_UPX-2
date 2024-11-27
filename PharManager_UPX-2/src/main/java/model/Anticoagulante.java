package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "anticoagulantes")
public class Anticoagulante extends Medicamento {
    private String tipoDeAcao; // Preventivo ou terapêutico
    private String condicaoTratada; // Trombose, AVC

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
