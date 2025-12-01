//6. Conjetura Collatz
//Solicitar un numero:
//+Si el numero es par, se divide entre dos
//+Si es impar se multiplica por 3 y se le suma 1
//se repite hasta que el valor del numero es 1

package es.cursojava.inicio.bucles;

import java.util.Scanner;

public class ConjeturaCollatzFor {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un numero: ");
		int num = scan.nextInt();

		for (int i = 1; i < num; i++) {
			if (num % 2 == 0) {
				num /= 2;
				System.out.println(num);
			} else {
				num = num * 3 + 1;
				System.out.println(num);
			}
		}

	}

}
