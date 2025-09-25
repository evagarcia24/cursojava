package oo;

public class Colegio {

	public static void main(String[] args) {

//		Alumno alumno1 = new Alumno();//Esto llama al constructor por defecto
//		alumno1.setNombre("Jose");
//		alumno1.setNotaMedia(3.5);
//		String [] asignaturas1 = {"Historia", "Lengua", "Filosofía"};
//		alumno1.setAsignaturas(asignaturas1);
//		
//		
//		Alumno alumno2 = new Alumno();
//		alumno2.setNombre("Ivan");
//		alumno2.setNotaMedia(6.5);
//		alumno2.setAsignaturas(new String [] {"Matematicas", "Quimica"});//Otra forma de hacerlo
//
//		
//		Alumno alumno3 = new Alumno();
//		alumno3.setNombre("Laura");
//		alumno3.setNotaMedia(9.75);
//		String [] asignaturas3 = {"Matemáticas", "Informática", "Física"};
//		alumno3.setAsignaturas(asignaturas3);

//		alumno1.estudiar();
//		alumno2.estudiar();
//		alumno3.estudiar();

		Alumno alumno1 = new Alumno("Jose", "111A");
		alumno1.setNotaMedia(9.5);
		alumno1.setAsignaturas(new String[] {"Fisica", "Quimica"});
		Alumno alumno2 = new Alumno("Sofia", "222B");
		
		String [] asignaturasAlumno3 = {"Fisica", "Quimica"};
		String [] asignaturasAlumno4 = {"Matematicas", "Informatica", "Fisica"};

		Alumno alumno3 = new Alumno ("Roberto", "333C", 7.5, asignaturasAlumno3);
		Alumno alumno4 = new Alumno ("Clara", "444D", 9.5, asignaturasAlumno4);	
		
		
		alumno1.estudiar();
		alumno2.estudiar();
		alumno3.estudiar();
		alumno4.estudiar();
	}
}
