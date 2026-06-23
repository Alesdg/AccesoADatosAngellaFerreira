package com.biblioteca.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Prueba para commit
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "anio_publicacion", nullable = false)
    private Integer anio_publicacion;

    @Column(name = "genero", nullable = false)
    private String genero;

    @Column(name = "disponible", nullable = false)
    private Boolean disponible;

    public Libro() {}

    public Libro(String titulo, String autor, String isbn, Integer anio_publicacion, String genero, Boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anio_publicacion = anio_publicacion;
        this.genero = genero;
        this.disponible = disponible;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String autor) { this.isbn = isbn; }

    public Integer getAnioPublicacion() { return anio_publicacion; }
    public void setAnioPublicacion(Integer anio_publicacion) { this.anio_publicacion = anio_publicacion; }

    public String getGenero() { return genero; }
    public void setGenero(String autor) { this.genero = genero; }

    public Boolean getDisponible() { return disponible; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }


    @Override
    public String toString() {
        return String.format("Libro{id=%d, titulo='%s',autor='%s',isbn='%s', anio_publicacion=%d, genero='%s', disponible='%s'}",
                id, titulo, autor, isbn, anio_publicacion, genero, disponible);
    }
}
