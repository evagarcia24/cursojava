package es.cursojava.ficheros;

import java.io.IOException;

public class LeerArchivo {
	

    public static void main(String[] args) {
    	String nombreArchivo = "./recursos/application.log";
        ArchivoServicio servicio = new ArchivoServicio();
		LeerArchivo ejemplo = new LeerArchivo();
		
		

		//System.out.println(servicio.leerArchivo2(nombreArchivo));
        try {
			System.out.println(servicio.leerArchivo3(nombreArchivo));
		} catch (IOException e) {
			// TODO Auto-generated catch block//
			e.printStackTrace();
		}
    }
    
    //No se hacerlo, y los siguientes pasos tampoco
}