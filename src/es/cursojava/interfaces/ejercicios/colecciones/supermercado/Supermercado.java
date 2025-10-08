package es.cursojava.interfaces.ejercicios.colecciones.supermercado;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Supermercado {

	private String nombre;
	private List<List<Alimento>> stockAlimentos = new ArrayList<>();
	private Set<ClienteSupermercado> clientes = new HashSet<>();

	// Constructor
	public Supermercado(String nombre, List<List<Alimento>> stockAlimentos, Set<ClienteSupermercado> clientes) {
		super();
		this.nombre = nombre;
		this.stockAlimentos = stockAlimentos;
		this.clientes = clientes;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<List<Alimento>> getStockAlimentos() {
		return stockAlimentos;
	}

	public void setStockAlimentos(List<List<Alimento>> stockAlimentos) {
		this.stockAlimentos = stockAlimentos;
	}

	public Set<ClienteSupermercado> getClientes() {
		return clientes;
	}

	public void setClientes(Set<ClienteSupermercado> clientes) {
		this.clientes = clientes;
	}

}
