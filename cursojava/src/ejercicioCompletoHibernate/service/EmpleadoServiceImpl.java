package ejercicioCompletoHibernate.service;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import ejercicioCompletoHibernate.dao.EmpleadoDao;
import ejercicioCompletoHibernate.dto.EmpleadoDto;
import ejercicioCompletoHibernate.entity.Empleado;
import ejercicioCompletoHibernate.exception.BusinessException;

public class EmpleadoServiceImpl implements EmpleadoService {

    private EmpleadoDao empleadoDao;

    public EmpleadoServiceImpl(EmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;
    }

    @Override
    public EmpleadoDto altaEmpleado(EmpleadoDto dto) {
        validarEmpleado(dto);

        if (empleadoDao.buscarPorNif(dto.getNif()) != null) {
            throw new BusinessException("Ya existe un empleado con NIF " + dto.getNif());
        }

        Empleado emp = convertirADominio(dto);
        empleadoDao.guardar(emp);
        return convertirADto(emp);
    }

    @Override
    public EmpleadoDto actualizarSalario(String nif, double nuevoSalario) {
        if (nuevoSalario < 0) {
            throw new BusinessException("El salario debe ser mayor o igual que 0");
        }
        Empleado emp = empleadoDao.buscarPorNif(nif);
        if (emp == null) {
            throw new BusinessException("Empleado no encontrado con NIF " + nif);
        }

        emp.setSalario(nuevoSalario);
        empleadoDao.guardar(emp);
        return convertirADto(emp);
    }



    @Override
    public EmpleadoDto buscarPorNif(String nif) {
        Empleado emp = empleadoDao.buscarPorNif(nif);
        if (emp == null) {
            throw new BusinessException("Empleado no encontrado con NIF " + nif);
        }
        return convertirADto(emp);
    }

    @Override
    public List<EmpleadoDto> listarPorDepartamento(String departamento) {
        return empleadoDao.buscarPorDepartamento(departamento)
                          .stream()
                          .map(this::convertirADto)
                          .collect(Collectors.toList());
    }

    @Override
    public List<EmpleadoDto> listarTodos() {
        return empleadoDao.buscarTodos()
                          .stream()
                          .map(this::convertirADto)
                          .collect(Collectors.toList());
    }

    private void validarEmpleado(EmpleadoDto dto) {
        if (dto.getNif() == null || dto.getNif().isBlank()) {
            throw new BusinessException("NIF obligatorio");
        }
        if (dto.getNombre() == null || dto.getNombre().isBlank()) {
            throw new BusinessException("Nombre obligatorio");
        }
        if (dto.getDepartamento() == null || dto.getDepartamento().isBlank()) {
            throw new BusinessException("Departamento obligatorio");
        }
        if (dto.getSalario() == null || dto.getSalario().compareTo(Double.valueOf(1000)) < 0) {
            throw new BusinessException("El salario debe ser mayor o igual a 1000");
        }
    }

    private Empleado convertirADominio(EmpleadoDto dto) {
        Empleado emp = new Empleado();
        emp.setId(dto.getId());
        emp.setNif(dto.getNif());
        emp.setNombre(dto.getNombre());
        emp.setDepartamento(dto.getDepartamento());
        emp.setSalario(dto.getSalario());
        return emp;
    }

    private EmpleadoDto convertirADto(Empleado emp) {
        EmpleadoDto dto = new EmpleadoDto();
        dto.setId(emp.getId());
        dto.setNif(emp.getNif());
        dto.setNombre(emp.getNombre());
        dto.setDepartamento(emp.getDepartamento());
        dto.setSalario(emp.getSalario());
        return dto;
    }

	@Override
	public EmpleadoDto actualizarSalario(String nif, BigDecimal nuevoSalario) {
		// TODO Auto-generated method stub
		return null;
	}

    
}