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

public class Ejercicio4 {
	public static void main(String[] args) {
		System.out.println("1. Pintar Cuadrado");
		System.out.println("2. Validar email");
		System.out.println("3. Añadir Alumno");
		System.out.println("4. Salir\n");

		System.out.println("Elige la opcion que prefieras: ");
		Scanner scan = new Scanner(System.in);
		int opcion = scan.nextInt();

		if (opcion == 1) {
			System.out.println("Ha elegido 'Pintar cuadrado'");
			System.out.println("Elige el tamaño de los lados del cuadrado:");
			int lados = scan.nextInt();

			for (int i = 1; i <= lados; i++) {
				for (int j = 1; j <= lados; j++) {
					System.out.print("* "); // Columnas
				}
				System.out.println(); // Filas
			}

		} else if (opcion == 2) {
			System.out.println("Ha elegido 'Validar email'");
		} else if (opcion == 3) {
			System.out.println("Ha elegido 'Añadir Alumno'");
		} else if (opcion == 4) {
			System.out.println("Adios!");
		} else {
			System.out.println("Se ha equivocado, elija una opcion correcta!");
		}
	}

}
