package metodos;

public class EjemplosMetodos {

	public static void main(String[] args) {
		System.out.println("Empieza");
		metodo1();
		metodo2("Eva");
		System.out.println("Termina");
		Metodos.saludar("Eva");
	}
	public static void metodo1 () { //Este metodo no tiene parametros
		System.out.println("Llamado metodo1");
	}
	
	public static void metodo2 (String nombre) { //Este metodo si tiene parametros
		System.out.println(nombre);
	}
	
	public static void metodo3 (int numero) { //Este metodo no tiene parametros
		System.out.println(numero);
		numero = 7;
		System.out.println(numero);
	}
}
