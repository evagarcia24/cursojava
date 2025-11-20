package hibernate;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity // Esto son ANOTACIONES que se usan mucho EN HIBERNATE, empiezan con arroba (@), no se pone punto y coma (;) al final. En Hibernate estamos obligados a pober antes de la clase @Entity e importar import jakarta.persistence.Entity;
@Table(name = "TB_EMPRESA")
public class Empresa {
	@Id // En Hibernate estamos obligados a pober @Id (seria el PRIMARY KEY en la tabla) e importar import jakarta.persistence.Id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Se usa long porque no se sabe hasta cuantos ids se van a guardar
	@Column (length = 30)
	private String nombre;
	private String tipoSociedad;
	private String cif;
	@Column (name = "ACTIVIDAD")
	private String tipoActividad;
	private Date fechaConstitucion;

	// En Hibernate se necesita obligatoriamente siempre un constructor vacio
	public Empresa() {
		super();
	}

	// Se pueden (y deben) crear otros constructores a patre del vacio
	public Empresa(long id, String nombre, String tipoSociedad, String cif, String tipoActividad, Date fechaConstitucion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoSociedad = tipoSociedad;
		this.cif = cif;
		this.tipoActividad = tipoActividad;
		this.fechaConstitucion = fechaConstitucion;
	}
	
	public Empresa(String nombre, String tipoSociedad, String cif, String tipoActividad, Date fechaConstitucion) {
		super();
		this.nombre = nombre;
		this.tipoSociedad = tipoSociedad;
		this.cif = cif;
		this.tipoActividad = tipoActividad;
		this.fechaConstitucion = fechaConstitucion;
	}

	// Los metodos getters y setters son obligatorios en Hibernate, y tienen que ser public
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoSociedad() {
		return tipoSociedad;
	}

	public void setTipoSociedad(String tipoSociedad) {
		this.tipoSociedad = tipoSociedad;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	public Date getFechaConstitucion() {
		return fechaConstitucion;
	}

	public void setFechaConstitucion(Date fechaConstitucion) {
		this.fechaConstitucion = fechaConstitucion;
	}

}
