package es.cursojava.oo.herencia.ejercicios.hospital;

public class Hospital {
	private String nombre;
	private Habitacion[] habitaciones; // Array de 2 habitaciones
	private Paciente[] salaDeEspera; // Array de 3 pacientes
	private Enfermero enfermero;
	private Doctor doctor;

	// Constructor Hospital
	public Hospital(String nombre) {
		this.nombre = nombre;
		this.habitaciones = new Habitacion[2];
		this.salaDeEspera = new Paciente[3];
	}

	// Main
	public static void main(String[] args) {
		Hospital hospital = new Hospital("Hospital General");

		hospital.abrirHospital();
		hospital.ficharEmpleados();
		hospital.horaDeComer();
		hospital.pasarConsultas();
	}

	//Método abris hospital
	public void abrirHospital() {
		System.out.println("=== ABRIENDO HOSPITAL " + nombre + " ===");

		// Crear 2 habitaciones
		habitaciones[0] = new Habitacion(101);
		habitaciones[1] = new Habitacion(102);

		// Crear 3 pacientes y meterlos en sala de espera
		salaDeEspera[0] = new Paciente("Manuel", 25, new String[] { "dolor" });
		salaDeEspera[1] = new Paciente("Maria", 30, new String[] { "tos" });
		salaDeEspera[2] = new Paciente("Pedro", 45, new String[] { "desmayo" });

		// Crear empleados
		enfermero = new Enfermero("Iván", 28, "mañana", "planta 1");
		doctor = new Doctor("Dr. Garcia", 40, "mañana", "medicina general");

		System.out.println("Hospital abierto con 2 habitaciones, 3 pacientes, 1 enfermero y 1 doctor");
	}

	// Metodo fichar empleados
	public void ficharEmpleados() {
		System.out.println("\n=== FICHANDO EMPLEADOS ===");
		enfermero.fichar();
		doctor.fichar();
	}

	// Metodo hora de comer
	public void horaDeComer() {
		System.out.println("\n=== HORA DE COMER ===");
		// Todos comen: empleados, pacientes en espera, enfermos en habitaciones
		enfermero.comer();
		doctor.comer();

		// Pacientes en sala de espera
		for (Paciente paciente : salaDeEspera) {
			if (paciente != null) {
				paciente.comer();
			}
		}

		// Enfermos en habitaciones
		for (Habitacion habitacion : habitaciones) {
			if (!habitacion.estaVacia()) {
				habitacion.getEnfermo().comer();
			}
		}
	}

	// Metodo pasar consultas
	public void pasarConsultas() {
		System.out.println("\n=== PASANDO CONSULTAS ===");

		for (int i = 0; i < salaDeEspera.length; i++) {
			Paciente paciente = salaDeEspera[i];

			if (paciente != null) {
				System.out.println("Atendiendo a " + paciente.getNombre());

				// Enfermero atiende al paciente
				enfermero.atenderPaciente(paciente);

				// Sacar al paciente de la sala de espera
				salaDeEspera[i] = null;

				// Doctor diagnostica
				Enfermo enfermo = doctor.diagnosticarPaciente(paciente);

				if (enfermo != null) {
					// Buscar habitación vacía
					boolean habitacionEncontrada = false;
					for (Habitacion habitacion : habitaciones) {
						if (habitacion.estaVacia()) {
							habitacion.asignarEnfermo(enfermo);
							System.out.println("Enfermo ingresado en habitación " + habitacion.getNumero());
							habitacionEncontrada = true;
							break;
						}
					}

					if (!habitacionEncontrada) {
						System.out.println("No hay habitacion libre para " + enfermo.getNombre() + ". Busque otro hospital!!");
					}
				}
			}
		}

		System.out.println("\n=== CONSULTAS TERMINADAS ===");
	}
}
