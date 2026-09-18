package com.br;

public class Pessoa {
    private String nome;
    private int idade;
    private double salario;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa(String nome, int idade, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome)
                .append(" Idade: ").append(getIdade())
                .append(" Salário: ").append(getSalario()).append("\n");
        return sb.toString();
    }
}
