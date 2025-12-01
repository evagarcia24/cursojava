package es.cursojava.inicio;

import java.util.Scanner;

public class ParImpar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero: ");
		int numero = sc.nextInt();

		if (numero % 2 == 0) {
			System.out.println("El numero " + numero + " es par");
		} else {
			System.out.println("El numero " + numero + " es impar");
		}
	}
}

/*
 * //OTRA FORMA
 * boolean resultadoCero = numero%2==0;
 * if(!resultadoCero) {
 * 		System.out.println("El numero "+numero+" es impar");
 * }else {
 * System.out.println("El numero "+numero+" es par"); } }
 */