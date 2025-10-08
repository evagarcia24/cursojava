package es.cursojava.interfaces;

public class ClaseInterfaces implements Interfaz1 {

	@Override
	public int metodo3() {
		System.out.println("Método 3");
		return 0;
	}

	@Override
	public String metodo4(int numero) {
		System.out.println("Método 4");
		return null;
	}

	@Override
	public void metodo1() {
		System.out.println("Método 1");

	}

	@Override
	public void metodo2(String nombre) {
		System.out.println("Método 2");

	}

}
