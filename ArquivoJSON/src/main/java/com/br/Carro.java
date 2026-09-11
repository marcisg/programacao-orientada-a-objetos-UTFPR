package com.br;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Carro {
    private String marca;
    private String modelo;
    private int ano;

    @JsonProperty("cor_veiculo")
    private String cor;

    public Carro() {}

    public Carro(String marca, String modelo, int ano, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Carro: ");
        sb.append("marca = ").append(marca).append(" ,");
        sb.append("modelo = ").append(modelo).append(" ,");
        sb.append("ano = ").append(ano).append(" ,");
        sb.append("cor = ").append(cor);
        return sb.toString();
    }
}
