//crear clase Alumno con los atributos: +nombre, +dni, +notaMedia, +asignaturas
//Crear método estudiar(){
//Debe mostrar:
//"El estudiante <nombre> tiene las asignaturas …
//y si notaMedia<5 ha estudiado poco
//  si notaMedia>5 ha estudiado mucho
//  si notaMedia>9 es un genio"
//}
//Crear clase Colegio en el main crear 3 alumnos y ponerlos a estudiar
//crear método estudiarAlumnos al que le pasais los 3 alumnos y se pone a todos a estudiar

package oo;

import java.util.Arrays;

public class Alumno {

	// variables de instancia
	private String nombre;
	private String dni;
	private double notaMedia;
	private String[] asignaturas;
	private int edad;


	// Constructor con nombre y dni
	public Alumno(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;

	}

	// Constructor con nombre, dni, nota
	public Alumno(String nombre, String dni, double notaMedia) {
		this.nombre = nombre;
		this.dni = dni;
		this.notaMedia = notaMedia;

	}

	// Constructor con todas las variables de instancia

	public Alumno(String nombre, String dni, double notaMedia, String[] asignaturas, int edad) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.notaMedia = notaMedia;
		this.asignaturas = asignaturas;
		this.edad = edad;
	}

	

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	public String[] getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(String[] asignaturas) {
		this.asignaturas = asignaturas;
	}

	// Sobreescritura de metodo toString:
	@Override
	public String toString() {
		return "Alumno: " + nombre + ", DNI: " + dni + ", Nota: " + notaMedia;
	}

	// Metodo estudiar
	public void estudiar() {
		if (notaMedia < 5) {
			System.out.println("El estudiante " + nombre + " tiene las asignaturas " + Arrays.toString(asignaturas)
					+ " ha estudiado poco");
		} else if (notaMedia >= 5 && notaMedia < 9) {
			System.out.println("El estudiante " + nombre + " tiene las asignaturas " + Arrays.toString(asignaturas)
					+ " ha estudiado mucho");
		} else if (notaMedia > 9) {
			System.out.println("El estudiante " + nombre + " tiene las asignaturas " + Arrays.toString(asignaturas)
					+ " es un genio");
		}

	}

}
