//Clase Camisa
//	-color
//	-precio
//	-talla
//	-[]Boton

package Ejercicio4Oo;

public class Camisa {

	private String color;
	private double precio;
	private String talla;
	private Boton[] botones;

	// Constructor
	public Camisa(String color, double precio, String talla, Boton[] botones) {
		super();
		this.color = color;
		this.precio = precio;
		this.talla = talla;
		this.botones = botones;
	}

	// Getter y setters

	public String getColor() {
		return color;
	}
	

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public Boton[] getBotones() {
		return botones;
	}

	public void setBoton(Boton[] botones) {
		this.botones = botones;
	}



}
