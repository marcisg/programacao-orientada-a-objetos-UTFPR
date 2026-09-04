package br.com;

import java.io.*;

public class Main {
    static void main(String[] args) {

        File file1 = new File("arquivo1.txt");
        File file2 = new File("arquivo2.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file1))) {
            for (int i = 1; i <= 10; i++) {
                writer.write("5 * " + i + " = " + (i * 5));
                writer.newLine(); }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo1: " + e.getMessage());
        }
        if (file1.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file1));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {
                String linha; while ((linha = reader.readLine()) != null) {
                    writer.write(linha);
                    writer.newLine(); }
                System.out.println("Cópia concluída: " + file2.getAbsolutePath());
            }
            catch (IOException e) {
                System.out.println("Erro ao copiar: " + e.getMessage());
            }
        } else {
            System.out.println("Arquivo não encontrado.");
        }

        System.out.println("--- Conteúdo do arquivo2 ---");

        try (BufferedReader reader = new BufferedReader(new FileReader(file2))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo2: " + e.getMessage());
        }
    }
}
