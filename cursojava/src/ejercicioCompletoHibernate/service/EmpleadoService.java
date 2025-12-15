package ejercicioCompletoHibernate.service;

import java.math.BigDecimal;
import java.util.List;

import ejercicioCompletoHibernate.dto.EmpleadoDto;

public interface EmpleadoService {
    EmpleadoDto altaEmpleado(EmpleadoDto empleadoDto);
    EmpleadoDto actualizarSalario(String nif, BigDecimal nuevoSalario);
    EmpleadoDto buscarPorNif(String nif);
    List<EmpleadoDto> listarPorDepartamento(String departamento);
    List<EmpleadoDto> listarTodos();
	EmpleadoDto actualizarSalario(String nif, double nuevoSalario);

}