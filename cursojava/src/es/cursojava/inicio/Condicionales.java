package es.cursojava.inicio;

public class Condicionales {

	public static void main(String[] args) {
		int numero = (int)(Math.random()*10);
		System.out.println(numero);
		
		if (numero>=5) {
			System.out.println("El numero es mayor de 5");
		}else if (numero >= 5 && numero < 7){
			System.out.println("El numero es mayor de 5 y menor de 7");
		}else if (numero >=2 || numero<5) {
			System.out.println("El numero es");
		
		}else {
			System.out.println("El numero es menor de 5");
		}

	}

}
