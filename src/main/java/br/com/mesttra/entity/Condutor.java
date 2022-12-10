package br.com.mesttra.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Condutor {

    @Id
    private int nroCnh;

    @Column(nullable = false)
    private String dataEmissao;

    @Column(nullable = false)
    private String orgaoEmissor;
    @Column(nullable = false)
    private int pontuacao = 0;

    @OneToMany(mappedBy = "condutor")
    private List<Veiculo> carros;

    public int getNroCnh() {
        return nroCnh;
    }

    public void setNroCnh(int nroCnh) {
        this.nroCnh = nroCnh;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public List<Veiculo> getCarros() {
        return carros;
    }

    public void setCarros(List<Veiculo> carros) {
        this.carros = carros;
    }

    public Condutor() {
    }
    @Override
    public String toString() {
        return "Condutor [Numero da CNH= " + getNroCnh() + ", orgaoEmissor= " + getOrgaoEmissor() + ", dataEmissao= " + getDataEmissao()
                + ", pontuacao= " + getPontuacao() + "]";
    }

}
