package es.cursojava.oo.herencia.ejercicios.hospital;

import java.util.Random;

public class Doctor extends EmpleadosHospital {
	private String especialidad;

	// Constructor
	public Doctor(String nombre, int edad, String turno, String especialidad) {
		super(nombre, edad, turno);
		this.especialidad = especialidad;
	}

	// Getter y Setter
	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	// Método para diagnosticar a un paciente
	public Enfermo diagnosticarPaciente(Paciente paciente) {
		// Generar número aleatorio 1-10
		int gravedad = (int) (Math.random() * 10) + 1;

		System.out.println("Doctor " + this.getNombre() + " diagnosticando a " + paciente.getNombre());
		System.out.println("Gravedad: " + gravedad);

		if (gravedad > 8) {
			// Paciente está enfermo, crear objeto Enfermo
			Enfermo enfermo = new Enfermo(paciente.getNombre(), paciente.getEdad(), "Enfermedad");
			System.out.println("El paciente " + paciente.getNombre() + " está enfermo y debe ingresar");
			return enfermo;
		} else {
			System.out.println("El paciente " + paciente.getNombre() + " no está enfermo, puede irse");
			return null;
		}
	}
}
