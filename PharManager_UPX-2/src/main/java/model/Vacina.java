package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vacinas")
public class Vacina extends Medicamento {
    private String tipoDeVacina;
    private String doencaAlvo;

    // Getters e Setters
    public String getTipoDeVacina() {
        return tipoDeVacina;
    }

    public void setTipoDeVacina(String tipoDeVacina) {
        this.tipoDeVacina = tipoDeVacina;
    }

    public String getDoencaAlvo() {
        return doencaAlvo;
    }

    public void setDoencaAlvo(String doencaAlvo) {
        this.doencaAlvo = doencaAlvo;
    }
}
