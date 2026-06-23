package com.biblioteca.controller;

import com.biblioteca.entity.Libro;
import com.biblioteca.service.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // GET /api/libros
    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.findAll();
    }

    // GET /api/libros/filtrar?anio_publicacion
    @GetMapping("/filtrar")
    public List<Libro> filtrarPorAnioPublicacion(@RequestParam Integer anio_publicacion) {
        return libroService.findByAniPublication(anio_publicacion);
    }

    // GET /api/libros/genero/{genero}
    @GetMapping("/genero/{genero}")
    public List<Libro> getLibrosByGenero(@PathVariable String genero) {
        return libroService.findByGenero(genero);
    }

    // GET /api/libros/autor/{autor}
    @GetMapping("/autor/{autor}")
    public List<Libro> getLibrosByAutor(@PathVariable String autor) {
        return libroService.findByAutor(autor);
    }

    // GET /api/libros/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        return libroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
