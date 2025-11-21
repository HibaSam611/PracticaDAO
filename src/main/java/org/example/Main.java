package org.example;

import dao.*;
import jdk.swing.interop.SwingInterOpUtils;
import model.*;
import service.BibliotecaService;

import java.time.LocalDate;
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
            System.out.println(" ");
            System.out.println(" *** MENÚ BIBLIOTECA ***");
            System.out.println("Selecciona la categoría");
            System.out.println("1. Libro");
            System.out.println("2. Autor");
            System.out.println("3. Usuario");
            System.out.println("4. Prestamo");
            System.out.println("5. Libro y autor");
            System.out.println("6. Salir");
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
                    menuPrestamo(sc, bibliotecaService);
                }
                case 5 -> {
                    menuLibroAutor (sc, bibliotecaService);
                }
                case 6 -> {
                    System.out.println("Saliendo...");
                }
                default -> {
                    System.out.println("Opción inválida");
                }
            }

        }while (opcion != 6);
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
                Libro libro = bibliotecaService.getLibroById(id);
                System.out.println(libro);
            }
            case 5 -> bibliotecaService.listarLibro().forEach(System.out::println);
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
            case 5 -> {bibliotecaService.listarAutor().forEach(System.out::println);}
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
            case 2 -> {
                System.out.println("Introduce el id del usuario a actualizar");
                int idUsuario = sc.nextInt();
                sc.nextLine();

                System.out.println("Introduce el nombre del usuario");
                String nuevoNombre = sc.nextLine();

                Usuario usuario = bibliotecaService.getUsuarioById(idUsuario);
                usuario.setNombre(nuevoNombre);

                bibliotecaService.actualizarUsuario(usuario);
            }
            case 3 -> {
                System.out.println("Introduce el id del usuario que quieres borrar: ");
                int id = sc.nextInt();
                bibliotecaService.eliminarUsuario(id);
            }
            case 4 -> {
                System.out.println("Introduce el id del usuario que quieres buscar: ");
                int id = sc.nextInt();
                Usuario usuario = bibliotecaService.getUsuarioById(id);
                System.out.println(usuario);
            }
            case 5 -> {
                bibliotecaService.listarUsuario().forEach(System.out::println);
            }
            case 6 -> {
                System.out.println("Saliendo...");
            }
            default -> System.out.println("Opcion invalida");
        }

    }

    public static void menuPrestamo(Scanner sc, BibliotecaService bibliotecaService) throws Exception {

        System.out.println("*********************");
        System.out.println("*** MENU PRESTAMO ***");
        System.out.println("1. Añadir prestamo");
        System.out.println("2. Actualizar prestamo");
        System.out.println("3. Borrar prestamo");
        System.out.println("4. Buscar prestamo por id");
        System.out.println("5. Buscar prestamo por usuario");
        System.out.println("6. Buscar prestamo por libro");
        System.out.println("7. Lista de prestamo");
        System.out.println("8. Salir");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1 -> {
                System.out.println("Escribe el id del usuario");
                int idUsuario = sc.nextInt();

                System.out.println("Escribe el id del libro");
                int idLibro = sc.nextInt();

                LocalDate fechaInicio = LocalDate.now();
                LocalDate fechaFin = fechaInicio.plusDays(30); //inicialmente el periodo de prestamo será de 30 días

                Prestamo prestamo= new Prestamo(0,fechaInicio, fechaFin,idUsuario,idLibro);

                bibliotecaService.anadirPrestamo(prestamo);
                System.out.println("Prestamo creado correctamente");
            }
            case 2 -> {
                System.out.println("Introduce el id del préstamo a actualizar");
                int idPrestamo = sc.nextInt();
                sc.nextLine();
                Prestamo prestamo = bibliotecaService.getPrestamoById(idPrestamo);

                System.out.println("Introduce la nueva fecha de fin en formato AAAA-MM-DD: ");
                LocalDate nuevaFechaFin = LocalDate.parse(sc.nextLine());
                prestamo.setFechaFin(nuevaFechaFin);

                bibliotecaService.actualizarPrestamo(prestamo);
            }
            case 3 -> {
                System.out.println("Introduce el id del prestamo que quieres borrar: ");
                int id = sc.nextInt();
                bibliotecaService.eliminarPrestamo(id);
            }
            case 4 -> {
                System.out.println("Introduce el id del prestamo quieres buscar: ");
                int id = sc.nextInt();
                Prestamo prestamo = bibliotecaService.getPrestamoById(id);
                System.out.println(prestamo);
            }
            case 5 -> {
                System.out.println("Introduce el id del usuario del prestamo");
                int id = sc.nextInt();
                bibliotecaService.getPrestamoByUsuario(id).forEach(System.out::println);
            }
            case 6 -> {
                System.out.println("Introduce el id del libro prestado");
                int id = sc.nextInt();
                bibliotecaService.getPrestamoByLibro(id).forEach(System.out::println);
            }
            case 7 -> {
                bibliotecaService.listarPrestamo().forEach(System.out::println);
            }
            case 8 -> {
                System.out.println("Saliendo...");
            }
            default -> System.out.println("Opcion invalida");
        }
    }

    public static void menuLibroAutor (Scanner sc, BibliotecaService bibliotecaService) throws Exception {
        System.out.println("*********************");
        System.out.println("*** MENU Libro y Autor ***");
        System.out.println("1. Añadir autor a un libro");
        System.out.println("2. Borrar autor de un libro");
        System.out.println("3. Listar los libros con sus autores");
        System.out.println("4. Listar autores de un libro");
        System.out.println("5. Listar libros de un autor");
        System.out.println("6. Salir");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce el id del libro");
                int idLibro = sc.nextInt();
                System.out.println("Introduce el id del autor");
                int idAutor = sc.nextInt();
                sc.nextLine();

                LibroAutor libroAutor = new LibroAutor(idLibro, idAutor);
                bibliotecaService.anadirLibroAutor(libroAutor);
            }
            case 2 -> {
                System.out.println("Introduce el id del libro que quieres borrar: ");
                int idLibro = sc.nextInt();
                System.out.println("Introduce el id del autor que quieres borrar: ");
                int idAutor = sc.nextInt();
                sc.nextLine();

                bibliotecaService.eliminarLibroAutor(idLibro, idAutor);
                System.out.println("Libro y autor eliminados");
            }
            case 3 -> {
                System.out.println("Lista de libros y autores:");
                for (LibroAutor la : bibliotecaService.listarLibroAutor()) {
                    Libro libro = bibliotecaService.getLibroById(la.getIdLibro());
                    Autor autor = bibliotecaService.getAutorById(la.getIdAutor());
                    System.out.println("Libro: " + libro.getTitulo() + " | Autor: " + autor.getNombre());
                }
            }
            case 4 -> {
                System.out.println("Introduce el id del libro:");
                int idLibro = sc.nextInt();
                sc.nextLine();
                System.out.println("Lista de autores del libro");
                for (LibroAutor la : bibliotecaService.listarLibroAutor()) {
                    if (la.getIdLibro() == idLibro) {
                        Autor autor = bibliotecaService.getAutorById(la.getIdAutor());
                        System.out.println("Autor: " + autor.getNombre());
                    }
                }
            }
            case 5 -> {
                System.out.println("Introduce el id del autor:");
                int idAutor = sc.nextInt();
                sc.nextLine();
                System.out.println("Lista de libros del autor");
                for (LibroAutor la : bibliotecaService.listarLibroAutor()) {
                    if (la.getIdLibro() == idAutor) {
                        Autor autor = bibliotecaService.getAutorById(la.getIdAutor());
                        System.out.println("Autor: " + autor.getNombre());
                    }
                }
            }
            case 6 -> {
                System.out.println("Saliendo...");
            }
            default -> System.out.println("Opcion invalida");
        }
    }

}

