package model;

import java.util.ArrayList;

public class Libro {
    private int id;
    private String titulo;
    private String isbn;

    public Libro() {}
    public Libro(int id, String titulo, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }


    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }


    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }


    @Override
    public String toString() {
        return "Libro -> ID=" + id + ", Título='" + titulo + "'" + ", ISBN='" + isbn + "'";
    }
}
