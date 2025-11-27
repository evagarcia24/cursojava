package es.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import es.cursojava.examen.modulo2final.parte1.Curso;
import es.cursojava.utils.HibernateUtil;

public class UtilidadesHibernate {

	private Session session;
	private Transaction transaction;

	public CursoDAO() {
		session = HibernateUtil.getSessionFactory();
		transaction = session.beginTransaction();
	}
	
	



		
		private static Session getSession() {
			SessionFactory sessionFactory = new Configuration()
	                .configure() // Carga hibernate.cfg.xml
	                .buildSessionFactory();
	        Session session = sessionFactory.openSession();
	        
			return session;
		}
		
		public static Session getSessionFactory() {
			if (session == null || !session.isOpen()) {
				session = getSession();
			}
			return session;
		}
		
		
	}

    static {
        try {
            sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Curso.class)
                .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError("Error al crear SessionFactory: " + ex);
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}