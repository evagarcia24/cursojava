//En una clase 
//+ Escribe un método que reciba un array de Strings con nombres y devuelva el número de nombres que empiecen por A y contengan una t
//+ Desde el main generar el array con los nombres y llamar al método anterior, indicar cuantos nombres cumplen esa condición-

package utils;

public class Nombres {

    public static void main(String[] args) {
        String[] nombresUsuarios = { "Antonio", "Laura", "Tamara", "Rocio", "Anita" };
        
        int resultado = nombresFiltro(nombresUsuarios);
        System.out.println("Cantidad de nombres que cumplen la condición: " + resultado);
    }

    public static int nombresFiltro(String[] nombres) {
        int contador = 0;

        for (String nombre : nombres) {
            if (nombre.toLowerCase().startsWith("A") && nombre.toLowerCase().contains("t")) {
                contador++;
            }
        }

        return contador;
    }
}
