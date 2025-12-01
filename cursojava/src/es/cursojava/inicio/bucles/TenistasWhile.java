//8. Numero tenistas en el top 10 --> 
//+ Pedir por teclado la cantidad de tenistas que se apuntan a un torneo, 
//+ por cada uno de ellos preguntar en que puesto de la ATP se encuentran. 
//+ Indicar cuantos tenistas estarían entre los diez primeros.

package es.cursojava.inicio.bucles;

import java.util.Scanner;

public class TenistasWhile {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce la cantidad de tenistas: ");
		int cantidad = scan.nextInt();
		
		int contador=0;
		int i = 1;
		
		while(i<= cantidad) {
			System.out.println("Introduce el puesto de la ATP del tenista "+ i);
			int puesto = scan.nextInt();
			i++;
			if(puesto <=10) {
				contador++;
			
		}
}
		System.out.println("De los "+cantidad+" tenistas introducidos, "+contador+ " están entre los 10 primeros");
	}


}