//Preguntamos por un directorio
//Si existe 
//Nombre, tamaño y si es oculto (De cada fichero del directorio).

package es.cursojava.ejercicios.ficheros;

import java.io.File;

import es.cursojava.utils.Utilidades;

public class Ejercicio2 {

	public static void main(String[] args) {
		String ruta = Utilidades.pideDatoCadena("¿Qué directorio quieres ver?");
		File directorio = new File(ruta);

		if (directorio.exists() && directorio.isDirectory()) {
			File[] ficheros = directorio.listFiles();

			if (ficheros != null && ficheros.length > 0) {
				System.out.println("Contenido del directorio:");
				for (File fichero : ficheros) {
					if (fichero.isFile()) {
						System.out.println("Nombre: " + fichero.getName());
						System.out.println("Tamaño: " + fichero.length() + " bytes");
						System.out.println("¿Oculto?: " + (fichero.isHidden() ? "Sí" : "No"));
						System.out.println("---------------------------");
					}
				}
			} else {
				System.out.println("El directorio está vacío.");
			}
		} else {
			System.out.println("El directorio no existe o no es válido.");
		}
	}

}
