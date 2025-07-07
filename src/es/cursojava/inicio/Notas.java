/*EJERCICIO 2
===============================================
+ Declarar la variables asignatura de tipo String, nombreAlumno de tipo String y nota de tipo int 
+ Inicializar las variables con valores inventados
+ El resultado a mostrar sería: El alumno Juan en la asignatura Matemáticas tiene un Notable

0 <5 suspenso
5 <7 aprobado
7 <9 notable
9-10 sobresaliente
*/

package es.cursojava.inicio;

public class Notas {

	public static void main(String[] args) {
		String asignatura = "Matematicas";
		String nombreAlumno ="Carlos"; 
		int notaAlumno = 11;

		
		if (notaAlumno <5) {
			System.out.println("El alumno " + nombreAlumno + " en la asignatura " + asignatura + " tiene un Suspenso");
		} else if (notaAlumno < 7) {
			System.out.println("El alumno " + nombreAlumno + " en la asignatura " + asignatura + " tiene un Aprobado");
		} else if (notaAlumno < 9) {
			System.out.println("El alumno " + nombreAlumno + " en la asignatura " + asignatura + " tiene un Notable");
		} else if (notaAlumno<=10) {
			System.out.println("El alumno " + nombreAlumno + " en la asignatura " + asignatura + " tiene un Sobresaliente");
		}else {
			System.out.println("La nota "+notaAlumno+" es incorrecta");
		}



	}

}
