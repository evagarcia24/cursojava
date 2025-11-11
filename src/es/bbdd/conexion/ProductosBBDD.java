package es.bbdd.conexion;

import java.sql.Date;

public class ProductosBBDD {

	private int id;
	private String nombre;
	private String categoria;
	private double precio;
	private int stock;
	private Date fechaAlta;
	private String estado;
	private String codigoSku;
	private String creadoPor;
	private int iva;

	public ProductosBBDD(int id, String nombre, String categoria, double precio, int stock, Date fechaAlta,
			String estado, String codigoSku, String creadoPor, int iva) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.stock = stock;
		this.fechaAlta = fechaAlta;
		this.estado = estado;
		this.codigoSku = codigoSku;
		this.creadoPor = creadoPor;
		this.iva = iva;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getCategoria() {
		return categoria;
	}

	protected void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	protected double getPrecio() {
		return precio;
	}

	protected void setPrecio(double precio) {
		this.precio = precio;
	}

	protected int getStock() {
		return stock;
	}

	protected void setStock(int stock) {
		this.stock = stock;
	}

	protected Date getFechaAlta() {
		return fechaAlta;
	}

	protected void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	protected String getEstado() {
		return estado;
	}

	protected void setEstado(String estado) {
		this.estado = estado;
	}

	protected String getCodigoSku() {
		return codigoSku;
	}

	protected void setCodigoSku(String codigoSku) {
		this.codigoSku = codigoSku;
	}

	protected String getCreadoPor() {
		return creadoPor;
	}

	protected void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	protected int getIva() {
		return iva;
	}

	protected void setIva(int iva) {
		this.iva = iva;
	}

}
