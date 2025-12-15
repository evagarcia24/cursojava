package es.juego.dominio.criatura;

import java.util.ArrayList;
import java.util.List;

import es.juego.dominio.item.Item;
import es.juego.dominio.raza.Raza;
import lombok.Getter;

/**
 * Implementación base de {@link Criatura}. Actúa como entidad central del
 * dominio para representar criaturas, encapsulando exclusivamente su estado
 * interno sin aplicar reglas de negocio ni lógica asociada al combate, vida,
 * experiencia o uso de objetos.
 *
 * Esta clase combina atributos inmutables (como nombre o raza) con otros que
 * pueden modificarse únicamente desde los servicios de dominio ubicados en este
 * mismo paquete (puntos de vida, vida máxima, experiencia y contenido de las
 * colecciones internas). Esto garantiza que la mutabilidad esté estrictamente
 * controlada y nunca expuesta hacia capas externas.
 *
 * Las colecciones internas que representan el equipamiento activo
 * (armas, escudos, pociones) y el inventario pasivo se copian de forma
 * defensiva en el constructor para evitar que estructuras externas modifiquen
 * accidentalmente la entidad. Asimismo, los getters devuelven copias
 * inmutables mediante {@code List.copyOf(...)} asegurando que ninguna capa
 * externa pueda alterar directamente el estado interno.
 *
 * El inventario pasivo se modela como tres colecciones paralelas para armas,
 * escudos y pociones, siguiendo exactamente la misma estructura que el
 * equipamiento activo. Este inventario pasivo representa objetos que la
 * criatura no tiene equipados durante el combate pero que conserva para otros
 * procesos del juego (loot, recompensas, progresión, almacenamiento personal,
 * etc.).
 *
 * Los servicios del dominio situados en el paquete
 * {@code es.juego.dominio.criatura} pueden modificar el estado real mediante
 * acceso directo a las listas internas mutables y a los setters de ámbito
 * package-private. Esto permite que las reglas del juego manipulen la criatura
 * sin comprometer la integridad del modelo hacia el exterior.
 *
 * Responsabilidades principales:
 * <ul>
 *   <li>Almacenar el estado fundamental, coherente y aislado de una criatura.</li>
 *   <li>Proteger el equipamiento interno mediante copias defensivas y getters inmutables.</li>
 *   <li>Permitir modificaciones solo desde las reglas de dominio del paquete.</li>
 *   <li>No incorporar ninguna lógica de negocio; únicamente mantener estado.</li>
 * </ul>
 */
@Getter
class CriaturaBase implements Criatura {

    private final String nombre;
    private int experiencia;
    private final Raza raza;

    private int puntosVida;
    private int puntosVidaMax;

    // equipamiento activo
    final List<Item> armas;
    final List<Item> escudos;
    final List<Item> pociones;

    // inventario pasivo
    final List<Item> inventarioPasivoArmas;
    final List<Item> inventarioPasivoEscudos;
    final List<Item> inventarioPasivoPociones;


    CriaturaBase(
            String nombre,
            int experiencia,
            Raza raza,
            int pv,
            int pvMax,
            List<Item> armas,
            List<Item> escudos,
            List<Item> pociones,
            List<Item> inventarioPasivoArmas,
            List<Item> inventarioPasivoEscudos,
            List<Item> inventarioPasivoPociones
    ) {
        this.nombre = nombre;
        this.experiencia = experiencia;
        this.raza = raza;
        this.puntosVida = pv;
        this.puntosVidaMax = pvMax;

        // equipamiento activo – copias defensivas
        this.armas = new ArrayList<>(armas);
        this.escudos = new ArrayList<>(escudos);
        this.pociones = new ArrayList<>(pociones);

        // inventario pasivo – copias defensivas
        this.inventarioPasivoArmas    = new ArrayList<>(inventarioPasivoArmas);
        this.inventarioPasivoEscudos  = new ArrayList<>(inventarioPasivoEscudos);
        this.inventarioPasivoPociones = new ArrayList<>(inventarioPasivoPociones);
    }


    // setters mutables de acceso solo desde este paquete
    void setPuntosVida(int pv) {
        this.puntosVida = pv;
    }

    void setPuntosVidaMax(int pvMax) {
        this.puntosVidaMax = pvMax;
    }

    void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }


    // getters inmutables del equipamiento activo
    @Override
    public List<Item> getArmas() {
        return List.copyOf(armas);
    }

    @Override
    public List<Item> getEscudos() {
        return List.copyOf(escudos);
    }

    @Override
    public List<Item> getPociones() {
        return List.copyOf(pociones);
    }


    // getters inmutables del inventario pasivo
    @Override
    public List<Item> getInventarioPasivoArmas() {
        return List.copyOf(inventarioPasivoArmas);
    }

    @Override
    public List<Item> getInventarioPasivoEscudos() {
        return List.copyOf(inventarioPasivoEscudos);
    }

    @Override
    public List<Item> getInventarioPasivoPociones() {
        return List.copyOf(inventarioPasivoPociones);
    }
}
