package hibernate;

public class MainHibernateCursos {
    public static void main(String[] args) {

        // 1️⃣ Insertar cursos en la base de datos
        UtilidadesHibernate.insertarCursos();

        // 2️⃣ Mostrar todos los cursos
        System.out.println("=== Todos los cursos ===");
        UtilidadesHibernate.mostrarTodosLosCursos();

        // 3️⃣ Mostrar solo los cursos activos
        System.out.println("=== Cursos activos ===");
        UtilidadesHibernate.mostrarCursosActivos();
    }
}
