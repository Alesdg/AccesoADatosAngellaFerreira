package com.biblioteca.service;

import com.biblioteca.entity.Libro;

import com.biblioteca.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private Object anioPublicacionMin;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }

    public List<Libro> findByGenero(String genero) {
        return libroRepository.findByGenero(genero);
    }

    public List<Libro> findByAutor(String autor) {
        return libroRepository.findByAutor(autor);
    }

    public List<Libro> findByAniPublication(Integer anio_publicacion) {
        return libroRepository.findByAnioPublicacion(anio_publicacion);
    }
}
