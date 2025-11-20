package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class HibernateMain {
	public static void main(String[] args) {

		try {
			SessionFactory sessionFactory = new Configuration().configure() // Carga hibernate.cfg.xml
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			System.out.println("Conectado");

			Transaction tx = session.beginTransaction();

			Empresa empresa1 = new Empresa("Empresa1", "S.A.", "111A", "Venta Jabones", null);
			Empresa empresa2 = new Empresa("Empresa2", "S.L.", "222A", "Venta FunkoPop", null);

			session.persist(empresa1); // Esto seria como el INSERT INTO TABLE
			session.persist(empresa2);

			tx.commit();

			Query<Empresa> query = session.createQuery("from Empresa", Empresa.class); // Esto se denomina HQL (Hibernate Query Language)
			List<Empresa> empresas = query.list();
			
			for (Empresa empresa : empresas) {
				System.out.println(empresa);
			}

		} catch (Throwable ex) {
			System.err.println("Error al crear la SessionFactory." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
