package com.br;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {


        ObjectMapper objectMapper = new ObjectMapper();

        List<Carro> carros = new ArrayList<>();

        //1. Serialização: Java -> Json
        Carro meuCarro = new Carro("Chevrolet", "Onix", 2022, "Carmim");
        Carro meuCarro1 = new Carro("Honda", "Civic", 2023, "Branco");
        Carro meuCarro2 = new Carro("Ford", "Mustang", 1969, "Vermelho");
        Carro meuCarro3 = new Carro("Toyota", "Corolla", 2024, "Prata");

        carros.add(meuCarro);
        carros.add(meuCarro1);
        carros.add(meuCarro2);
        carros.add(meuCarro3);

        File arquivoJson = new File("meucarro.json");
        try {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT); //deixar o json bonito

            objectMapper.writeValue(arquivoJson, carros);

            System.out.println("Obejto salvo no arquivo: " + arquivoJson.getAbsolutePath());

        } catch (Exception e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }


        //2.Desserealização: JSON > Objeto Java
        try {

            List<Carro> carrosDesserializados = new ArrayList<>();

            if(arquivoJson.exists()){
                carrosDesserializados = objectMapper.readValue(arquivoJson, objectMapper.getTypeFactory().constructCollectionType(List.class, Carro.class));
                System.out.println("\nObjeto Java lido do Arquivo: ");
                System.out.println(carrosDesserializados.toString());
            }

        } catch (IOException ioe) {
            System.out.println("Erro ao salvar arquivo: " + ioe.getMessage());
        }

        /*
        File arquivoJson = new File("meucarro.json");
        try {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT); //deixar o json bonito

            objectMapper.writeValue(arquivoJson, meuCarro);

            System.out.println("Obejto salvo no arquivo: " + arquivoJson.getAbsolutePath());

        } catch (Exception e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }


        //2.Desserealização: JSON > Objeto Java
        try {
            if(arquivoJson.exists()){
                Carro carroDoArquivo = objectMapper.readValue(arquivoJson, Carro.class);
                System.out.println("\nObjeto Java lido do Arquivo: ");
                System.out.println(carroDoArquivo.toString());
            }

        } catch (IOException ioe) {
            System.out.println("Erro ao salvar arquivo: " + ioe.getMessage());
        }
    }
        * */
    }
}
