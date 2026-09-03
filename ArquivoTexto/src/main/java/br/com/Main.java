package br.com;

import java.io.*;

public class Main {
    static void main(String[] args) {

        String nomeArq = "arquivo_texto.txt";
        File file = new File(nomeArq);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write("Olá mundo!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(file.exists()){
            System.out.println(file.getAbsolutePath());

            try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
                int character;
                while ((character = reader.read()) != -1){
                    System.out.println((char)character);
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo");
            }
        }else {
            System.out.println("Arquivo não encontrado.");
        }
    }

}
