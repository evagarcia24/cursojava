package es.cursojava.inicio.oo.ejercicios.tienda;

public class Tienda {

	public static void main(String[] args) {
		
		Producto producto1 = new Producto("Lavadora", 299.99, 10);
		Producto producto2 = new Producto("Nevera", 599.99, 5);
		Producto producto3 = new Producto("Horno", 199.99, 25);
		
		Producto[] productos = {producto1, producto2, producto3};
		
		   for (Producto productosTotales : productos) {
			   productosTotales.mostrarInfo();
	        }
		
		double total = UtilidadesTienda.calcularValorInventario(productos);
		System.out.println("Valor total: " + total + " €.");
	}

}

