package dao;

import model.Autor;
import model.Libro;

import java.util.List;

public interface AutorDAO {
    void addAutor(Autor autor) throws Exception;
    List<Autor> getAllAutores() throws Exception;
    Autor getAutorById(int id) throws Exception;
    void updateAutor(Autor autor) throws Exception;
    void deleteAutor(int id) throws Exception;
}
