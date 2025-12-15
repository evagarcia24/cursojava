package ejercicioCompletoHibernate.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ejercicioCompletoHibernate.dao.EmpleadoDaoImpl;
import ejercicioCompletoHibernate.dto.EmpleadoDto;
import ejercicioCompletoHibernate.exception.BusinessException;
import ejercicioCompletoHibernate.service.EmpleadoService;
import ejercicioCompletoHibernate.service.EmpleadoServiceImpl;

public class Main {

	public static void main(String[] args) {
		// Configuración de Hibernate (usa hibernate.cfg.xml en resources)
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		// Inyección manual de dependencias
		EmpleadoService service = new EmpleadoServiceImpl(new EmpleadoDaoImpl(sessionFactory));

		Scanner sc = new Scanner(System.in);

		try {
			// Alta de empleado con datos introducidos por teclado
			EmpleadoDto emp1 = new EmpleadoDto();

			System.out.print("Introduce el NIF del empleado: ");
			emp1.setNif(sc.nextLine());

			System.out.print("Introduce el nombre: ");
			emp1.setNombre(sc.nextLine());

			System.out.print("Introduce el departamento: ");
			emp1.setDepartamento(sc.nextLine());

			System.out.print("Introduce el salario: ");
			emp1.setSalario(sc.nextDouble());
			sc.nextLine(); // limpiar salto de línea

			service.altaEmpleado(emp1);
			System.out.println("Empleado dado de alta: " + emp1.getNombre());

			// Búsqueda por NIF
			System.out.print("Introduce el NIF a buscar: ");
			String nifBusqueda = sc.nextLine();
			EmpleadoDto buscado = service.buscarPorNif(nifBusqueda);
			if (buscado != null) {
				System.out
						.println("Empleado encontrado: " + buscado.getNombre() + " - Salario: " + buscado.getSalario());
			} else {
				System.out.println("No se encontró ningún empleado con ese NIF");
			}

			// Actualización de salario
			System.out.print("Introduce el NIF para actualizar salario: ");
			String nifActualizar = sc.nextLine();
			System.out.print("Introduce el nuevo salario: ");
			double nuevoSalario = sc.nextDouble();
			sc.nextLine(); // limpiar salto de línea
			EmpleadoDto actualizado = service.actualizarSalario(nifActualizar, nuevoSalario);
			System.out.println("Salario actualizado: " + actualizado.getSalario());

			// Alta de otro empleado
			EmpleadoDto emp2 = new EmpleadoDto();

			System.out.print("Introduce el NIF del segundo empleado: ");
			emp2.setNif(sc.nextLine());

			System.out.print("Introduce el nombre: ");
			emp2.setNombre(sc.nextLine());

			System.out.print("Introduce el departamento: ");
			emp2.setDepartamento(sc.nextLine());

			System.out.print("Introduce el salario: ");
			double salario2 = sc.nextDouble();
			sc.nextLine(); // limpiar salto de línea
			emp2.setSalario(salario2);

			service.altaEmpleado(emp2);

			// Listado por departamento
			System.out.print("Introduce el departamento para listar empleados: ");
			String depto = sc.nextLine();
			List<EmpleadoDto> listaDepto = service.listarPorDepartamento(depto);
			System.out.println("Empleados en " + depto + ":");
			for (EmpleadoDto e : listaDepto) {
				System.out.println(" - " + e.getNombre() + " (" + e.getNif() + ")");
			}

		} catch (BusinessException e) {
			System.out.println("Error de negocio: " + e.getMessage());
		} finally {
			sc.close();
			sessionFactory.close();
		}
	}
}