package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class UtilidadesHibernate {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Curso.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError("Error al crear SessionFactory: " + ex);
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    // Insertar 3 cursos
    public static void insertarCursos() {
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        try {
            Curso c1 = new Curso("COD001", "Java Avanzado",
                    "Curso completo de Java con POO y Spring Boot", 120, true,
                    "Avanzado", "Programación", 1999.99,
                    LocalDate.of(2025, 11, 20), LocalDate.of(2025, 12, 20));

            Curso c2 = new Curso("COD002", "Big Data Básico",
                    "Introducción a Big Data y análisis de datos masivos", 80, true,
                    "Básico", "Big Data", 999.99,
                    LocalDate.of(2025, 10, 1), LocalDate.of(2025, 11, 1));

            Curso c3 = new Curso("COD003", "DevOps Intermedio",
                    "Curso de integración continua y despliegue con DevOps", 100, true,
                    "Intermedio", "DevOps", 599.99,
                    LocalDate.of(2025, 11, 5), LocalDate.of(2025, 12, 5));

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

    // Mostrar todos los cursos
    public static void mostrarTodosLosCursos() {
        Session session = getSession();
        try {
            List<Curso> cursos = session.createQuery("FROM Curso", Curso.class).list();
            for (Curso curso : cursos) {
				System.out.println(curso);
			}
        } finally {
            session.close();
        }
    }

    // Mostrar solo cursos activos
    public static void mostrarCursosActivos() {
        Session session = getSession();
        try {
            List<Curso> cursos = session.createQuery("FROM Curso WHERE activo = true", Curso.class).list();
            cursos.forEach(System.out::println);
        } finally {
            session.close();
        }
    }
}
