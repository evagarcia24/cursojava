//Generar una frase de manera aleatoria. //Solicitar el nombre del jugador, mostrar de manera inicial todos los caracteres de la frase con "_"
//	El gato come una manzana
//	__ ____ ____ ___ _______
//Solicitar al usuario letras si acierta la letra se mostrará la letra acertada
//Ejemplo: a
//	__ _a__ ____ __a _a__a_a
//Ejemplo: i
//	Letra no encontrada. Intentos restantes: 5
//	__ _a__ ____ __a _a__a_a
//Intentar adivinar la frase antes de fallar seis intentos.// Si no falla en 6 ocasioes el usuario pierde.
package utils;

import java.util.Random;
import java.util.Scanner;

public class AhorcadoEva {

	public static void main(String[] args) {

		String[] sujetos = { "El gato", "La niña", "Mi amigo", "Un hombre", "La policía", "El perro", "La profesora",
				"Un payaso", "El médico", "La madre", "El robot", "Mi vecino" };
		String[] verbos = { "come", "pinta", "busca", "rompe", "salta", "canta", "lava", "lee", "mueve", "atrapa",
				"conduce", "enciende" };
		String[] complementos = { "una manzana", "la casa", "el coche", "una canción", "el jardín", "la calle",
				"el balón", "un sombrero", "la ventana", "la lámpara", "el periódico", "el fuego" };

		Scanner scan = new Scanner(System.in);
		System.out.println("Dime tu nombre: ");
		String nombre = scan.nextLine();

		int aleatorioSujetos = (int)(Math.random() * 12);
//		System.out.println(aleatorioSujetos);

		int aleatorioVerbos = (int)(Math.random() * 12);
//		System.out.println(aleatorioVerbos);

		int aleatorioComplementos = (int)(Math.random() * 12);
//		System.out.println(aleatorioComplementos);

		String fraseAleatoria = sujetos[aleatorioSujetos] + " " + verbos[aleatorioVerbos] + " "	+ complementos[aleatorioComplementos];
		System.out.println(fraseAleatoria);
		
		String fraseAleatoriaGuiones = fraseAleatoria.replaceAll("[^ ]", "_");
		System.out.println(fraseAleatoriaGuiones);
		
		System.out.println("Introduce una letra: ");
		String letra = scan.nextLine();
		
		for (int i=6; i>=6; i--) {
		
		if(fraseAleatoria.contains(letra)) {
			
		}else {
			System.out.println("Letra no encontrada. Intentos restantes: " + (i-1));
		}

	}
	}

}
