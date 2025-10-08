package es.curso.java.interfaces.sistemaspago;

public class Main {

	public static void main(String[] args) {

		ProcesadorPagos procesador = new ProcesadorPagos();

		Pago pagoTarjeta = new PagoTarjetaCredito();
		Pago pagoPayPal = new PagoPayPal();
		Pago pagoCripto = new PagoCriptomoneda();

		procesador.realizarPago(pagoTarjeta, 100.5);
		procesador.realizarPago(pagoPayPal, 250.5);
		procesador.realizarPago(pagoCripto, 5000.50);
		

	}
	
	
}
