//4. Mostrar todas las tablas de multiplicar hasta el número que solicites al usuario
package es.cursojava.inicio.bucles;

import java.util.Scanner;

public class TablasMultiplicarFor {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número: ");
		int num = scan.nextInt();

		for (int i = 1; i <= num; i++) { 
			System.out.println("\nTabla del " + i + ":");
			
			for (int j = 1; j <= 10; j++) { 
				System.out.println(i + " * " + j + " = " + i*j);
			}
		}
	}
}