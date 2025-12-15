package ejercicioCompletoHibernate.dao;

import java.util.List;

import ejercicioCompletoHibernate.entity.Empleado;

public interface EmpleadoDao {

	void guardar(Empleado empleado);
	Empleado buscarPorId(Long id);
	Empleado buscarPorNif(String nif);
	List<Empleado> buscarPorDepartamento(String departamento);
	List<Empleado> buscarTodos();

}
