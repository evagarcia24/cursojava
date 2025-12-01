package es.curso.java.interfaces.sistemaspago;

public class PagoPayPal implements Pago {

	@Override
	public void procesarPago(double monto) {
		System.out.println("Pagado " + monto + " € con PayPal");
		
	}

}
