package es.cursojava.oo.herencia.ejercicios.hospital;

public class EmpleadosHospital extends Persona {
	private String turno;

	// Constructor
	public EmpleadosHospital(String nombre, int edad, String turno) {
		super(nombre, edad);
		this.turno = turno;
	}

	// Getters y setters
	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	// Metodo sobreescrito comer
	@Override
	public void comer() {
		System.out.println("Empleado " + this.getNombre() + " comiendo en el comedor");
	}

	public void fichar() {
		System.out.println("El empleado " + this.getNombre() + " está fichando");
	}

}