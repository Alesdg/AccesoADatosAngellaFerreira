package com.biblioteca.repository;

import com.biblioteca.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByAnioPublicacion(Integer anio_publication);

    List<Libro> findByGenero(String genero);

    List<Libro> findByAutor(String autor);
}
