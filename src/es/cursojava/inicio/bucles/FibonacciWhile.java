//7. Solicitar por consola el numero de números de la serie de Fibonacci que se quieren mostrar
//Serie de Fibonacci: 0,1,1,2,3,5,8,13,21,34,55,....
package es.cursojava.inicio.bucles;

import java.util.Scanner;

public class FibonacciWhile {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce la cantidad de números de la serie de Fibonacci que quieres que se muestren: ");
		int num = scan.nextInt();

		int num1 = 0;
		int num2 = 1;
		int i = 0;

		while (i < num) {
			System.out.println(num1);
			int suma = num1 + num2;
			num1 = num2;
			num2 = suma;

			i++;
		}
	}
}
