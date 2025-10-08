package es.cursojava.interfaces.ejercicios.colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import oo.Alumno;

public class Main {

	public static void main(String[] args) {
   

        // Crear 6 alumnos
        Alumno alumno1 = new Alumno("Ivan", "1A", 7.5);
        Alumno alumno2 = new Alumno("Pedro", "2A", 6);
        Alumno alumno3 = new Alumno("Laura", "3A", 10);
        Alumno alumno4 = new Alumno("Marta", "4A", 9.5);
        Alumno alumno5 = new Alumno("Alex", "5A", 3.5);
        Alumno alumno6 = new Alumno("Jaime", "6A", 7);
        						
        List<Alumno> listaAlumnos = new ArrayList<>();
        
        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);
        listaAlumnos.add(alumno3);
        listaAlumnos.add(alumno4);
        listaAlumnos.add(alumno5);
        listaAlumnos.add(alumno6);

        mostrarInfo(listaAlumnos);

        mostrarSobresalientes(listaAlumnos);

//        mostrarNotaPorNombre(listaAlumnos);
        
        eliminarSuspensos(listaAlumnos);
        
        

    }

	// 3. Mostrar info de todos los alumnos
	private static void mostrarInfo(List<Alumno> listaAlumnos) {
		System.out.println("Todos los alumnos:");
		for (Alumno alumno : listaAlumnos) {
			System.out.println(alumno);
		}
	}

	// 4. Mostrar nombre y nota de alumnos con notaMedia > 9
	public static void mostrarSobresalientes(List<Alumno> listaAlumnos) {
		System.out.println("\nNombres de alumnos con nota > 9:");
		for (Alumno alumno : listaAlumnos) {

			if (alumno.getNotaMedia() > 9) {
				System.out.println("Nombre: " + alumno.getNombre() + ", Nota: " + alumno.getNotaMedia());
			}
		}
	}

	// 5. Mostrar notaMedia de todos los alumnos con el mismo nombre
	public static void mostrarNotaPorNombre(List<Alumno> listaAlumnos) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nIntroduce el nombre del alumno para ver sus notas: ");
		String nombreBuscado = scanner.nextLine();

		boolean encontrado = false;
		for (Alumno alumno : listaAlumnos) {
			if (alumno.getNombre().equalsIgnoreCase(nombreBuscado)) {
				System.out.println("Alumno: " + alumno.getNombre() + ", Nota media: " + alumno.getNotaMedia());
				encontrado = true;
			}
		}

		if (!encontrado) {
			System.out.println("No se encontraron alumnos con ese nombre.");
		}
	}

	// 6. Eliminar alumnos suspensos
	public static void eliminarSuspensos(List<Alumno> listaAlumnos) {
		for (Alumno alumno : listaAlumnos) {
			if(alumno.getNotaMedia()<5) {
				listaAlumnos.remove(alumno);
			}
		}
	}

}
