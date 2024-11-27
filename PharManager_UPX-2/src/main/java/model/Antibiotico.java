package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "antibioticos")
public class Antibiotico extends Medicamento {
    private String espectroDeAcao; // Amplo ou estreito
    private String tipoBacteriaAlvo; // Gram-positiva ou Gram-negativa
    private String resistenciaBacteriana; // Sensível ou resistente

    // Getters e Setters
    public String getEspectroDeAcao() {
        return espectroDeAcao;
    }

    public void setEspectroDeAcao(String espectroDeAcao) {
        this.espectroDeAcao = espectroDeAcao;
    }

    public String getTipoBacteriaAlvo() {
        return tipoBacteriaAlvo;
    }

    public void setTipoBacteriaAlvo(String tipoBacteriaAlvo) {
        this.tipoBacteriaAlvo = tipoBacteriaAlvo;
    }

    public String getResistenciaBacteriana() {
        return resistenciaBacteriana;
    }

    public void setResistenciaBacteriana(String resistenciaBacteriana) {
        this.resistenciaBacteriana = resistenciaBacteriana;
    }
}
