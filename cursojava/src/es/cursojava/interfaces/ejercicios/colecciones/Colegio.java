// Crear clase Colegio con:
//	  nombre, direccion, Map<"String",List<Alumno>> aulas		 	
// Crear 3 colegios -> Meterlos en una lista y:
//	  + recorrer la lista de colegios para mostrar los datos de cada colegio, el nombre de cada aula del colegio y por cada aula, el nombre, 
//    el apellido y la nota media de sus alumnos
//	   + Indicar cual es el colegio que tiene la nota media de alumnos mayor.

package es.cursojava.interfaces.ejercicios.colecciones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oo.Alumno;



public class Colegio {

	private String nombre;
	private String direccion;
	private Map<String, List<Alumno>> aulas;

	// Constructores
	public Colegio(String nombre, String direccion, Map<String, List<Alumno>> aulas) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.aulas = aulas;
	}

	public Colegio(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.aulas = new HashMap<>();
	}

	// Getterrs y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Map<String, List<Alumno>> getAulas() {
		return aulas;
	}

	public void setAulas(Map<String, List<Alumno>> aulas) {
		this.aulas = aulas;
	}

	// Metodo toString sobreescrito
	@Override
	public String toString() {
		return "Colegio [nombre=" + nombre + ", direccion=" + direccion + ", aulas=" + aulas + "]";
	}

}
