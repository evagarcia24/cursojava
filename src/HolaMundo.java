import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HolaMundo {

	private final static Logger log = LoggerFactory.getLogger(HolaMundo.class);
	//private final static Logger log = LoggerFactory.getLogger(HolaMundo.class); //Es lo mismo que lo de arriba
	
	public static void main(String[] args) {

//		log.error("Hola");
//		log.warn("Hola");
//		log.info("Hola");
		log.debug("Hola");
		log.trace("Hola");
		

		
		//Declarar una variable
		//Indico el tipo y el nombre de la variable (notación camelCase)
		int numero;//Declaración
		numero = 9;//Inicialización
		
		int edad = 24;//Declarar e inicialiazar
		
		//System.out.println("resultado: " + (numero + edad) );
		
		
		//System.out.println("Github");
	}

}
