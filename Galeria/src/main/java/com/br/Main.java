package com.br;


import com.br.controller.GerenciadorGaleria;
import com.br.model.ObraDeArte;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        String caminhoImagem = "imagem.jpg";
        String arquivoBinario = "obra.dat";
        String imagemRecuperada = "obra_recuperada.jpg";

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Informe o título da obra:");
            String titulo = scanner.nextLine();

            System.out.println("Informe o nome do artista:");
            String artista = scanner.nextLine();

            byte[] foto = Files.readAllBytes(Path.of(caminhoImagem));
            System.out.println("Imagem lida: " + foto.length + " bytes");

            ObraDeArte obra = new ObraDeArte(titulo, artista, foto);

            GerenciadorGaleria.salvarObra(obra);

            ObraDeArte obraDoArquivo = GerenciadorGaleria.carregarObra(arquivoBinario);

            if (obraDoArquivo != null) {
                System.out.println("\nObra recuperada do arquivo:");
                System.out.println(obraDoArquivo);

                byte[] fotoRecuperada = obraDoArquivo.getFotoDaObra();
                Files.write(Path.of(imagemRecuperada), fotoRecuperada);

                System.out.println("\nImagem gerada: " + imagemRecuperada);
                System.out.println("Original: " + foto.length + " bytes");
                System.out.println("Recuperada: " + fotoRecuperada.length + " bytes");
                System.out.println("São idênticas? " + java.util.Arrays.equals(foto, fotoRecuperada));
            }

        } catch (IOException e) {
            System.out.println("Erro ao trabalhar com a imagem: " + e.getMessage());
        }
    }
}
