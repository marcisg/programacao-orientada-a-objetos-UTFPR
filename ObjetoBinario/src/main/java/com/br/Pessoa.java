package com.br;

import java.io.Serializable;

public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private int idade;
    private transient String senha;

    public Pessoa(String nome, int idade, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.idade + " anos - Senha [TRANSIENT] \n";
    }
}
