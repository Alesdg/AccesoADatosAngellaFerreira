package com.biblioteca.service;

import com.biblioteca.entity.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LibroService {

    private final SessionFactory sessionFactory;

    public LibroService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertAll(List<Libro> libros) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            for (Libro libro : libros) {
                session.persist(libro);
            }

            transaction.commit();
            System.out.println("Insertados " + libros.size() + " productos correctamente.");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error al insertar productos: " + e.getMessage());
        }
    }

    public List<Libro> findLowAniPublication(Integer min) {
        try (Session session = sessionFactory.openSession()) {
            Query<Libro> query = session.createQuery(
                    "FROM Libro WHERE anio_publicacion < :min ORDER BY anio_publicacion ASC", Libro.class);
            query.setParameter("min", min);
            return query.getResultList();
        }
    }

    public List<Libro> findByGenero(String genre) {
        try (Session session = sessionFactory.openSession()) {
            Query<Libro> query = session.createQuery("FROM Libro WHERE genero = :genero", Libro.class);
            query.setParameter("genre", genre);
            return query.getResultList();
        }
    }

    public List<Libro> findByAvaiable() {
        try (Session session = sessionFactory.openSession()) {
            Query<Libro>  query = session.createQuery("FROM Libro WHERE disponible = 1", Libro.class);
            return query.getResultList();
        }
    }
}
