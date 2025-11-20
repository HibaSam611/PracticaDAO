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


    public BibliotecaService(LibroDAO libroDAO, AutorDAO autorDAO, UsuarioDAO usuarioDAO, PrestamoDAO prestamoDAO, LibroAutorDAO libroAutorDAO) {
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

    public List<Prestamo> getPrestamoByUsuario(int id) throws Exception{
        try {
            return prestamoDAO.getPrestamoByUsuario(id);
        }catch (Exception e){
            System.err.println("Error al listar prestamos por usuario: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<Prestamo> getPrestamoByLibro(int libroid) throws Exception{
        try {
            return prestamoDAO.getPrestamoByLibro(libroid);
        }catch (Exception e){
            System.err.println("Error al listar prestamos por libro: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    //BUSCAR Y DEVOLVER UNO CONCRETO
    public Prestamo getPrestamoById(int id) throws Exception{
        try {
            return prestamoDAO.getPrestamoById(id);
        }catch (Exception e){
            System.err.println("Error al mostrar el prestamo por usuario: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Usuario getUsuarioById(int id) throws Exception{
        try {
            return usuarioDAO.getUsuarioById(id);
        }catch (Exception e){
            System.err.println("Error al mostrar el usuario por usuario: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public Libro getLibroById(int id) throws Exception{
        return libroDAO.getLibroById(id);
    }


    //ANADIR
    public void anadirLibro(Libro libro) throws Exception {
        try {
            libroDAO.addLibro(libro);
        } catch (Exception e) {
            System.out.println("Error al anadir libro: " + e.getMessage());
        }
    }

    public void anadirPrestamo(Prestamo prestamo) throws Exception {
        try {
            prestamoDAO.addPrestamo(prestamo);
        } catch (Exception e) {
            System.out.println("Error al añadir prestamo: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void anadirUsuario(Usuario usuario) throws Exception {
        try {
            usuarioDAO.addUsuario(usuario);
        }catch (Exception e){
            System.out.println("Error al añadir al usuario: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void anadirAutor(Autor autor) throws Exception {
        try {
            autorDAO.addAutor(autor);
        } catch (Exception e) {
            System.out.println("Error al anadir autor: " + e.getMessage());
        }
    }
    public void anadirLibroAutor(LibroAutor autor) throws Exception {
        try {
            libroAutorDAO.addLibroAutor(autor);
        }catch (Exception e){
            System.out.println("Error al anadir autor: " + e.getMessage());
        }
    }



    //ACTUALIZAR
    public void actualizarPrestamo(Prestamo prestamo) throws Exception {
        try {
            prestamoDAO.updatePrestamo(prestamo);
        }catch (Exception e){
            System.out.println("Error al actualizar prestamo: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void actualizarUsuario (Usuario usuario) throws Exception {
        try {
            usuarioDAO.updateUsuario(usuario);
        }catch (Exception e){
            System.out.println("Error al actualizar usuario: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void actualizarLibro(Libro libro) throws Exception {
        try{
            libroDAO.updateLibro(libro);
        } catch (Exception e) {
            System.out.println("Error al actualizar libro: " + e.getMessage());
        }
    }
    public void actualizarAutor(Autor autor) throws Exception {
        try{
            autorDAO.updateAutor(autor);
        } catch (Exception e) {
            System.out.println("Error al actualizar autor: " + e.getMessage());
        }
    }
    public void actualizarLibroAutor(LibroAutor autor) throws Exception {
        try {
            libroAutorDAO.updateLibroAutor(autor);
        } catch (Exception e) {
            System.out.println("Error al actualizar libro autor: " + e.getMessage());
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
