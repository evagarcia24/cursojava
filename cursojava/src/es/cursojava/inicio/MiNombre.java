package es.cursojava.inicio;

public class MiNombre {
	public static void main(String[] args) {
		String nombre = "Eva";
		int edad = 42;
	
		System.out.println("Mi nombre es "+ nombre +" y mi edad es " + edad +" años");
		if (edad >= 18){
			System.out.println("Eres mayor de edad");
		}else {
				System.out.println("Eres menor de edad");
			}
		}
	}

