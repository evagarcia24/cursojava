package hibernate.ejercicioOneToMany.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import es.cursojava.hibernate.ejercicio1.entites.Curso;

public class CursoDao {

    private SessionFactory sessionFactory;

  
	public CursoDao() {
		super();
	}

	public CursoDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Curso curso) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(curso);
    }

    public Curso findByCodigo(String codigo) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "FROM Curso c WHERE c.codigo = :codigo", Curso.class)
                .setParameter("codigo", codigo)
                .uniqueResult();
    }
}
