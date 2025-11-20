package hibernate;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_CURSO")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true, length = 20)
	private String codigo;
	
	@NotBlank
	@Column(length = 100, nullable = false)
	private String nombre;
	
	@Column(length = 1000)
	@Size(min = 500, max = 1000)
	private String descripcion;
	
	@Column(nullable = false)
	@Min(1)
	private int horasTotales;
	
	@Column(nullable = false)
	private boolean activo = true;
	
	@Column(length = 20)
	@Pattern(regexp = "Básico|Intermedio|Avanzado")
	private String nivel;
	
	@Column(nullable = false, length = 20)
	@Pattern(regexp = "Programación | Big Dat | DevOps | Ofimática")
	private String categoria;
	
	@Min(0)
	private double precio;
	
	private LocalDate fechaInicio;
	
	private LocalDate fechaFin;
	
	private LocalDateTime fechaCreacion;

	// Constructor vacio
	public Curso() {
		super();
	}

	public Curso(String codigo, String nombre, String descripcion, int horasTotales, String activo, String nivel,
			String categoria, double precio, Date fechaInicio, Date fechaFin, Date fechaCreacion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horasTotales = horasTotales;
		this.activo = activo;
		this.nivel = nivel;
		this.categoria = categoria;
		this.precio = precio;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaCreacion = fechaCreacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getHorasTotales() {
		return horasTotales;
	}

	public void setHorasTotales(int horasTotales) {
		this.horasTotales = horasTotales;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
