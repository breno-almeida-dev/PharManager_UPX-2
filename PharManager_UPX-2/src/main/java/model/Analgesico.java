package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "analgesicos")
public class Analgesico extends Medicamento {
    private String tipoDor;
    private String atuacao;

    // Getters e Setters
    public String getTipoDor() {
        return tipoDor;
    }

    public void setTipoDor(String tipoDor) {
        this.tipoDor = tipoDor;
    }

    public String getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(String atuacao) {
        this.atuacao = atuacao;
    }
}