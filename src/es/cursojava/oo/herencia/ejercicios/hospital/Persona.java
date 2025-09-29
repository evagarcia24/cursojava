package es.cursojava.oo.herencia.ejercicios.hospital;

public abstract class Persona {
	private String nombre;
	private int edad;

	// Constructor
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	// Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	// Metodo comer vacio segun enunciado
	public abstract void comer();
	
}