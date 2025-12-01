package conceptosAvanzadosJava;

public class Master extends CursoImpl {

	private boolean isOficial;

	// Constructores sobrecargados

	public Master(String nombre, String codigo, int cupoMaximo, boolean isOficial) {
		super(nombre, codigo, cupoMaximo);
		this.isOficial = isOficial;
	}

	public Master(String nombre, String codigo, int cupoMaximo) {
		super(nombre, codigo, cupoMaximo);
	}

}
