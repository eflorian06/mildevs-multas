package br.com.mesttra.entity;

import jakarta.persistence.*;

@Entity
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_multa")
    private int codigoMulta;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private int pontuacao;

    @ManyToOne
    @JoinColumn(name = "veiculo_placa", referencedColumnName = "placa")
    private Veiculo veiculo;

    @Override
    public String toString() {
        return
                "\nCódigo da multa = " + getCodigoMulta() +
                ", \nValor = R$ " + getValor() +
                ", \nPontos = " + getPontuacao() +
                ", \nVeículo = " + veiculo.getPlaca();
    }

    public int getCodigoMulta() {
        return codigoMulta;
    }

    public void setCodigoMulta(int codigoMulta) {
        this.codigoMulta = codigoMulta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }


}
