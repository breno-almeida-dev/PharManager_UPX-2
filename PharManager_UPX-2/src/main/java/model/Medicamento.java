package model;

import java.time.LocalDate;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String fabricante;
    private LocalDate dataValidade;

    protected String categoria; // Analgésico, Antibiótico, Anti-inflamatório, etc.
    
    @ElementCollection
    protected List<String> composicao; // Principais substâncias químicas.

    protected int dosagem; // Quantidade por unidade (mg, mL, etc.).
    protected String viaDeAdministracao; // Oral, injetável, tópica, etc.

    @ElementCollection
    protected List<String> efeitosColaterais; // Possíveis reações adversas.

    protected String indicacao; // Doenças ou condições tratadas.

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<String> getComposicao() {
        return composicao;
    }

    public void setComposicao(List<String> composicao) {
        this.composicao = composicao;
    }

    public int getDosagem() {
        return dosagem;
    }

    public void setDosagem(int dosagem) {
        this.dosagem = dosagem;
    }

    public String getViaDeAdministracao() {
        return viaDeAdministracao;
    }

    public void setViaDeAdministracao(String viaDeAdministracao) {
        this.viaDeAdministracao = viaDeAdministracao;
    }

    public List<String> getEfeitosColaterais() {
        return efeitosColaterais;
    }

    public void setEfeitosColaterais(List<String> efeitosColaterais) {
        this.efeitosColaterais = efeitosColaterais;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }
}

