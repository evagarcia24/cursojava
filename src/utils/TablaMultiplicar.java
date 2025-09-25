//En una clase 
//+ Escribe un método que pinte la tabla de multiplicar de un numero que le pases
//+ Escribe un método que pinte las tablas de multiplicar de los números que estén entre dos números que le pases
//+ Desde el main llamar a los dos métodos
package utils;

public class TablaMultiplicar {

	public static void main(String[] args) {
		multiplicar(4);
		multiplicarVarios(2, 6);
	}

	public static void multiplicar(int numero) {
		System.out.println("Tabla del " + numero + ":");
		for (int i = 1; i <= 10; i++) {
			System.out.println(numero + " * " + i + " = " + (numero * i));
		}
	}

	public static void multiplicarVarios(int numero1, int numero2) {
		System.out.println("\nTablas del " + numero1 + " al " + numero2 + ":\n");

		for (int i = numero1; i <= numero2; i++) {
			multiplicar(i);
//	        for (int j = 1; j <= 10; j++) {
//	            System.out.println(i + " * " + j + " = " + (i * j));
		}
	}
}
