package es.cursojava.inicio.bucles;

import java.util.Scanner;

public class TablasMultiplicarWhile {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número: ");
		int num = scan.nextInt();

		int i = 1;
		while (i <= num) {
			System.out.println("\nTabla del " + i + ":");
			int j = 1;
			while (j <= 10) {
				System.out.println(i + " * " + j + " = " + (i * j));
				j++;
			}
			System.out.println();
			i++;
		}
	}
}