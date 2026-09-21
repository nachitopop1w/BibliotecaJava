package app;

import java.util.Scanner;

import modelos.Libro;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Libro[] biblioteca = {

            new Libro("978-01", "Java Básico", "Ana Pérez"),
            new Libro("978-02", "Python para Todos", "Luis Soto"),
            new Libro("978-03", "Bases de Datos", "María López")

        };

        int opcion;

        do {

            mostrarMenu();

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:

                    mostrarLibros(biblioteca);

                    break;

                case 2:

                    System.out.print("Ingrese el número del libro: ");
                    int numeroPrestar = scanner.nextInt();

                    try {

                        biblioteca[numeroPrestar - 1].prestar();
                        System.out.println("Libro prestado correctamente.");

                    } catch (Exception e) {

                        System.out.println("No se pudo prestar el libro: " + e.getMessage());

                    }

                    break;

                case 3:

                    System.out.print("Ingrese el número del libro: ");
                    int numeroDevolver = scanner.nextInt();

                    try {

                        biblioteca[numeroDevolver - 1].devolver();
                        System.out.println("Libro devuelto correctamente.");

                    } catch (Exception e) {

                        System.out.println("No se pudo devolver el libro: " + e.getMessage());

                    }

                    break;

                case 0:

                    System.out.println("Hasta pronto.");

                    break;

                default:

                    System.out.println("Opción no válida.");

            }

        } while (opcion != 0);

        scanner.close();

    }

    public static void mostrarMenu() {

        System.out.println("\n===============================");
        System.out.println(" SISTEMA DE BIBLIOTECA");
        System.out.println("===============================");
        System.out.println("1. Mostrar libros");
        System.out.println("2. Prestar libro");
        System.out.println("3. Devolver libro");
        System.out.println("0. Salir");
        System.out.println();

    }

    public static void mostrarLibros(Libro[] biblioteca) {

        for (int i = 0; i < biblioteca.length; i++) {

            System.out.println((i + 1) + ". " + biblioteca[i]);

        }

    }

}