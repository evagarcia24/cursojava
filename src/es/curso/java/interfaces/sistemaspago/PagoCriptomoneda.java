package es.curso.java.interfaces.sistemaspago;

public class PagoCriptomoneda implements Pago {

	@Override
	public void procesarPago(double monto) {
		System.out.println("Pagado " + monto + " € con Criptomonedas");
		
	}

}
