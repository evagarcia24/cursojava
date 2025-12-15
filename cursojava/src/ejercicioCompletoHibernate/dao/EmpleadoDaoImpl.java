package ejercicioCompletoHibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ejercicioCompletoHibernate.entity.Empleado;

public class EmpleadoDaoImpl implements EmpleadoDao {

	private SessionFactory sessionFactory;

	public EmpleadoDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void guardar(Empleado empleado) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(empleado);
		tx.commit();
		session.close();
	}

	@Override
	public Empleado buscarPorId(Long id) {
		Session session = sessionFactory.openSession();
		Empleado emp = session.get(Empleado.class, id);
		session.close();
		return emp;
	}

	@Override
	public Empleado buscarPorNif(String nif) {
		Session session = sessionFactory.openSession();
		Empleado emp = session.createQuery("FROM Empleado e WHERE e.nif = :nif", Empleado.class)
				.setParameter("nif", nif).uniqueResult();
		session.close();
		return emp;
	}

	@Override
	public List<Empleado> buscarPorDepartamento(String departamento) {
		Session session = sessionFactory.openSession();
		List<Empleado> lista = session.createQuery("FROM Empleado e WHERE e.departamento = :dep", Empleado.class)
				.setParameter("dep", departamento).list();
		session.close();
		return lista;
	}

	@Override
	public List<Empleado> buscarTodos() {
		Session session = sessionFactory.openSession();
		List<Empleado> lista = session.createQuery("FROM Empleado", Empleado.class).list();
		session.close();
		return lista;
	}
}