package es.cursojava.inicio.bucles;

public class CalculadoraMain {

	public static void main(String[] args) {

		if(args.length<3) {
			System.err.println("Necesarios minimo 3 datos (operación y números )");
		}else {
			System.out.println("Numero de argumentos correcto "+ args.length);
		}
		
		
		
		String operacion = args[0];
		System.out.println("Se va a realizar la operacion " + "de: ");
		
		for (int i = 1; i < args.length; i++) {
			
			System.out.println(args[i]);
			
		}
		int num1 = Integer.parseInt(args[1]);
		int num2 = Integer.parseInt(args[2]);
		int resultado = 0;

		switch (operacion) {
		case "+":
			resultado = num1 + num2;
			break;
		case "-":
			resultado = num1 - num2;
			break;
		case "*":
			resultado = num1 * num2;
			break;
		default:
			System.out.println("Operador no válido. Usa: + , - o *");
			break;
		}

		System.out.println("Resultado: " + resultado);
	}
}
