package es.cursojava.excepciones;

import java.util.Scanner;

public class PideDatoCadena{

public static String pideDatoCadena (String texto) {
	String dato="";
	System.out.println(texto);
	Scanner scan = new Scanner(System.in);
	dato = scan.nextLine();
	
	return dato;
}

}