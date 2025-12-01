package es.cursojava.inicio.interfaces.e01mueblesyverduras;

public class Inicializaciones {

	public static Limpiable[] instanciarLimpiables() {

		Mesa mesa1 = new Mesa("Marrón", "Rectangular");
		Silla silla1 = new Silla("Negra", 4);
		Lechuga lechuga1 = new Lechuga("España", "Romana");
		JudiasVerdes judiasVerdes1 = new JudiasVerdes("Méjico", true);

		return new Limpiable[] { mesa1, silla1, lechuga1, judiasVerdes1 };
	}

	public static void desinfectarDesinfectables(Limpiable[] limpiables) {

		for (Limpiable limpiable : limpiables) {
			if (limpiable instanceof Desinfectable) {
				((Desinfectable) limpiable).desinfectar();
			}
		}

	}

	public static void runMueblesYVerduras() {

		Limpiable[] mueblesYVerduras = Inicializaciones.instanciarLimpiables();
		Inicializaciones.desinfectarDesinfectables(mueblesYVerduras);

	}

}
