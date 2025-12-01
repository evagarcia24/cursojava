package es.bbdd.conexion;

import java.sql.Date;

public class Producto {

	private int id;
	private String nombre;
	private String categoria;
	private double precio;
	private int stock;
	private Date fecha_alta;
	private String estado;
	private String codigo_sku;
	private String creado_por;
	private int iva;
	
	public Producto(int id, String nombre, String categoria, double precio, int stock, Date fecha_alta,
			String estado, String codigo_sku, String creado_por, int iva) {

		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.stock = stock;
		this.fecha_alta = fecha_alta;
		this.estado = estado;
		this.codigo_sku = codigo_sku;
		this.creado_por = creado_por;
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

	protected Date getFecha_alta() {
		return fecha_alta;
	}

	protected void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	protected String getEstado() {
		return estado;
	}

	protected void setEstado(String estado) {
		this.estado = estado;
	}

	protected String getCodigo_sku() {
		return codigo_sku;
	}

	protected void setCodigo_sku(String codigo_sku) {
		this.codigo_sku = codigo_sku;
	}

	protected String getCreado_por() {
		return creado_por;
	}

	protected void setCreado_por(String creado_por) {
		this.creado_por = creado_por;
	}

	protected int getIva() {
		return iva;
	}

	protected void setIva(int iva) {
		this.iva = iva;
	}

	@Override
	public String toString() {
		return "ProductosBBDD [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio
				+ ", stock=" + stock + ", fecha_alta=" + fecha_alta + ", estado=" + estado + ", codigo_sku="
				+ codigo_sku + ", creado_por=" + creado_por + ", iva=" + iva + "]";
	}
	


	
}
