//Clase Biblioteca
//Atributos: nombre, direccion, libros 
//Métodos:
//+ agregarLibro(Libro libro) para añadir un libro.
//+ mostrarLibros() para mostrar todos los libros.
//+ mostrarInfoBiblioteca() para mostrar dirección y libros.

package oo;

public class Biblioteca {
	
	//variables de instancia
	private String nombre;
	private Direccion direccion;
	private Libro[] libros;
	
	//Constructores
//	public Biblioteca (){
//		
//	}
			
	public Biblioteca(String nombre, Direccion direccion, Libro[] libros) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.libros = libros;
	}

	
	//Getters y setters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	public Libro[] getLibros() {
		return libros;
	}


	public void setLibros(Libro[] libros) {
		this.libros = libros;
	}

	//Metodos
	public void agregarLibro(Libro libro) {
	    if (libros == null) {
	        libros = new Libro[1];
	        libros[0] = libro;
	    } else {
	        Libro[] nuevosLibros = new Libro[libros.length + 1];
	        for (int i = 0; i < libros.length; i++) {
	            nuevosLibros[i] = libros[i];
	        }
	        nuevosLibros[libros.length] = libro;
	        libros = nuevosLibros;
	    }
	}

	
	public void mostrarLibros() {
	   
	        System.out.println("Libros disponibles:");
	        for (Libro libro : libros) {
	        	if(libro != null) {
	        		libro.mostrarInfo();
	        	}
	        
	    }
	}


	public void mostrarInfoBiblioteca() {
	    this.direccion.mostrarDireccion();
	    mostrarLibros();
	}

	
}
