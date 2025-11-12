package service;

import dao.*;
import model.*;

import java.util.List;

public class BibliotecaService {
    private LibroDAO libroDAO;
    private AutorDAO autorDAO;
    private UsuarioDAO usuarioDAO;
    private PrestamoDAO prestamoDAO;
    private LibroAutorDAO libroAutorDAO;

    public BibliotecaService() {
        this.libroDAO = libroDAO;
        this.autorDAO = autorDAO;
        this.usuarioDAO = usuarioDAO;
        this.prestamoDAO = prestamoDAO;
        this.libroAutorDAO = libroAutorDAO;
    }

    public List<Libro> listarLibro() throws Exception{
        try {
            return libroDAO.getAllLibros();
        } catch (Exception e) {
            System.err.println("Error al listar libros: " + e.getMessage());
            return List.of();
        }
    }

    public List<Autor> listarAutor() throws Exception{
        try {
            return autorDAO.getAllAutores();
        } catch (Exception e) {
            System.err.println("Error al listar autores: " + e.getMessage());
            return List.of();
        }
    }
    public List<Usuario> listarUsuario() throws Exception{
        try {
            return usuarioDAO.getAllUsuarios();
        } catch (Exception e) {
            System.err.println("Error al listar usuarios: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public List<Prestamo> listarPrestamo() throws Exception{
        try {
            return prestamoDAO.getAllPrestamos();
        } catch (Exception e) {
            System.err.println("Error al listar prestamos: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<LibroAutor> listarLibroAutor() throws Exception{
        try {
            return libroAutorDAO.getAllLibrosAutores();
        } catch (Exception e) {
            System.out.println("Error al listar librosAutores: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    //eliminar
    public void eliminarLibro(int id) {
        try {
            libroDAO.deleteLibro(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar libro: " + e.getMessage());
        }
    }
    public void eliminarAutor(int id) {
        try {
            autorDAO.deleteAutor(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar autor: " + e.getMessage());
        }
    }
    public void eliminarUsuario(int id) {
        try {
            usuarioDAO.deleteUsuario(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public void eliminarPrestamo(int id) {
        try{
            prestamoDAO.deletePrestamo(id);
        }catch (Exception e){
            System.err.println("Error al eliminar prestamo: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public void eliminarLibroAutor(int idLibro, int idAutor) {
        try {
            libroAutorDAO.deleteLibroAutor(idLibro, idAutor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
