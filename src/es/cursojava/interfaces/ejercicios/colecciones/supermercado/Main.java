package es.cursojava.interfaces.ejercicios.colecciones.supermercado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear alimentos con nombre, unidades disponibles y precio por unidad
        Platano platano1 = new Platano("Platano Oferta", 15, 1.50);
        Platano platano2 = new Platano("Platano maduro", 10, 2.50);
        Platano platano3 = new Platano("Platano Canarias", 8, 3.50);

        Pimiento pimiento1 = new Pimiento("Pimiento rojo", 12, 1.50);
        Pimiento pimiento2 = new Pimiento("Pimiento verde", 10, 1.80);
        Pimiento pimiento3 = new Pimiento("Pimiento padrón", 6, 2.50);

        Carne carne1 = new Carne("Carne picada", 5, 9.99);
        Carne carne2 = new Carne("Carne cerdo", 4, 5.99);
        Carne carne3 = new Carne("Cordero entero", 2, 49.99);

        // Crear listas de alimentos
        List<Alimento> lista1 = new ArrayList<>(Arrays.asList(platano1, platano2, platano3));
        List<Alimento> lista2 = new ArrayList<>(Arrays.asList(pimiento1, pimiento2, pimiento3));
        List<Alimento> lista3 = new ArrayList<>(Arrays.asList(carne1, carne2, carne3));

        List<List<Alimento>> stockInicial = new ArrayList<>();
        stockInicial.add(lista1);
        stockInicial.add(lista2);
        stockInicial.add(lista3);

        // Crear clientes
        ClienteSupermercado cliente1 = new ClienteSupermercado();
        cliente1.setNombre("Lucía");

        ClienteSupermercado cliente2 = new ClienteSupermercado();
        cliente2.setNombre("Carlos");

        ClienteSupermercado cliente3 = new ClienteSupermercado();
        cliente3.setNombre("María");

        Set<ClienteSupermercado> clientesIniciales = new LinkedHashSet<>();
        clientesIniciales.add(cliente1);
        clientesIniciales.add(cliente2);
        clientesIniciales.add(cliente3);

        // Crear supermercado
        Supermercado supermercado = new Supermercado("Supermercado Madrid", stockInicial, clientesIniciales);

        // Bucle por cada cliente
        for (ClienteSupermercado cliente : supermercado.getClientes()) {
            System.out.println("\n🛒 Bienvenida/o al " + supermercado.getNombre() + ", " + cliente.getNombre());

            boolean seguirComprando = true;

            while (seguirComprando) {
                // Mostrar stock
                System.out.println("\n📦 Stock disponible:");
                mostrarStock(supermercado);

                // Preguntar producto
                System.out.print("\n¿Qué producto quieres comprar? ");
                String productoBuscado = scanner.nextLine();

                Alimento productoSeleccionado = buscarYRestarUnidad(supermercado, productoBuscado);

                if (productoSeleccionado != null) {
                    cliente.getCarritoCompra().add(productoSeleccionado);
                    System.out.println("✅ Añadido al carrito: " + productoSeleccionado.getNombre());
                } else {
                    System.out.println("❌ Producto no encontrado o agotado.");
                }

                // Preguntar si quiere seguir
                System.out.print("\n¿Quieres comprar otro producto? (s / n): ");
                String respuesta = scanner.nextLine().trim().toLowerCase();
                seguirComprando = respuesta.equals("s");
            }

            // Mostrar carrito y total
            System.out.println("\n🧺 Carrito de " + cliente.getNombre() + ":");
            double total = 0;
            for (Alimento alimento : cliente.getCarritoCompra()) {
                System.out.println("- " + alimento.getNombre() + ": " + alimento.getPrecio() + " €");
                total += alimento.getPrecio();
            }
            System.out.println("💳 Total a pagar: " + total + "€");
        }

        scanner.close();
    }

    public static void mostrarStock(Supermercado supermercado) {
        for (List<Alimento> lista : supermercado.getStockAlimentos()) {
            for (Alimento alimento : lista) {
                System.out.println("* " + alimento.getNombre() +
                        " | Unidades: " + alimento.getCantDisponible() +
                        " | Precio: " + alimento.getPrecio() + " €");
            }
        }
    }

    public static Alimento buscarYRestarUnidad(Supermercado supermercado, String nombreProducto) {
        for (List<Alimento> lote : supermercado.getStockAlimentos()) {
            for (Alimento alimento : lote) {
                if (alimento.getNombre().equalsIgnoreCase(nombreProducto)) {
                    if (alimento.restarUnidad()) {
                        // Añadir una copia con 1 unidad al carrito
                        return new Alimento(alimento.getNombre(), 1, alimento.getPrecio());
                    }
                }
            }
        }
        return null;
    }
}