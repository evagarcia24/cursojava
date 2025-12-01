//Clase Vestido
//	-color
//	-precio
//	-talla

package Ejercicio4Oo;

public class Vestido {

	private String color;
	private double precio;
	private String talla;


	// Constructor
	public Vestido(String color, double precio, String talla) {
		super();
		this.color = color;
		this.precio = precio;
		this.talla = talla;
	
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


}
