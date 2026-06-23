package com.biblioteca.service;

import com.biblioteca.entity.Libro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImporterService {

    public List<Libro> readFromCSV(String filename) {
        List<Libro> libros = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(filename, java.nio.charset.StandardCharsets.UTF_8))) {

            String linea;
            boolean esCabecera = true;

            while ((linea = reader.readLine()) != null) {
                if (esCabecera) {
                    esCabecera = false;
                    continue;
                }

                String[] campos = linea.split(";");
                if (campos.length == 4) {
                    String titulo = campos[0].trim();
                    String autor = campos[1].trim();
                    String isbn = campos[2].trim();
                    Integer anio_publicacion = Integer.parseInt(campos[3].trim());
                    String genero = campos[4].trim();
                    Boolean disponible = Boolean.valueOf(campos[5].trim());

                    libros.add(new Libro(titulo, autor, isbn, anio_publicacion, genero, disponible));
                }
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir un número en el CSV: " + e.getMessage());
        }

        return libros;
    }
}
