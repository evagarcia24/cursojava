//Crea un paquete llamado tienda en ejercicios.- OK
//Dentro del paquete tienda, crea una clase Producto con los siguientes atributos privados: - OK
//+String nombre - OK
//+double precio - OK
//+int cantidad - OK
//Implementa un constructor que reciba los tres atributos.- OK
//Añade los siguientes métodos en Producto:
//+ mostrarInfo() → muestra en consola los datos del producto. - OK
//+ calcularValorTotal() → devuelve el valor total (precio * cantidad).
//Crea una clase auxiliar llamada UtilidadesTienda con un método estático:
//+ calcularValorInventario(Producto[] productos) → recibe un array de productos y devuelve el valor total del inventario.
//En una clase llamada Tienda con main:
//Crea al menos 3 objetos Producto usando el constructor.
//Guarda los objetos en un array de productos.
//Muestra la información de cada producto.
//Calcula y muestra el valor total del inventario usando el método estático.

package es.cursojava.inicio.oo.ejercicios.tienda;


public class Producto {
	
	private String nombre;
	private double precio;
	private int cantidad;
	
	//Constructor
	public Producto(String nombre, double precio, int cantidad) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	

	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public void mostrarInfo() {
        System.out.println("Producto: " + this.nombre + ". Precio: " + this.precio + ". Cantidad: " + cantidad); //No es obligatorio poner el this


    }

    public double calcularValorTotal() {
        return this.precio * this.cantidad; //No es obligatorio poner el this
    }


}
