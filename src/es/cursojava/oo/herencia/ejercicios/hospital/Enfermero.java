package es.cursojava.oo.herencia.ejercicios.hospital;

public class Enfermero extends EmpleadosHospital {
	private String planta;

	// Constructor
	public Enfermero(String nombre, int edad, String turno, String planta) {
		super(nombre, edad, turno);
		this.planta = planta;
	}

	// Gtter y setter
	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	// Metodo atender paciente
	public void atenderPaciente(Paciente paciente) {
		System.out.println("Enfermero " + this.getNombre() + " atendiendo a " + paciente.getNombre());
	}
}
