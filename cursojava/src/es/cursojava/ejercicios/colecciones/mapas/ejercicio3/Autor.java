package es.cursojava.ejercicios.colecciones.mapas.ejercicio3;

import java.util.Objects;

public class Autor {

	private String nombre;
	private String nacionalidad;

	// Constructor
	public Autor(String nombre, String nacionalidad) {
		super();
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	// Metodo toString sobreescrito
	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", nacionalidad=" + nacionalidad + "]";
	}

	// Método hashCode sobreescrito
	@Override
	public int hashCode() {
		return Objects.hash(nacionalidad, nombre);
	}

	// Método equals sobreescrito
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(nacionalidad, other.nacionalidad) && Objects.equals(nombre, other.nombre);
	}
	
	

}
