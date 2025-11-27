package hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "TB_CURSO")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Clave primaria autoincremental

	@NotBlank
	@NotNull
	@Column(nullable = false, unique = true, length = 20)
	private String codigo; // Código único, obligatorio

	@NotBlank
	@NotNull
	@Column(nullable = false, length = 100)
	private String nombre; // Obligatorio

	@NotBlank
	@NotNull
	@Size(max = 1000)
	@Column(length = 1000)	
	private String descripcion; // Opcional

	@Column(nullable = false)
	@Min(1)
	private int horasTotales; // Obligatorio, >0

	@Column(nullable = false)
	private boolean activo = true; // Obligatorio, default true

	@Column(length = 20)
	@Pattern(regexp = "Básico|Intermedio|Avanzado")
	private String nivel; // Opcional, valores limitados

	@Column(length = 50)
	private String categoria; // Opcional, longitud máxima 50

	// precio puede ser null (opcional). Usamos DecimalMin para números decimales
	@Column(precision = 10, scale = 2)
	@DecimalMin(value = "0.0", inclusive = true)
	private Double precio; // Opcional, >=0

	@Column
	private LocalDate fechaInicio; // Opcional

	@Column
	private LocalDate fechaFin; // Opcional

	@Column(nullable = false, updatable = false)
	private LocalDateTime fechaCreacion; // Obligatoria

	// Constructor vacío
	public Curso() {
		this.activo = true;
	}

	// Constructor completo (no asigna fechaCreacion aquí; se gestionará en @PrePersist)
	public Curso(String codigo, String nombre, String descripcion, int horasTotales, boolean activo, String nivel,
			String categoria, Double precio, LocalDate fechaInicio, LocalDate fechaFin) {
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
	}

	@PrePersist
	protected void onCreate() {
		if (this.fechaCreacion == null) {
			this.fechaCreacion = LocalDateTime.now();
		}
	}

	// Getters y Setters
	public Long getId() {
		return id;
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	@Override
	public String toString() {
		return "Curso{" + "id=" + id + ", codigo='" + codigo + '\'' + ", nombre='" + nombre + '\'' + ", descripcion='"
			+ descripcion + '\'' + ", horasTotales=" + horasTotales + ", activo=" + activo + ", nivel='" + nivel
			+ '\'' + ", categoria='" + categoria + '\'' + ", precio=" + precio + ", fechaInicio=" + fechaInicio
			+ ", fechaFin=" + fechaFin + ", fechaCreacion=" + fechaCreacion + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Curso curso = (Curso) o;
		return id != null && Objects.equals(id, curso.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}