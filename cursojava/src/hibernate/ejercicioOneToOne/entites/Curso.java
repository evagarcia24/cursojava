package hibernate.ejercicioOneToOne.entites;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_CURSO")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_seq")
	@SequenceGenerator(name = "curso_seq", sequenceName = "SEQ_CURSO", allocationSize = 1)
	private Long id; // PK autoincremental con secuencia

	@NotNull
	@NotBlank
	@Size(max = 20)
	@Column(name = "CODIGO", nullable = false, unique = true, length = 20)
	private String codigo;

	@NotNull
	@NotBlank
	@Size(max = 100)
	@Column(name = "NOMBRE", nullable = false, length = 100)
	private String nombre;

	@Size(max = 1000)
	@Column(name = "DESCRIPCION", length = 1000)
	private String descripcion;

	@NotNull
	@Min(1)
	@Column(name = "HORAS_TOTALES", nullable = false)
	private Integer horasTotales;

	@NotNull
	@Column(name = "ACTIVO", nullable = false)
	private Boolean activo = Boolean.TRUE;

	@Size(max = 20)
	@Column(name = "NIVEL", length = 20)
	private String nivel;

	@Size(max = 50)
	@Column(name = "CATEGORIA", length = 50)
	private String categoria;

	@PositiveOrZero
	@Column(name = "PRECIO")
	private BigDecimal precio;

	@Column(name = "FECHA_INICIO")
	private LocalDate fechaInicio;

	@Column(name = "FECHA_FIN")
	private LocalDate fechaFin;

	@NotNull
	@Column(name = "FECHA_CREACION", nullable = false)
	private LocalDateTime fechaCreacion;

	// Relación OneToOne con Aula (unidireccional)
	@OneToOne(fetch = FetchType.LAZY, cascade = jakarta.persistence.CascadeType.ALL)
	@JoinColumn(name = "AULA_ID", referencedColumnName = "id")
	private Aula aula;
	
	// 
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Alumno> alumnos = new ArrayList<>();


	// Constructores
	public Curso() {
		super();
	}

	public Curso(String codigo, String nombre, Integer horasTotales) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.horasTotales = horasTotales;
		this.activo = Boolean.TRUE;
	}

	public Curso(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Curso(String codigo, String nombre, String descripcion, Integer horasTotales, Boolean activo, String nivel,
			String categoria, BigDecimal precio, LocalDate fechaInicio, LocalDate fechaFin, Aula aula) {
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
		this.aula = aula;
	}

	// Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getHorasTotales() {
		return horasTotales;
	}

	public void setHorasTotales(Integer horasTotales) {
		this.horasTotales = horasTotales;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
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

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
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

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	// ValidaCION
	@AssertTrue(message = "fechaFin debe ser igual o posterior a fechaInicio")
	private boolean isFechaFinValida() {
		if (fechaFin == null)
			return true;
		if (fechaInicio == null)
			return true;
		return !fechaFin.isBefore(fechaInicio);
	}

	@PrePersist
	private void prePersist() {
		if (fechaCreacion == null) {
			fechaCreacion = LocalDateTime.now();
		}
		if (activo == null) {
			activo = Boolean.TRUE;
		}
	}

	// toString
	@Override
	public String toString() {
		return "Curso [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", horasTotales=" + horasTotales
				+ ", activo=" + activo + ", nivel=" + nivel + ", categoria=" + categoria + ", precio=" + precio
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", fechaCreacion=" + fechaCreacion
				+ ", aula=" + (aula != null ? aula.getCodigoAula() : null) + "]";
	}
}