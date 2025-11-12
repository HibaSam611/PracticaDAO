package dao;

import model.Libro;
import model.LibroAutor;

import java.util.List;

public interface LibroAutorDAO {
    void addLibroAutor(LibroAutor libroAutor) throws Exception;
    List<Libro> getAllLibrosAutores() throws Exception;
    LibroAutor getLibrosAutoresById(int idLibro, int idAutor) throws Exception;
    void updateLibroAutor(LibroAutor libroAutor) throws Exception;
    void deleteLibroAutor(int idLibro, int idAutor) throws Exception;
}
