package org.example;

import dao.PrestamoDAO;
import dao.PrestamoDAOImpl;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import jdk.swing.interop.SwingInterOpUtils;
import model.Usuario;
import service.BibliotecaService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        //FALTAN AUTOR, LIBRO, LIBROAUTOR
        PrestamoDAO prestamoDAO = new PrestamoDAOImpl();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

        BibliotecaService bibliotecaService = new BibliotecaService(prestamoDAO,usuarioDAO); //FALTAN AUTOR, LIBRO, LIBROAUTOR
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
                    menuLibro(sc);
                }
                case 2 -> {
                    menuAutor(sc);
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


    public static void menuLibro(Scanner sc) {

    }

    public static void menuAutor(Scanner sc) {

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
        System.out.println("1. ");
    }

}

