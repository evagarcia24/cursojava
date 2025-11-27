package hibernateProfe.ejercicio1.dao;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.cursojava.hibernate.ejercicio1.entites.Curso;
import es.cursojava.utils.HibernateUtil;

public class CursoDAO {

	private Session session;
	private Transaction transaction;

	public CursoDAO() {
		session = HibernateUtil.getSessionFactory();
		transaction = session.beginTransaction();
	}

	public void guardarCurso(Curso curso) {
		session.persist(curso);
	}

	public void eliminarCurso() {

	}

	public void actualizarCurso() {

	}

	public Curso obtenerCursoPorId(Long id) {
		return session.get(Curso.class, id);
	}

	public List<Curso> obtenerTodosLosCursos() {

		return session.createQuery("from Curso", Curso.class).list();

	}

	public void commitTransaction() {
		transaction.commit();
	}
	
	
	    public static void cargarCursosDesdeTxt(String ruta) throws Exception {
	    	
	    			List<String> lineas = Files.readAllLines(Paths.get(ruta));
 
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
 
		for (String linea : lineas) {
			String[] partes = linea.split("\\|");
 
			Curso curso = new Curso(
				String codigo = partes[0];                           // codigo
				String nombre = partes[1];                           // nombre
				String descripcion = partes[2];                           // descripcion
				Integer horasTotales = Integer.parseInt(partes[3]);         // horasTotales
				Boolean activo = Boolean.parseBoolean(partes[4]);     // activo
				partes[5],                           // nivel
				partes[6],                           // categoria
				Double.parseDouble(partes[7]),       // precio
				LocalDate.parse(partes[8]),          // fechaInicio
				LocalDate.parse(partes[9])           // fechaFin
			);
 
			session.save(curso);
		}
 
		tx.commit();
		session.close();
 
		System.out.println("Cursos cargados en la base de datos.");
	    }
	}

