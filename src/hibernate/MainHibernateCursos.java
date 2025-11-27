package hibernate;

import es.hibernate.UtilidadesHibernate;

public class MainHibernateCursos {
	public static void main(String[] args) throws Exception {

		// 1️⃣ Insertar cursos en la base de datos
		UtilidadesHibernate.insertarCursos();

		// 2️⃣ Mostrar todos los cursos
		System.out.println("=== Todos los cursos ===");
		UtilidadesHibernate.mostrarTodosLosCursos();

		// 3️⃣ Mostrar solo los cursos activos
		System.out.println("=== Cursos activos ===");
		UtilidadesHibernate.mostrarCursosActivos();

		// Leer datos de un fichero de texto y cargar cursos en la base de datos
		UtilidadesHibernate.leerTxtSeparadoPorPipe("C:/Users/Tardes/Documents/cursos.txt");

		
		// 4️⃣ Cargar cursos desde un fichero de texto
		System.out.println("=== Cargar cursos desde un fichero ===");

		String rutaFichero = "C:/Users/Tardes/Documents/cursos.txt";

		try {
			UtilidadesHibernate.cargarCursosDesdeTxt(rutaFichero);
		} catch (Exception e) {
			System.err.println("Error al cargar cursos desde el fichero: " + e.getMessage());
		}

	}

}
