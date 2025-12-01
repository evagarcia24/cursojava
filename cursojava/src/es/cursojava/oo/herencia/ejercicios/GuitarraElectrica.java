package es.cursojava.oo.herencia.ejercicios;

public class GuitarraElectrica extends Guitarra {
	
	private String potencia;

	//Constructor
	public GuitarraElectrica(String nombre, String tipo, boolean isAfinado, int numCuerdas, String potencia) {
		super(nombre, tipo, isAfinado, numCuerdas);
		this.potencia = potencia;
	}

	//Getter y setter
	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}
	

	
	

}
