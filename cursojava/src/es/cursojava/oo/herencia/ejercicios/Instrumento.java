package es.cursojava.oo.herencia.ejercicios;

public class Instrumento {

	private String nombre;
	private String tipo;
	private boolean estaAfinado;

	// Constructor
	public Instrumento(String nombre, String tipo, boolean isAfinado) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.estaAfinado = estaAfinado;
	}


	//Getters y setters
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public boolean isEstaAfinado() {
		return estaAfinado;
	}



	public void setEstaAfinado(boolean estaAfinado) {
		this.estaAfinado = estaAfinado;
	}



	// Metodo afinar
	public void afinar() {
		System.out.println("Afinando instrumento " + this.nombre);
		if (Math.random() > 0.4) {
			estaAfinado = true;
			System.out.println("El instrumento " + this.nombre + " está afinado.");
		} else {
			estaAfinado = false;
			System.out.println("El instrumento " + this.nombre + " no está afinado");
		}
	}

	public void tocar() {
		System.out.println("Tocando instrumento " + nombre);
	}

}
