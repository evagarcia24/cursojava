package es.cursojava.oo.herencia.ejercicios.hospital;

public class Enfermo extends Persona {

	private String enfermedad;

	public Enfermo(String nombre, int edad, String enfermedad) {
		super(nombre, edad);
		this.enfermedad = enfermedad;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	// Metodo comer sobreescrito
	@Override
	public void comer() {
		System.out.println("Enfermo " + Persona.class + " comiendo en la habitación");
	}

}
