/*Herramienta para calcular el precio de una llamada
Cuando se realiza una llamada, el cobro es por el tiempo que esta dura, de tal forma que:
+ los primeros cinco minutos cuestan 1€, 
+ los siguientes 3 minutos, 80 céntimos, 
+ los siguientes dos minutos a 70 céntimos 
+ y a partir del décimo minuto, 50 céntimos cada minuto.
Se carga un impuesto del 3% cuando es domingo, 
y si es otro día, 
	en turno de mañana 15% (6-12)
	y en turno de tarde 10%. (12-23)
	y en turno de noche -10%. (23-6)
Solicitar tiempo de llamada, dia de la semana y hora y calcular el coste de la llamada
Acciones:
Crear una condición que indique que mientras la cantidad de minutos sea mayor a 0 y menor a 5 el coste sea 1 euro. 
Crear una condición que indique que si la llamada dura más de 5 minutos y menos de 8, el costo de los minutos 6, 7 y 8 sea de 80 céntimos.
Crear una condición que indique que si la llamada dura más de 8 minutos y menos y hasta 10, el costo de los minutos 9 y 10 sea de 70 céntimos.
Crear una condición que indique que si la llamada dura más de 10 minutos cada minuto valga 50 céntimos.
Crear una condición que indique que si la llamada se hace el día domingo la llamada tenga un impuesto derl 3%
Crear una condición que indique que si la llamada se hace en un día diferente al domingo se aplique:
15% turno de 06:00am a 12:00m; 10% turno de 12:00m a 23:00pm; -10% turno de 23:00am a 05:59am; 
*/

//COMO LO HICE YO (SIN TERMINAR):
package es.cursojava.inicio;
import java.util.Scanner;

public class Ejercicio5{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
  
  System.out.print("Introduce duración de la llamada en minutos: ");
  int minutos = sc.nextInt();
  
  System.out.print("Introduce el día de la semana ( L , M , X , J , V , S , D ): ");
  String dia = sc.next();
  
  System.out.print("Introduce la hora de la llamada (0-23): ");
  int hora = sc.nextInt();
  
  
  double costoTotal = 0;
  
  int costo = 0;
  if (minutos > 0 && minutos <5){
	  costo += minutos * 1.0;
	  }else if(minutos > 5 && minutos < 8){
		  costo += 0.8; 
	  }else if (minutos > 8 & minutos < 10) 
	  {
  costo += 0.7; }else if (minutos > 10) { costo += 0.5; }
  
  
  double impuesto = 0;
  if (dia.equals("domingo")){
	  impuesto = 0.03; 
	  }else if (hora >= 6 && hora < 12){
		  impuesto = 1.15; }
	  else if (hora >= 12 && hora <  23) {
		  impuesto = 1.10; }
	  else {
		  impuesto = - 1.10;
		}
  }
}
  

  

