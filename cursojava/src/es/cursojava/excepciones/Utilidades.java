package es.cursojava.excepciones;

import java.util.Scanner;
import java.time.Year;

public class Utilidades {

	// Scanner compartido para no cerrar System.in en cada método
	private static final Scanner SCANNER = new Scanner(System.in);

	public static int calcularEdad(int anioNacimiento) {
		int currentYear = Year.now().getValue();
		int edad = currentYear - anioNacimiento;
		return edad >= 0 ? edad : 0;
	}

	public static void pintaMenu(String[] opciones) {
		pintaMenu(opciones, "Introduce una opción");
	}

	public static void pintaMenu(String[] opciones, String texto) {
		if (opciones != null) {
			for (String opcion : opciones) {
				System.out.println(opcion);
			}
		}
		System.out.println(texto);

	}

	public static int pideDatoNumerico(String texto) {
		while (true) {
			System.out.println(texto);
			String line = SCANNER.nextLine();
			try {
				return Integer.parseInt(line.trim());
			} catch (NumberFormatException e) {
				System.out.println("No has introducido un valor correcto. Intenta de nuevo.");
			}
		}
	}

	// pide dato double
	public static double pideDatoDecimal(String texto) {
		while (true) {
			System.out.println(texto);
			String line = SCANNER.nextLine();
			try {
				return Double.parseDouble(line.trim());
			} catch (NumberFormatException e) {
				System.out.println("Valor introducido no correcto. Intenta de nuevo.");
			}
		}
	}

	// pide dato float
	public static float pideDatoDecimalF(String texto) {
		while (true) {
			System.out.println(texto);
			String line = SCANNER.nextLine();
			try {
				return Float.parseFloat(line.trim());
			} catch (NumberFormatException e) {
				System.out.println("Valor introducido no correcto. Intenta de nuevo.");
			}
		}
	}

	public static String pideDatoCadena(String texto) {
		System.out.println(texto);
		return SCANNER.nextLine();
	}
}