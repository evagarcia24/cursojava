//Clase Libro
//Atributos: titulo, autor, isbn.
//Constructor y método mostrarInfo() --> Mostrará los datos del libro
package oo;

public class Libro {
	
	//Variables de instancia
	private String titulo;
	private String autor;
	private String isbn;
	
	//Constructor por defecto
//	public Libro() {
//		
//	}
		
	//Constructor con todos los parametros
	public Libro(String titulo, String autor, String isbn) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
	}
	
	//Getters y Setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	

	//Metodo mostrarInfo()
	public void mostrarInfo() {
		System.out.println("Titulo: " + this.titulo +". Autor: " + this.autor + ". ISBN: " + this.isbn);
		
	}
}
