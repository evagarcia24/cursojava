//Pedir 10 numeros --> Indicar cuantos son multiplos de 3 y cuantos multiplos de 5
package es.cursojava.inicio.bucles;

import java.util.Scanner;

public class Ejercicio3While {

	public static void main(String[] args) {

		int multiplo3=0;
		int multiplo5=0;
		
		int i = 0;
		while (i < 10) {
			System.out.println("Introduce un numero: ");
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			if(num%3==0) {
				System.out.println("Es multiplo de 3");
				multiplo3++;
			}
			if(num%5==0) {
				System.out.println("Es multiplo de 5");
				multiplo5++;
			}
			i++;
		}
		System.out.println("Has introducido "+ multiplo3 +" números multiples de 3 y "+ multiplo5 +" numeros multiplos de 5");
	}

}
