package es.cursojava.interfaces.ejercicios.colecciones;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.cursojava.excepciones.NotaInvalidaException;
import es.cursojava.utils.Utilidades;
import oo.Alumno;

public class Main {

	public static void main(String[] args) throws NotaInvalidaException {

		// Creacion de 7 alumnos (con nombre, dni y nota)
		Alumno alumno1 = new Alumno("Pedro", "111A", 4);
		Alumno alumno2 = new Alumno("Marta", "222B", 7);
		Alumno alumno3 = new Alumno("Ivan", "333C", 5);
		Alumno alumno4 = new Alumno("Lucía", "444D", 6);
		Alumno alumno5 = new Alumno("Ruben", "555E", 6);
		Alumno alumno6 = new Alumno("Laura", "666F", 10);
		Alumno alumno7 = new Alumno("Carlos", "777G", 8);
		
		// Aulas para cada colegio
				Map<String, List<Alumno>> aulas1 = new HashMap<>();
				aulas1.put("aula1", Arrays.asList(alumno1, alumno2));

				Map<String, List<Alumno>> aulas2 = new HashMap<>();
				aulas2.put("aula2", Arrays.asList(alumno3, alumno4));

				Map<String, List<Alumno>> aulas3 = new HashMap<>();
				aulas3.put("aula3", Arrays.asList(alumno5, alumno6, alumno7));

				// Crear colegios
				Colegio colegio1 = new Colegio("Colegio1", "Calle Uno", aulas1);
				Colegio colegio2 = new Colegio("Colegio2", "Calle Dos", aulas2);
				Colegio colegio3 = new Colegio("Colegio3", "Calle Tres", aulas3);

				// Lista de colegios
				List<Colegio> colegios = Arrays.asList(colegio1, colegio2, colegio3);


		// Mapa con clave de aula y valor de lista de alumnos
		Map<String, List<Alumno>> aulas = new HashMap<>();

		aulas.put("aula1", Arrays.asList(alumno1, alumno2));
		aulas.put("aula2", Arrays.asList(alumno3));
		aulas.put("aula3", Arrays.asList(alumno4, alumno5, alumno6, alumno7));
		

		// Numero total de aulas
		System.out.println("Número total de aulas: " + aulas.size() + "\n");

		// Mostrar por cada aula los datos de los alumnos
		for (String aula : aulas.keySet()) {
			System.out.println("Aula: " + aula);
			List<Alumno> alumnos = aulas.get(aula); 
			for (Alumno alumno : alumnos) {
				System.out.println("  " + alumno);
			}
		}

		// Mostrar por cada aula cuantos alumnos hay
		System.out.println("\nCantidad de alumnos por aula:");
		for (Map.Entry<String, List<Alumno>> entry : aulas.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue().size() + " alumnos");
		}

		// Solicitar el nombre de 1 aula y mostrar todos los alumnos del aula si el aula existe
		String nombreAula = Utilidades.pideDatoCadena("\nIntroduce nombre del aula: ");
		if (aulas.containsKey(nombreAula)) {
			System.out.println("Alumnos en " + nombreAula + ":");
		    for (Alumno alumno : aulas.get(nombreAula)) {
		        System.out.println("  " + alumno);
		    }
		} else {
			System.out.println("El aula no existe.");
		}

	}

}
