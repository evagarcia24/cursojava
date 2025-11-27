package es.hibernate;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.cursojava.examen.modulo2final.parte1.Curso;
import es.hibernate.UtilidadesHibernate;

public class CursoDAO {

    public void insertarCursosEjemplo() {
        Session session = UtilidadesHibernate.getSession();
        Transaction tx = session.beginTransaction();

        try {
            Curso c1 = new Curso("COD001", "Java Avanzado", "Curso completo de Java", 120, true, "Avanzado", "Programación", 1999.99, LocalDate.of(2025, 11, 20), LocalDate.of(2025, 12, 20));
            Curso c2 = new Curso("COD002", "Big Data Básico", "Introducción a Big Data", 80, true, "Básico", "Big Data", 999.99, LocalDate.of(2025, 10, 1), LocalDate.of(2025, 11, 1));
            Curso c3 = new Curso("COD003", "DevOps Intermedio", "Curso de DevOps", 100, true, "Intermedio", "DevOps", 599.99, LocalDate.of(2025, 11, 5), LocalDate.of(2025, 12, 5));

            session.persist(c1);
            session.persist(c2);
            session.persist(c3);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void mostrarTodosLosCursos() {
        Session session = UtilidadesHibernate.getSession();
        try {
            List<Curso> cursos = session.createQuery("FROM Curso", Curso.class).list();
            cursos.forEach(System.out::println);
        } finally {
            session.close();
        }
    }

    public void cargarCursosDesdeTxt(String ruta) throws Exception {
        List<String> lineas = Files.readAllLines(Paths.get(ruta));
        Session session = UtilidadesHibernate.getSession();
        Transaction tx = session.beginTransaction();

        try {
            for (String linea : lineas) {
                String[] partes = linea.split("\\|");
                if (partes.length < 10) {
                    System.err.println("Línea inválida: " + linea);
                    continue;
                }

                Curso curso = new Curso(
                    partes[0].trim(),
                    partes[1].trim(),
                    partes[2].trim(),
                    Integer.parseInt(partes[3].trim()),
                    Boolean.parseBoolean(partes[4].trim()),
                    partes[5].trim(),
                    partes[6].trim(),
                    Double.parseDouble(partes[7].trim()),
                    LocalDate.parse(partes[8].trim()),
                    LocalDate.parse(partes[9].trim())
                );

                session.persist(curso);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void leerTxt(String ruta) throws Exception {
        List<String> lineas = Files.readAllLines(Paths.get(ruta));
        for (String linea : lineas) {
            String[] partes = linea.split("\\|");
            System.out.println("---- Curso ----");
            for (int i = 0; i < partes.length; i++) {
                System.out.println("Campo " + i + ": " + partes[i].trim());
            }
        }
    }
}