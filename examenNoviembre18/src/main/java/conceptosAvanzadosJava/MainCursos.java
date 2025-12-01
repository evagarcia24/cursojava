package conceptosAvanzadosJava;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Scanner;

public class MainCursos {

	public static void main(String[] args) {

		// Creacion de 3 masters
		CursoImpl master1 = new CursoImpl("Excel Avanzado", "111AA", 20);
		CursoImpl master2 = new CursoImpl("Big Data", "222BB", 10);
		CursoImpl master3 = new CursoImpl("Automatizacion N8N", "333CC", 5);

		// Guardar los masters en una lista
		List<CursoImpl> listaMaster = new ArrayList();
		listaMaster.add(master1);
		listaMaster.add(master2);
		listaMaster.add(master3);
		
		// Muestra la lista inicial de Masters
		System.out.println("Muestra ek listado inicial de Masters antes de eliminar ninguno:");
		System.out.println(listaMaster);
		System.out.println("==========================");

		// Eliminar un master por su codigo
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el codigo del master que quieres eliminar de la lista: ");
		String codigoBuscado = sc.nextLine();

		for (CursoImpl curso : listaMaster) {

			if (curso.getCodigo().equals(codigoBuscado)) {

				try{
					listaMaster.remove(curso);
				}catch(ConcurrentModificationException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Master con codigo: " + codigoBuscado + " eliminado");
			}
		}

		// Mostrar el nombre de todos los master
		System.out.println(listaMaster);

	}
}
