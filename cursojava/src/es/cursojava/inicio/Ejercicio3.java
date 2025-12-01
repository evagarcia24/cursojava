/*EJERCICIO 3
===============================================
Pedir dos numeros y pedir la operación que se quiere realizar ("suma o +", resta o - ,*,/)  nextLine
Mostrar el resultado de la operación con los dos números
*/
package es.cursojava.inicio;

import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un numero: ");
		int num1 = scan.nextInt();
		System.out.println("Introduce otro numero: ");
		int num2 = scan.nextInt();
		scan.nextLine();
		System.out.println("Introduce la operacion (+ , - , * , / )");
		String operacion = scan.nextLine();
		
		int resultado = 0;

		if (operacion.equals("+") || operacion.equalsIgnoreCase ("suma") ) {
			resultado = num1 + num2;
		} else if (operacion.equals("-") || operacion.equalsIgnoreCase ("resta"))  {
			resultado = num1 - num2;
		} else if (operacion.equals("*") || operacion.equalsIgnoreCase ("multiplicacion")) {
			resultado = num1 * num2;
		} else if (operacion.equals("/") ||  operacion.equalsIgnoreCase ("division")) {
			resultado = num1 / num2;
		} else {
			System.out.println("Elección no permitida");
		}
		System.out.println("En resultado es "+resultado);
	}
}
