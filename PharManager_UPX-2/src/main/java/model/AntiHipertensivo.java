package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "antihipertensivos")
public class AntiHipertensivo extends Medicamento {
    private String mecanismoDeAcao;

    // Getters e Setters
    public String getMecanismoDeAcao() {
        return mecanismoDeAcao;
    }

    public void setMecanismoDeAcao(String mecanismoDeAcao) {
        this.mecanismoDeAcao = mecanismoDeAcao;
    }
}
