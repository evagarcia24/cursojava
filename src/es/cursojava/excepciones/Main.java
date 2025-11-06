package es.cursojava.excepciones;

import java.util.Scanner;
import oo.Alumno;

public class Main {

	public static void main(String[] args) throws NotaInvalidaException {
		Scanner scanner = new Scanner(System.in);
		Alumno[] alumnos = new Alumno[5];

		for (int i = 0; i < alumnos.length; i++) {
			System.out.println("Ingreso de datos para el alumno: " + (i + 1) + " :");

			try {
				System.out.print("Nombre: ");
				String nombre = scanner.nextLine();

				System.out.print("Edad: ");
				int edad = Integer.parseInt(scanner.nextLine());

				System.out.print("Nota media (0-10): ");
				double notaMedia = Double.parseDouble(scanner.nextLine());


				// Creamos el alumno con constructor que lanza NotaInvalidaException
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