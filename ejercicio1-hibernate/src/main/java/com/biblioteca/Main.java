package com.biblioteca;

import com.biblioteca.entity.Libro;
import com.biblioteca.service.LibroService;
import com.biblioteca.service.ImporterService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Inicializar Hibernate usando hibernate.cfg.xml
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        ImporterService importerService = new ImporterService();
        LibroService libroService   = new LibroService(sessionFactory);


        System.out.println("=== Leyendo productos desde CSV ===");
        List<Libro> libros = importerService.readFromCSV(
                "C:/Users/alesn/Universidad U-tad 2do año (contenido)/Acceso a Datos/ordinaria/libros.csv");
        System.out.println("Total leídos: " + libros.size());


        System.out.println("\n=== Insertando en la base de datos ===");
        libroService.insertAll(libros);


        System.out.println("\n=== Libros con anio_publicacion < 2001 ===");
        List<Libro> anio_publicacionMenor;
        anio_publicacionMenor = libroService.findLowAniPublication(2001);
        if (anio_publicacionMenor.isEmpty()) {
            System.out.println("No hay libros con anio_publicacion.");
        } else {
            anio_publicacionMenor.forEach(System.out::println);
        }


        sessionFactory.close();
    }
}
