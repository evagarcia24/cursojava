package es.cursojava.excepciones;

import java.util.Scanner;
import oo.Alumno;

public class Main {

	public static void main(String[] args) throws NotaInvalidaException {
		
		Alumno[] alumnos = new Alumno[5];

		for (int i = 0; i < alumnos.length; i++) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Ingreso de datos para el alumno: " + (i + 1) + " :");

			try {
				PideDatoCadena.pideDatoCadena(nombre);

				
				alumnos[i] = new Alumno(nombre, notaMedia, edad);
				System.out.println("Alumno registrado correctamente.");

			} catch (IllegalArgumentException e) {
				System.out.println("Error en la edad, debe ser mayor de 0: " + e.getMessage());
			} finally {
				scanner.close();
			}
		}

	}
}