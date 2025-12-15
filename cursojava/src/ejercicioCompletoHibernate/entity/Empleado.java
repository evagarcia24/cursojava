package ejercicioCompletoHibernate.entity;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_EMPLEADO")

public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nif;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String departamento;

	@Column(nullable = false)
	@Check (constraints = "salario >= 0") // es para asegurar que el salario no sea negativo
	private double salario;

	// Constructor vacio
	public Empleado() {
		super();
	}

	// Constructor con todos los atributos
	public Empleado(Long id, String nif, String nombre, String departamento, double salario) {
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
	    this.salario = salario;
	}

}