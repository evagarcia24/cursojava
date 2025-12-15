package hibernate.ejercicioOneToOne.dto;

import java.io.Serializable;

public class AulaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String codigoAula;
	private Integer capacidad;
	private String ubicacion;

	// Constructores
	public AulaDTO() {
	}

	public AulaDTO(String codigoAula, Integer capacidad, String ubicacion) {
		super();
		this.codigoAula = codigoAula;
		this.capacidad = capacidad;
		this.ubicacion = ubicacion;
	}

	public AulaDTO(Long id, String codigoAula, Integer capacidad, String ubicacion) {
		this.id = id;
		this.codigoAula = codigoAula;
		this.capacidad = capacidad;
		this.ubicacion = ubicacion;
	}

	// Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoAula() {
		return codigoAula;
	}

	public void setCodigoAula(String codigoAula) {
		this.codigoAula = codigoAula;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "AulaDTO [id=" + id + ", codigoAula=" + codigoAula + ", capacidad=" + capacidad + ", ubicacion="
				+ ubicacion + "]";
	}
}