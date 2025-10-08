package es.curso.java.interfaces.sistemaspago;

public class ProcesadorPagos {
    
	public void realizarPago(Pago metodoPago, double monto) {
        metodoPago.procesarPago(monto);
    }
}

