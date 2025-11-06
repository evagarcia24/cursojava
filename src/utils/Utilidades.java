//En la clase Utilidades crear métodos:
//pintaMenu le vamos a pasar un array de Strings y nos va a mostrar todas las opciones que vengan en el array y al final va a pintar "Introduce una opción"
//pintaMenu le vamo
//pideDatoNumerico al que le pasamos un String denominado Texto//El método tiene que pintar el texto que le pasamos, recoger un dato numérico (int) por la consola y devolver el dato que se ha introducido
//pideDatoCadena al que le pasamos un String denominado Texto.El método tiene que pintar el texto que le pasamos, recoger un dato (String)por la consola y devolver el dato que se ha introducido

package utils;

import java.util.Scanner;

public class Utilidades {
	
	public static void main(String[] args) {
		String[] opciones = { "Pintar cuadrado", "Validar email", "Añadir alumno", "Salir" };

		pintaMenu(opciones);

		Scanner scanner = new Scanner(System.in);
		int opcionElegida = scanner.nextInt();
		System.out.println("Elegiste la opción: " + opcionElegida);

		System.out.println();

		pintaMenu(opciones, "Selecciona una opción válida:");

		opcionElegida = scanner.nextInt();
		System.out.println("Elegiste la opción: " + opcionElegida);

	}

	public static void pintaMenu(String[] opciones) {
	
		for (String opcion : opciones) {
			System.out.println(opcion);
		}
		System.out.println("Introduce una opción:");
	}

	public static void pintaMenu(String[] opciones, String texto) {
		for (String opcion : opciones) {
			System.out.println(opcion);
		}
		System.out.println(texto);
	}
	
	public static int pideDatoNumerico(String texto) {
		int numero = 0;
		System.out.println(numero);
		Scanner scan = new Scanner (System.in);
		numero = scan.nextInt();
		
		return numero;
	
	}
	
	public static String pideDatoCadena(String texto) {
		String dato = "";
		System.out.println(texto);
		Scanner scan = new Scanner (System.in);
		dato = scan.nextLine();
		
		return dato;
	}
	
	public static double pideDatoDecimal(String texto) {
		double decimal = 0.0;
		System.out.println(texto);
		Scanner scan = new Scanner (System.in);
		decimal = scan.nextDouble();
		
		return decimal;
	}


}