package es.cursojava.oo.herencia.ejercicios.hospital;

public class Paciente extends Persona {
	private String[] sintomas;

	// Constructor
	public Paciente(String nombre, int edad, String[] sintomas) {
		super(nombre, edad);
		this.sintomas = sintomas;
	}

	// Getter y setter
	public String[] getSintomas() {
		return sintomas;
	}

	public void setSintomas(String[] sintomas) {
		this.sintomas = sintomas;
	}

	// Método comer sobreescrito
	@Override
	public void comer() {
		System.out.println("Paciente " + this.getNombre() + " comiendo en la cafetería");
	}

}
