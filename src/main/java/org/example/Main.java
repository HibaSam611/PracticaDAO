package org.example;

import dao.*;
import jdk.swing.interop.SwingInterOpUtils;
import model.Autor;
import model.Libro;
import model.Usuario;
import service.BibliotecaService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        //FALTAN AUTOR, LIBRO, LIBROAUTOR
        AutorDAO autorDAO = new AutorDAOImpl();
        LibroDAO libroDAO = new LibroDAOImpl();
        LibroAutorDAO libroAutorDAO = new LibroAutorDAOImpl();
        PrestamoDAO prestamoDAO = new PrestamoDAOImpl();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

        BibliotecaService bibliotecaService = new BibliotecaService(libroDAO, autorDAO, usuarioDAO, prestamoDAO, libroAutorDAO); //FALTAN AUTOR, LIBRO, LIBROAUTOR
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(" *** MENÚ BIBLIOTECA ***");
            System.out.println("Selecciona la categoría");
            System.out.println("1. Libro");
            System.out.println("2. Autor");
            System.out.println("3. Usuario");
            System.out.println("4. Prestamo");
            System.out.println("5. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    menuLibro(sc, bibliotecaService);
                }
                case 2 -> {
                    menuAutor(sc, bibliotecaService);
                }
                case 3 -> {
                    menuUsuario(sc, bibliotecaService);
                }
                case 4 -> {
                    menuPrestamo(sc);
                }
                case 5 -> {
                    System.out.println("Saliendo...");
                }
                default -> {
                    System.out.println("Opción inválida");
                }
            }

        }while (opcion != 4);
    }


    public static void menuLibro(Scanner sc, BibliotecaService bibliotecaService) throws Exception {
        System.out.println("*********************");
        System.out.println("*** MENU LIBRO ***");
        System.out.println("1. Añadir libro");
        System.out.println("2. Actualizar libro");
        System.out.println("3. Borrar libro");
        System.out.println("4. Buscar libro");
        System.out.println("5. Lista de libros");
        System.out.println("6. Salir");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce el nombre del libro");
                String nombreLibro = sc.nextLine();
                System.out.println("Introduce el isbn del libro");
                String isbn = sc.nextLine();
                Libro libro = new Libro(0,nombreLibro, isbn);
                bibliotecaService.anadirLibro(libro);
            }
            case 2 -> {
                System.out.println("Introduce el nombre del libro");
                String nombreLibro = sc.nextLine();
                System.out.println("Introduce el isbn del libro");
                String isbn = sc.nextLine();
                Libro libro = new Libro(0,nombreLibro, isbn);
                bibliotecaService.actualizarLibro(libro);
            }
            case 3 -> {
                System.out.println("Introduce el id del libro que quieres borrar: ");
                int id = sc.nextInt();
                bibliotecaService.eliminarLibro(id);
            }
            case 4 -> {
                System.out.println("Introduce el id del libro que quieres buscar: ");
                int id = sc.nextInt();
                bibliotecaService.getLibroById(id);
            }
            case 5 -> bibliotecaService.listarLibro();
            case 6 -> {
                System.out.println("Saliendo...");
            }
            default -> System.out.println("Opcion invalida");

        }
    }

    public static void menuAutor(Scanner sc, BibliotecaService bibliotecaService) throws Exception {
        System.out.println("*********************");
        System.out.println("*** MENU AUTOR ***");
        System.out.println("1. Añadir autor");
        System.out.println("2. Acltualizar autor");
        System.out.println("3. Borrar autor");
        System.out.println("4. Buscar autor");
        System.out.println("5. Lista de autores");
        System.out.println("6. Salir");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce el nombre del autor");
                String nombreAutor = sc.nextLine();
                Autor autor = new Autor(0,nombreAutor);
                bibliotecaService.anadirAutor(autor);
            }
            case 2 -> {
                System.out.println("Introduce el nombre del autor");
                String nombreAutor = sc.nextLine();
                Autor autor = new Autor(0,nombreAutor);
                bibliotecaService.actualizarAutor(autor);
            }
            case 3 -> {
                System.out.println("Introduce el id del autor que quieres borrar: ");
                int id = sc.nextInt();
                bibliotecaService.eliminarAutor(id);
            }
            case 4 -> {
                System.out.println("Introduce el id del autor que quieres buscar: ");
                int id = sc.nextInt();
                bibliotecaService.getLibroById(id);
            }
            case 5 -> {bibliotecaService.listarAutor();}
            case 6 -> {
                System.out.println("Saliendo...");
            }
            default -> System.out.println("Opcion invalida");
        }
    }

    public static void menuUsuario(Scanner sc, BibliotecaService bibliotecaService) throws Exception {

        System.out.println("*********************");
        System.out.println("*** MENU USUARIO ***");
        System.out.println("1. Añadir usuario");
        System.out.println("2. Acltualizar usuario");
        System.out.println("3. Borrar usuario");
        System.out.println("4. Buscar usuario");
        System.out.println("5. Lista de usuarios");
        System.out.println("6. Salir");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1 -> {
                System.out.println("Escribe el nombre del usuario");
                String nombre = sc.nextLine();

                Usuario usuario = new Usuario(0,nombre); //el cero es reemplazado por GENERATED_KEYS, otra alternativa es crear otro constructor sin el id
                bibliotecaService.anadirUsuario(usuario);
            }
        }

    }

    public static void menuPrestamo(Scanner sc) {

        System.out.println("*********************");
        System.out.println("*** MENU PRESTAMO ***");
        System.out.println("1. añadir prestamo");
        System.out.println("2. Actualizar prestamo");
        System.out.println("3. Borrar prestamo");
        System.out.println("4. Buscar prestamo");
        System.out.println("5. Lista de prestamo");
        System.out.println("6. Salir");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1 -> {

            }
        }
    }

}

