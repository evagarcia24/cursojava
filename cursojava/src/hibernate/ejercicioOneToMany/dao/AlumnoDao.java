package hibernate.ejercicioOneToMany.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.ejercicioOneToMany.dto.AlumnoAulaDto;
import hibernate.ejercicioOneToOne.entites.Alumno;

public class AlumnoDao {

    private SessionFactory sessionFactory;

    public AlumnoDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Alumno alumno) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(alumno);
    }

    // ----------------------------------------------
    //  DTO → obtener en qué aula está un alumno
    // ----------------------------------------------
    public AlumnoAulaDto buscarAulaDto(String nombreAlumno) {

        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("""
            SELECT new dto.AlumnoAulaDTO(
                alu.nombre,
                aul.codigoAula,
                aul.ubicacion
            )
            FROM Alumno alu
            JOIN alu.curso cur
            JOIN cur.aula aul
            WHERE alu.nombre = :nombre
        """, AlumnoAulaDto.class)
        .setParameter("nombre", nombreAlumno)
        .uniqueResult();
    }
}
