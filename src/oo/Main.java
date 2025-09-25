//Clase Main
//Crea un objeto Biblioteca (Suponemos que en la biblioteca caben 10 libros como mucho) con una dirección.
//Agrega al menos 3 libros.
//Muestra la información completa de la biblioteca.
//Muestra los libros que tiene la biblioteca

package oo;

public class Main {

	public static void main(String[] args) {
		
		//Crear 3 libros
		Libro libro1 = new Libro("El Ocho", "Katherine Neville", "8417841111111");
		Libro libro2 = new Libro("La Catedral del Mar", "Ildefonso Falcones", "8759902222222");
		Libro libro3 = new Libro("El Quijote", "Cervantes", "1111222233334");

		// Crear dirección
		Direccion direccion = new Direccion("Calle A", "Madrid", 28013);

		// Crear array de libros con capacidad para 10
		Libro[] libros = new Libro[0]; // Inicialmente vacío

		// Crear biblioteca
		Biblioteca biblioteca = new Biblioteca("Biblioteca C.M.", direccion, libros);

		// Agregar libros
		biblioteca.agregarLibro(libro1);
		biblioteca.agregarLibro(libro2);
		biblioteca.agregarLibro(libro3);

		// Mostrar información completa
		biblioteca.mostrarInfoBiblioteca();

		// Mostrar solo los libros
		System.out.println("Listado de libros:");
		biblioteca.mostrarLibros();
			}
		}
