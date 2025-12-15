package ejercicioCompletoHibernate.dto;

import java.math.BigDecimal;

public class EmpleadoDto {
	private Long id;
	private String nif;
	private String nombre;
	private String departamento;
	private double salario;

	// Constructor vacio y constructor con todos los atributos
	public EmpleadoDto() {
		super();
	}

	public EmpleadoDto(Long id, String nif, String nombre, String departamento, Double salario) {
		super();
		this.id = id;
		this.nif = nif;
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
	}

	// Getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double double1) {
		this.salario = double1;
	}

}
