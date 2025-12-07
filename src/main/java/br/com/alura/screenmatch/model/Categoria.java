package br.com.alura.screenmatch.model;

public enum Categoria {
    ACÃO("action"),
    COMEDIA("comedy"),
    DRAMA("drama"),
    ROMANCE("romance"),
    TERROR("horror"),
    CRIME("crime"),
    AVENTURA("Adventure"),
    FICÇÃO("ficcao");

    private String categoriaOmdb;

    Categoria(String categoriaOmdb) {
        this.categoriaOmdb = categoriaOmdb;
    }

    public static Categoria fromSpring(String text){
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Categoria inválida: " + text);
    }
}
