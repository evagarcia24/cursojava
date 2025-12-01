package es.cursojava.interfaces.ejercicios.colecciones.supermercado;

public class Alimento {

    private String nombre;
    private int cantDisponible;
    private double precio;

    public Alimento(String nombre, int cantDisponible, double precio) {
        this.nombre = nombre;
        this.cantDisponible = cantDisponible;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantDisponible() {
        return cantDisponible;
    }

    public void setCantDisponible(int cantDisponible) {
        this.cantDisponible = cantDisponible;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public boolean restarUnidad() {
        if (cantDisponible > 0) {
            cantDisponible--;
            return true;
        }
        return false;
    }
}
