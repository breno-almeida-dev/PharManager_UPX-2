package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "antifungicos")
public class Antifungico extends Medicamento {
    private String tipoDeFungo;
    private String localDeAplicacao;

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
