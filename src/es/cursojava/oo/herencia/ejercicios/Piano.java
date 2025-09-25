package es.cursojava.oo.herencia.ejercicios;

public class Piano extends Instrumento {
	
	private int numeroOctavas;
	private String tipoPiano;
	
	//Constructor
	public Piano(String nombre, String tipo, boolean isAfinado, int numeroOctavas, String tipoPiano) {
		super(nombre, tipo, isAfinado);
		this.numeroOctavas = numeroOctavas;
		this.tipoPiano = tipoPiano;
	}

	
	//Getters y setters
	public int getNumeroOctavas() {
		return numeroOctavas;
	}

	public void setNumeroOctavas(int numeroOctavas) {
		this.numeroOctavas = numeroOctavas;
	}

	public String getTipoPiano() {
		return tipoPiano;
	}

	public void setTipoPiano(String tipoPiano) {
		this.tipoPiano = tipoPiano;
	}
	
	
	

}
