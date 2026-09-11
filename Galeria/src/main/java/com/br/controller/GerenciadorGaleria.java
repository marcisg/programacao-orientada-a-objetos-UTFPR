package com.br.controller;

import com.br.model.ObraDeArte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GerenciadorGaleria {

    private static final String ARQUIVO = "obra.dat";

    public static void salvarObra(ObraDeArte obra) {
        if (obra == null) {
            System.out.println("Nada para salvar: a obra está nula.");
            return;
        }

        try (FileOutputStream fos = new FileOutputStream(ARQUIVO);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(obra);
            System.out.println("Obra salva no arquivo " + ARQUIVO);

        } catch (IOException e) {
            System.out.println("Erro ao salvar a obra: " + e.getMessage());
        }
    }

    public static ObraDeArte carregarObra(String caminho) {
        File arquivo = new File(caminho);

        if (!arquivo.exists()) {
            System.out.println("Arquivo " + caminho + " não encontrado!");
            return null;
        }

        try (FileInputStream fis = new FileInputStream(arquivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (ObraDeArte) ois.readObject();

        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Erro ao carregar a obra: " + e.getMessage());
            return null;
        }
    }
}