////saldo = 500
////¿Por qué numero quieres apostar? (0-36),Si es otro numero numero se vuelve a formular la pregunta
////¿Cuánto dinero quieres apostar? Si el importe de la apuesta es > que el saldo disponible por el usuario, se notifica y se vuelve a formular la pregunta
////De manera aleatoria generar un nº entre 0 y 36
////Si el numero apostado es = al nº aleatorio, se multiplica lo apostado *36 y se suma al saldo no apostado
////Si no lo es le restamos del saldo la cantidad apostada
////Si tiene saldo le perguntamos ¿Quieres seguir jugando? si dice que no le indicamos el saldo con el que se va y si no tiene saldo le indicamos que se ha quedado sin dinero.
//package es.cursojava.inicio.bucles;
//
//import java.util.Random;
//import java.util.Scanner;
//
//public class RuletaCasinoFacil {
//
//	public static void main(String[] args) {
//		double saldo = 500;
//		double dineroApostado;
//		Scanner scan = new Scanner(System.in);
//		double numApostado = 0;
//		String seguirJugando;
//		do {
//			System.out.println("¿Cuánto dinero quiere apostar?");
//			dineroApostado = scan.nextInt();
//
//			if (dineroApostado > saldo) {
//				System.out.println(
//						"No tienes saldo suficiente. Introduce una cantidad igual o inferior a tu saldo que es: " + saldo);
//			}
//		} while (dineroApostado > saldo);
//		do {
//			System.out.println("Elija el número al quiere apostar (Del 0 al 36):");
//			numApostado = scan.nextInt();// Se guarda el numero apostado
//		} while (numApostado < 0 || numApostado > 36);
//
//		Random rand = new Random();
//		int numAleatorio = rand.nextInt(37); // Se genera numero aleatorio
//		System.out.println("La ruleta ha caido en " + numAleatorio);
//
//		if (numApostado == numAleatorio) {
//			System.out.println("Acertaste! 😀");
//			saldo = dineroApostado * 36 - dineroApostado;
//			System.out.println("Ahora tu saldo es de " + saldo);
//		} else {
//			System.out.println("Fallaste 🥴");
//			saldo -= dineroApostado;
//			System.out.println("Ahora tu saldo es de " + saldo);
//		}
//		do {
//			System.out.println("Deseas seguir jugando (si/no)? ");
//			scan = new Scanner(System.in);
//			seguirJugando = scan.nextLine();
//			if (seguirJugando.equalsIgnoreCase("no") && saldo > 0) {
//				System.out.println("Elija el número al quiere apostar (Del 0 al 36):");
//				numApostado = scan.nextInt();// Se guarda el numero apostado
//				numAleatorio = rand.nextInt(37); // Se genera numero aleatorio
//				System.out.println("La ruleta ha caido en " + numAleatorio);
//
//				if (numApostado == numAleatorio) {
//					System.out.println("Acertaste! 😀");
//					saldo = dineroApostado * 36 - dineroApostado;
//					System.out.println("Ahora tu saldo es de " + saldo);
//				} else {
//					System.out.println("Fallaste 🥴");
//					saldo -= dineroApostado;
//					System.out.println("Ahora tu saldo es de " + saldo);
//				}
//			}while (saldo > 0 && seguirJugando.equals("si"));
//		}
//	}
//}
