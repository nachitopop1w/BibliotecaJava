package modelos;

import excepciones.LibroNoDisponibleException;
import excepciones.LibroNoPrestadoException;

public class Libro {

    private String isbn;
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    // ==========================
    // Getters
    // ==========================

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // ==========================
    // Métodos principales
    // ==========================

    public void prestar() throws LibroNoDisponibleException {

        if (!disponible) {
            throw new LibroNoDisponibleException("El libro no está disponible.");
        }

        disponible = false;
    }

    public void devolver() throws LibroNoPrestadoException {

        if (disponible) {
            throw new LibroNoPrestadoException("El libro no está prestado.");
        }

        disponible = true;
    }

    @Override
    public String toString() {

        return "ISBN: " + isbn
                + "\nTítulo: " + titulo
                + "\nAutor: " + autor
                + "\nEstado: " + (disponible ? "Disponible" : "Prestado");
    }

}