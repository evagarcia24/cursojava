package es.cursojava.interfaces.ejercicios.colecciones.supermercado;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClienteSupermercado {

	private String nombre;
	private List<Alimento> carritoCompra = new ArrayList<>();
	private Set<ClienteSupermercado> clientes = new HashSet<>();

	// Constructores sobrecargados 
	public ClienteSupermercado(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public ClienteSupermercado() {
	    this.carritoCompra = new ArrayList<>();
	    this.clientes = new HashSet<>();
	}


	public ClienteSupermercado(String nombre, List<Alimento> carritoCompra, Set<ClienteSupermercado> clientes) {
		super();
		this.nombre = nombre;
		this.carritoCompra = carritoCompra;
		this.clientes = clientes;
	}


	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alimento> getCarritoCompra() {
		return carritoCompra;
	}

	public void setCarritoCompra(List<Alimento> carritoCompra) {
		this.carritoCompra = carritoCompra;
	}

	public Set<ClienteSupermercado> getClientes() {
		return clientes;
	}

	public void setClientes(Set<ClienteSupermercado> clientes) {
		this.clientes = clientes;
	}

}
