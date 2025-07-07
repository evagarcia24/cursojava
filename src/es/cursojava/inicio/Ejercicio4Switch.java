/*EJERCICIO 4
===============================================
Pintar menu
1. Pintar Cuadrado
2. Validar email
3. Añadir Alumno
4. Salir
Elige una opción
Se pide la opción por teclado, dependiendo de la opción introducida le indicamos la que ha 
seleccionado, si selecciona la 4 le decimos "Adios!" y si no es ninguna de las que existe que 
se ha equivocado
*/
package es.cursojava.inicio;

import java.util.Scanner;


public class Ejercicio4Switch {

	public static void main(String[] args) {
			System.out.println("1. Pintar Cuadrado\n2. Validar email\n3. Añadir Alumno\n4. Salir\n");
			
			System.out.println("Elige una opcion: ");
			Scanner scan = new Scanner (System.in);
			int opcion = scan.nextInt();
			
			switch (opcion) {
			case 1: System.out.println("Has elegido la opcion 'Pintar Cuadrado'");
					break;
			case 2: System.out.println("Has elegido la opcion 'Validar email'");
					break;
			case 3: System.out.println("Has elegido la opcion 'Añadir Alumno'");
					break;
			case 4: System.out.println("Adios!");
					break;
			default: System.out.println("Opcion incorrecta");
					break;
			}

	}

}
