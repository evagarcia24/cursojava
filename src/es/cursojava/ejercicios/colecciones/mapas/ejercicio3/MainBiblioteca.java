package es.cursojava.ejercicios.colecciones.mapas.ejercicio3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainBiblioteca {

	public static void main(String[] args) {
		
		Exception exc = new Exception();
		
		Autor autor1 = new Autor("NombreAutor1", "Española");
		Autor autor2 = new Autor("NombreAutor2", "Cubana");
		Autor autor3 = new Autor("NombreAutor3", "Inglesa");
		Autor autor4 = new Autor("NombreAutor4", "Francesa");
				
		Libro libro1 = new Libro("Titulo1", "isbn1", 1980);
		Libro libro2 = new Libro("Titulo2", "isbn2", 1981);
		Libro libro3 = new Libro("Titulo3", "isbn3", 1982);
		Libro libro4 = new Libro("Titulo4", "isbn4", 2000);
		Libro libro5 = new Libro("Titulo5", "isbn5", 2001);
		Libro libro6 = new Libro("Titulo6", "isbn6", 2002);
		Libro libro7 = new Libro("Titulo7", "isbn7", 2010);
		Libro libro8 = new Libro("Titulo8", "isbn8", 2011);
		Libro libro9 = new Libro("Titulo9", "isbn9", 2012);
		
		Map<Autor, List<Libro>> biblioteca = new HashMap<>();
		

		List<Libro> librosAutor1 = new ArrayList<>();
		librosAutor1.add(libro1);
		librosAutor1.add(libro2);
		librosAutor1.add(libro3);

		List<Libro> librosAutor2 = new ArrayList<>();
		librosAutor2.add(libro4);
		librosAutor2.add(libro5);
		librosAutor2.add(libro6);

		List<Libro> librosAutor3 = new ArrayList<>();
		librosAutor3.add(libro7);

		List<Libro> librosAutor4 = new ArrayList<>();
		librosAutor4.add(libro8);
		librosAutor4.add(libro9);
		
		biblioteca.put(autor1, librosAutor1);
		biblioteca.put(autor2, librosAutor2);
		biblioteca.put(autor3, librosAutor3);
		biblioteca.put(autor4, librosAutor4);

		// mostrar las nacionalidades de los autores		
		System.out.println("Nacionalidades de los autores:");
		System.out.println("\n");
		for (Autor autor : biblioteca.keySet()) {
		    System.out.println("\t" + autor.getNacionalidad());
		}


		

// mostrar el título de todos los libros publicados después del 2010
		System.out.println("\nLibros publicados después del 2010:");
		System.out.println("\n");

		for (Map.Entry<Autor, List<Libro>> entry : biblioteca.entrySet()) {
		    Autor autor = entry.getKey();
		    List<Libro> libros = entry.getValue();

		    for (Libro libro : libros) {
		        if (libro.getAnio() > 2010) {
		            System.out.println("\t" + libro.getTitulo() +" - "+ autor.getNombre() +" - "+ libro.getAnio());
		        }
		    }
		}

		
		
		
// mostrar por cada autor que tenga más de dos libros su nombre y el nombre de todos los libros q tiene publicados
// Solicitar los datos de un libro, autor, 	titulo, isbn y año de publicación, 
		//	- si el autor no está en la biblioteca, solicitar la nacionalidad del autor y meterlo en la biblioteca, 
		//	- si el autor sí está ya, agregar el libro a su listado	
// Solicitar un isbn, si algún libro tiene ese isbn hay que eliminarlo		
		
		
	}

}
