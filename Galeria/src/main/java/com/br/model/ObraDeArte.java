package com.br.model;

import java.io.Serializable;

public class ObraDeArte implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private String artista;
    private byte[] fotoDaObra;

    public ObraDeArte(String titulo, String artista, byte[] fotoDaObra) {
        this.titulo = titulo;
        this.artista = artista;
        this.fotoDaObra = fotoDaObra;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public byte[] getFotoDaObra() {
        return fotoDaObra;
    }

    @Override
    public String toString() {
        int tamanho = (fotoDaObra == null) ? 0 : fotoDaObra.length;
        return titulo + " - " + artista + " - imagem com " + tamanho + " bytes";
    }
}