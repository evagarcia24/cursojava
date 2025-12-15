package hibernate.ejercicioOneToMany.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import es.cursojava.hibernate.ejercicio1.entites.Aula;

public class AulaDao {

    private SessionFactory sessionFactory;

    public AulaDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Aula aula) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(aula);
    }

    public Aula findByCodigo(String codigo) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "FROM Aula a WHERE a.codigoAula = :codigo", Aula.class)
                .setParameter("codigo", codigo)
                .uniqueResult();
    }
}
