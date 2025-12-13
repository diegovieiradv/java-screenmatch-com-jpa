package br.com.alura.screenmatch.model;

import java.text.Normalizer;

public enum Categoria {
    ACÃO("action", "Ação"),
    COMEDIA("comedy", "Comedia"),
    DRAMA("drama", "Drama"),
    ROMANCE("romance", "Romance"),
    TERROR("horror", "Terror"),
    CRIME("crime", "Crime"),
    AVENTURA("Adventure", "Aventura"),
    FICÇÃO("ficcao", "Ficção");

    private String categoriaOmdb;
    private String categoriaPortugues;

    Categoria(String categoriaOmdb, String categoriaPortugues) {
        this.categoriaOmdb = categoriaOmdb;
        this.categoriaPortugues = categoriaPortugues;
    }

    public static Categoria fromSpring(String text){
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Categoria inválida: " + text);
    }

    public static Categoria fromPortugues(String text){
        String textoNormalizado = Normalizer
                .normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase();

        for (Categoria categoria : Categoria.values()) {
            String categoriaNormalizada = Normalizer
                    .normalize(categoria.categoriaPortugues, Normalizer.Form.NFD)
                    .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                    .toLowerCase();

            if (categoriaNormalizada.equals(textoNormalizado)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Categoria inválida: " + text);
    }
}
