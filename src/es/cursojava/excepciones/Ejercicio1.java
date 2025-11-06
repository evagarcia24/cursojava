package es.cursojava.excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {

	public static int pideDatoNumerico(String texto) {
		int numero = 0;
		System.out.println(texto);
		Scanner scan = new Scanner(System.in);

		try {
			numero = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Error: Debes introducir un número.\n");
			return pideDatoNumerico(texto); 
		} 
//		finally {
//			System.out.println("Fin");
//		}

		return numero;
	}

	public static void main(String[] args) {
		int resultado = pideDatoNumerico("Introduce un número:");
		System.out.println("Número introducido: " + resultado);
	}
}
