package es.cursojava.oo.herencia.ejercicios;

public class Tambor extends Instrumento {

	private String material;

	//Constructor
	public Tambor(String nombre, String tipo, boolean isAfinado, String material) {
		super(nombre, tipo, isAfinado);
		this.material = material;
	}
	
	
	//Getter y setter
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	

	
}
