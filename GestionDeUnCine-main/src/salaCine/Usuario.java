package salaCine;

public class Usuario {

	private String nombre;
	private String dni;
	private int edad;
	private int entradas;

	public Usuario(String nombre, String dni, int edad, int numeroDeEntradas) {
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.entradas = numeroDeEntradas;
	}

	public int getEntradas() {
		return entradas;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	
}
