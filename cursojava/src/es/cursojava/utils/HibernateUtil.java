package es.cursojava.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static Session session;

	private static Session getSession() {
		SessionFactory sessionFactory = new Configuration().configure() // Carga hibernate.cfg.xml
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		return session;
	}

	public static Session getSessionFactory() {
		if (session == null || !session.isOpen()) {
			session = getSession();
		}
		return session;
	}

	public String leerArchivo3(String nombre) throws IOException {
		Path path = Paths.get(nombre);
		StringBuilder sb = new StringBuilder();

		List<String> lines = Files.readAllLines(path);
		for (String linea : lines) {
			sb.append(linea + "\n");
		}

		return sb.toString();
	}

	private static void generarCursosDesdeFichero() {
		String rutaFichero = "";
		try {
			List<String> lineas = UtilidadesFicheros.leerFichero(rutaFichero);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
