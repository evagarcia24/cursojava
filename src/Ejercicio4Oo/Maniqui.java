//Clase Maniqui
//	-id
//	-Pantalon
//	-Camisa
//	-Vestido
//	3 Constructores
//		+ vacio
//		+ (Pantalon, Camisa)
//		+ (Vestido)
//	-metodos vestir y desvestir (solo se les puede vestir con pantalón y camisa o con vestido)

package Ejercicio4Oo;

public class Maniqui {

	private int id;
	private Pantalon pantalon;
	private Camisa camisa;
	private Vestido vestido;

	// Constructor id
	public Maniqui(int id) {
		this.id = id;
	}

	// Constructor pantalon y camisa
	public Maniqui(int id, Pantalon pantalon, Camisa camisa) {
		this.id = id;
		this.pantalon = pantalon;
		this.camisa = camisa;
	}

	// Constructor vestido
	public Maniqui(int id, Vestido vestido) {
		this.id = id;
		this.vestido = vestido;
	}

	// Getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pantalon getPantalon() {
		return pantalon;
	}

	public void setPantalon(Pantalon pantalon) {
		this.pantalon = pantalon;
	}

	public Camisa getCamisa() {
		return camisa;
	}

	public void setCamisa(Camisa camisa) {
		this.camisa = camisa;
	}

	public Vestido getVestido() {
		return vestido;
	}

	public void setVestido(Vestido vestido) {
		this.vestido = vestido;
	}

	// Metodo vestir sobrecargado
	public void vestir(Pantalon pantalon, Camisa camisa) {
		desvestir();
		this.pantalon = pantalon;
		this.camisa = camisa;
	}

	public void vestir(Vestido vestido) {
		desvestir();
		this.vestido = vestido;
	}

	// Metodo desvestir
	public void desvestir() {

		this.pantalon = null;
		this.camisa = null;
		this.vestido = null;
	}
}
