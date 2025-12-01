package es.cursojava.lombok;

import lombok.AllArgsConstructor;

public class Bar {

	public static void main(String[] args) {
					
		Botella botella = new Botella(1000, "vidrio", "botella", "cerveza");
		System.out.println(botella);
		
		
		// Patron builder
		Botella b2 = Botella.builder().
				     capacidad(300).
				     material("reciclado").
				     forma("botella").
				     contenido("vino").
				     build();
		
		System.out.println(b2);
	}

}
