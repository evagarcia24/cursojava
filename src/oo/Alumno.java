package oo;

import java.util.Arrays;
import es.cursojava.excepciones.NotaInvalidaException;

public class Alumno {

	// variables de instancia
	private String nombre;
	private double notaMedia;
	private int edad;

	public Alumno(String nombre, double notaMedia, int edad) throws NotaInvalidaException {
		if (edad <= 0) {
	        throw new IllegalArgumentException("Error. La edad debe ser mayor que 0.");
	    }

	    if (notaMedia < 0 || notaMedia > 10) {
	        throw new NotaInvalidaException("Error. La nota debe estar entre 0 y 10.");
	    }

	    this.nombre = nombre;
	    this.notaMedia = notaMedia;
	    this.edad = edad;
	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	// Sobreescritura de metodo toString:
	@Override
	public String toString() {
		return "Alumno: " + nombre + ", Edad: " + edad + ", Nota Media: " + notaMedia;
	}

}
