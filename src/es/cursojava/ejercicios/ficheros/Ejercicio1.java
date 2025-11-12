//Ficheros FILE: 
//Crear en la carpeta Ficheros:
//Crear el directorio llamado ‘Imágenes’. OK
//Crear el directorio llamado ‘Documentos’. OK
//Crear el directorio llamado ‘Otros’. OK
//
//Preguntar por 5 nombres de ficheros. OK
//    Si el fichero tiene la extensión de una imagen (.gif - .jpg - .png) lo vas a crear en la carpeta de imágenes. OK
//    Si el fichero es un .txt en documentos. OK
//    Si no es una imagen y no es un documento lo añadirán en otros. OK 
//
//Coger todos los ficheros que están en el directorio de otros, renombrarlos con nuestro nombre y con un contador para clasificar los archivos.

package es.cursojava.ejercicios.ficheros;

import java.io.File;
import java.io.IOException;

import es.cursojava.excepciones.Utilidades;

public class Ejercicio1 {

	public static void main(String[] args) {

		File directorio = new File("C:\\Users\\Tardes\\Ficheros");
		File fichero = new File("C:\\Users\\Tardes\\Ficheros\\fichero1.txt");

		String[] subDirs = { "Imagenes", "Documentos", "Otros" };
		for (String nombre : subDirs) {
			File subDir = new File(directorio, nombre);
			subDir.mkdir();
		}

		for (int i = 0; i <= 4; i++) {

			String nombreFichero = Utilidades.pideDatoCadena("Introduce el nombre con extensión del fichero " + (i + 1) + ": ");
			if (nombreFichero.endsWith(".gif") || nombreFichero.endsWith(".jpg") || nombreFichero.endsWith(".png")) {
				File fichero1 = new File("C:\\Users\\Tardes\\Ficheros\\Imagenes", nombreFichero);
				try {
					fichero1.createNewFile();
					System.out.println("Creado correctamente y guardado en Carpeta Imagenes");
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else if (nombreFichero.endsWith(".txt")) {
				File fichero1 = new File("C:\\Users\\Tardes\\Ficheros\\Documentos", nombreFichero);
				try {
					fichero1.createNewFile();
					System.out.println("Creado correctamente y guardado en Carpeta Documentos");
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else {
				File fichero1 = new File("C:\\Users\\Tardes\\Ficheros\\Otros", nombreFichero);
				try {
					fichero1.createNewFile();
					System.out.println("Creado correctamente y guardado en Carpeta Otros");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		File directorioOtros = new File("C:\\Users\\Tardes\\Ficheros\\Otros");
		File[] ficherosOtros = directorioOtros.listFiles();
		int contador = 0;

	}

}
