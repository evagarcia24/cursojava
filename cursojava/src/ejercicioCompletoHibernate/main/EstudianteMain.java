package ejercicioCompletoHibernate.main;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ejercicioCompletoHibernate.entity.CarnetBiblioteca;
import ejercicioCompletoHibernate.entity.Estudiante;
import es.cursojava.utils.HibernateUtil;

public class EstudianteMain {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory();
		
		Transaction tx = session.beginTransaction();
		
		tx.begin();
		
		CarnetBiblioteca carnet = new CarnetBiblioteca(Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusYears(4)));
		Estudiante estudiante1 = new Estudiante("Estudiante1", "email1@email.es", 20);
		
		estudiante1.setcarnetBiblioteca(carnet);
		
		Estudiante estudiante2 = new Estudiante("Estudiante2", "email2@email.es", 30, carnet);
	}

}