package es.cursojava.oo.herencia.ejercicios.hospital;

public class Habitacion {
	private int numero;
	private Enfermo enfermo;

	// Constructores
	public Habitacion(int numero, Enfermo enfermo) {
		super();
		this.numero = numero;
		this.enfermo = null; // Inicialmente vacía;
	}

	public Habitacion(int numero) {
		super();
		this.numero = numero;
	}

	// Getters y setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Enfermo getEnfermo() {
		return enfermo;
	}

	public void setEnfermo(Enfermo enfermo) {
		this.enfermo = enfermo;
	}

	// Metodo para que si en la habitacion no hay enfermo devuelva vacio
	public boolean estaVacia() {
		return enfermo == null;
	}

	public void asignarEnfermo(Enfermo enfermo) {
		this.enfermo = enfermo;
	}

}
