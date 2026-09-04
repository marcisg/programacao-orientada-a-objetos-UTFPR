package com.br;

import java.io.*;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        //Nome do arquivo (nome, idade)
        String nomeArq = "pessoas.bin";

        try (Scanner scanner = new Scanner(System.in);
             FileOutputStream fos = new FileOutputStream(nomeArq, true);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             DataOutputStream dos = new DataOutputStream(bos)) {
            String nome;
            int idade;
            do {
                System.out.println("Informe um nome ou S ou s para sair:");
                nome = scanner.nextLine();
                if (!nome.equalsIgnoreCase("s")) {
                    dos.writeUTF(nome);

                    System.out.println("Informe a idade:");
                    idade = scanner.nextInt();
                    dos.writeInt(idade);
                    scanner.nextLine();
                }

            } while (!nome.equalsIgnoreCase("s"));

        } catch (IOException e) {
            System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
        }


        File file = new File(nomeArq);
        if (file.exists()) {
            System.out.println("Lendo dados do Arquivo");

            try (FileInputStream fis = new FileInputStream(file);
                 BufferedInputStream bis = new BufferedInputStream(fis);
                 DataInputStream dis = new DataInputStream(bis)) {

                StringBuilder sb = new StringBuilder();
                while (true) {
                    try {
                        sb.append(dis.readUTF()).append(" ").append(dis.readInt()).append("\n");
                    } catch (EOFException eo) {
                        //Captura a exceção de Fim de Arquivo e sai do loop
                        break;
                    }
                }
                System.out.println(sb.toString());

            } catch (IOException ex) {
                System.out.println("Erro ao ler o arquivo: " + ex.getMessage());
            }
        } else {
            System.out.println("Arquivo " + nomeArq + " não encontrado!");
        }
    }
}
