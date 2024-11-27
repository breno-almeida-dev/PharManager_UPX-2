package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "antivirais")
public class Antiviral extends Medicamento {
    private String tipoDeVirus;
    private String mecanismoDeAcao;

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
