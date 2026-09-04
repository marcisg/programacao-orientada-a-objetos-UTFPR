package com.br;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Fran", 45, "12345");
        Pessoa pessoa2 = new Pessoa("Joana", 54, "12345");
        Pessoa pessoa3 = new Pessoa("Solange", 23, "12345");
        Pessoa pessoa4 = new Pessoa("Afonso", 34, "12345");

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
        pessoas.add(pessoa4);

        //System.out.println(pessoas.toString());

        String arqPessoas = "ListaDePessoas.bin";

        try (FileOutputStream fos = new FileOutputStream(arqPessoas);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)){

            //Grava a lista de objetos
            oos.writeObject(pessoas);

        } catch (IOException ec) {
            System.out.println("Erro ao grava os objetos: " + ec.getMessage());
        }

        File filePes = new File(arqPessoas);
        if(filePes.exists()){

            try (FileInputStream fis = new FileInputStream(arqPessoas);
                 BufferedInputStream bis = new BufferedInputStream(fis);
                 ObjectInputStream ois = new ObjectInputStream(bis)){

                List<Pessoa> listaDePessoasDoArquivo = new ArrayList<>();
                listaDePessoasDoArquivo = (List<Pessoa>) ois.readObject();

                System.out.println("Lista de Pessoas do Arquivo");
                System.out.println(listaDePessoasDoArquivo.toString());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("Arquivo " + arqPessoas + " não encontrado!");
        }

    }
}
