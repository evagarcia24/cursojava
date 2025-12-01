package es.curso.java.interfaces.sistemaspago;

public class PagoTarjetaCredito implements Pago {

	@Override
	public void procesarPago(double monto) {
		System.out.println("Pagado " + monto + " € con tarjeta de crédito");
		
	}

	
}
