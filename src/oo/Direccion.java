//Clase Dirección
//Atributos: calle, ciudad, codigoPostal.
//Constructor y método mostrarDireccion().


package oo;

public class Direccion {
	
	private String calle;
	private String ciudad;
	private int codigoPostal;
	
	
	//Constructores
//	public Direccion() {
//		
//	}
		
	public Direccion(String calle, String ciudad, int codigoPostal) {
		this.calle = calle;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
	}
	
	
	//Getters y setters
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
		
	//metodo mostrarDireccion
	public void mostrarDireccion() {
		System.out.println("Calle: " + this.calle +". Ciudad: " + this.ciudad + ". Código postal: " + this.codigoPostal);
	}

}
