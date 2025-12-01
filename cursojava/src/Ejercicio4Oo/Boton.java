//Clase Boton
//	-color
//	-tamanio
//	-forma

package Ejercicio4Oo;

public class Boton {

	private String color;
	private String tamanio;
	private String forma;

	// Constructor
	public Boton(String color, String tamanio, String forma) {
		super();
		this.color = color;
		this.tamanio = tamanio;
		this.forma = forma;
	}

	// Getters y Setters

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

}
