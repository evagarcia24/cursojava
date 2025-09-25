//Clase Tienda
//	-nombre
//	-Constructor
//
//	-main()
//		Llamo a 
//		1)abrirTienda()
//		2)mostrarEscaparate()
//		3)cerrarTienda()
//	
//	- abrirTienda() --> Donde se van a generar todos los objetos
//		+3 Objetos de tipo Maniqui (2 vestidos y 1 sin vestir)
//	- vestirManiquies () --> vestir maniquies (solo vestirá aquellos que están completamente desnudos)
//	- mostrarEscaparate() --> Mostrar la información de cada maniqui y el precio total de la ropa que llevan
//	- cerrarTienda() --> Indicar que cierra la tienda y desvestir a los maniquies
package Ejercicio4Oo;

public class TiendaManiqui {
	
	private String nombre;
	private Maniqui[] maniquies;
	
	//Constructor
	public TiendaManiqui(String nombre, Maniqui[] maniquies) {
		super();
		this.nombre = nombre;
		this.maniquies = maniquies;
		
	}

	public static void main(String[] args) {
		
		
		}
	
	public void abrirTienda() {
		Boton boton1 = new Boton("Blanco", "Pequeño", "Redondo");
		Boton boton2 = new Boton("Negro", "Grande", "Redondo");
		Boton [] botones = {boton1, boton2};
		Pantalon pantalon1 = new Pantalon("Negro", 9.99, "Mediana", boton1);
		Camisa camisa1 = new Camisa("Azul", 4.99, "Grande", botones);
		Vestido vestido1 = new Vestido("Rojo", 14.99, "Pequeña");			
		
		Maniqui maniquiVestidoConVestido = new Maniqui (1, vestido1);
		Maniqui maniquiVestidoPantalonCamisa = new Maniqui (2, pantalon1, camisa1);
		Maniqui maniquiSinVestir = new Maniqui (3);
		
		Maniqui [] maniquies = {maniquiVestidoConVestido, maniquiVestidoPantalonCamisa, maniquiSinVestir};
	}
	
	public void maniquiesVestir (Maniqui [] maniquies, Vestido vestido) {
		
		
//		for (Maniqui maniqui : maniquiesVestir) {
//			if(maniqui.getCamisa()==null && maniqui.getVestido()==null) {
//				System.out.println("El maniquí "+ maniqui.getId()+"no está vestido");
//				maniquies[i].vestir(vestido);
//			}
//			
//		}
	}
	
	public void mostrarEscaparate() {
		
		for (Maniqui maniqui : maniquies) {
			maniqui.getPantalon().getColor();
		}
		
	}

	}


