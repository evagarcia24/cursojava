package es.cursojava.oo.herencia.ejercicios;

public class Guitarra extends Instrumento {

	private int numCuerdas;

	//Constructor
	public Guitarra(String nombre, String tipo, boolean isAfinado) {
		super(nombre, tipo, isAfinado);
		this.numCuerdas = numCuerdas;
	}
	
	public Guitarra(String nombre, String tipo, boolean isAfinado, int numCuerdad) {
		super(nombre, tipo, isAfinado);
		this.numCuerdas = numCuerdas;
	}

	//Getter y setter
	public int getNumCuerdas() {
		return numCuerdas;
	}

	public void setNumCuerdas(int numCuerdas) {
		this.numCuerdas = numCuerdas;
	}
	
	//Metodo afinar para guitarra
	public void afinar() {
		
		super.afinar();
		System.out.println("afinando guitarra");
	}
	
}
