package conceptosAvanzadosJava;

public class CursoImpl implements Curso {

	// Atributos
	private String nombre = null;
	private String codigo = null;
	private int cupoMaximo = 0;

	// Constructor
	public CursoImpl(String nombre, String codigo, int cupoMaximo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.cupoMaximo = cupoMaximo;
	}

	// Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCupoMaximo() {
		return cupoMaximo;
	}

	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}

	// Metodos sobreescritos de interfaz Curso
	@Override
	public String obtenerNombre() {

		return null;
	}

	@Override
	public String obtenerCodigo() {

		return null;
	}

	@Override
	public String obtenerCupoDisponible() {

		return null;
	}

	// Metodo sobreescrito toString
	@Override
	public String toString() {
		return "Master[nombre=" + nombre + ", codigo=" + codigo + ", cupoMaximo=" + cupoMaximo + "]";
	}

}
