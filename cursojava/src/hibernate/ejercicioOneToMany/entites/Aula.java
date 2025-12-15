package hibernate.ejercicioOneToMany.entites;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_AULA")
public class Aula implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CODIGOAULA", unique = true)
	private String codigoAula;

	@Column(name = "CAPACIDAD")
	private Integer capacidad;

	@Column(name = "UBICACION")
	private String ubicacion;

	public Aula() {
		super();
	}

	public Aula(String codigoAula, Integer capacidad, String ubicacion) {
		super();
		this.codigoAula = codigoAula;
		this.capacidad = capacidad;
		this.ubicacion = ubicacion;
	}

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
		return "Aula [id=" + id + ", codigoAula=" + codigoAula + ", capacidad=" + capacidad + ", ubicacion=" + ubicacion
				+ "]";

	}

}
