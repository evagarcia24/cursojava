package es.juego.dominio.criatura;

import java.util.List;

import es.juego.dominio.dado.Lanzador;
import es.juego.dominio.item.Item;
import es.juego.dominio.raza.Raza;

/**
 * Fachada estática del dominio encargada de exponer todas las operaciones
 * permitidas sobre una {@link Criatura}. Esta clase actúa como punto de
 * entrada seguro hacia los servicios de dominio que gestionan la creación,
 * combate, uso de pociones, vida y experiencia.
 *
 * Su función es simplificar el uso del dominio para capas externas como la
 * aplicación o la UI, evitando que estas deban conocer la estructura interna
 * o los servicios específicos del paquete. Ninguna regla de negocio se
 * implementa aquí: todas las operaciones se delegan a los servicios
 * correspondientes.
 *
 * La entidad {@link Criatura} es mutable únicamente dentro del paquete
 * {@code es.juego.dominio.criatura}, por lo que esta fachada expone una API
 * segura que respeta los límites del dominio.
 *
 * Servicios expuestos:
 * <ul>
 *   <li>Creación de criaturas</li>
 *   <li>Resolución de turnos de combate</li>
 *   <li>Aplicación de pociones</li>
 *   <li>Gestión de vida (daño, curación, aumento de vida máxima)</li>
 *   <li>Incremento de experiencia</li>
 * </ul>
 *
 * Esta clase no puede instanciarse.
 */
public final class Criaturas {

    private static final CriaturaAssembler assembler      = new CriaturaAssembler();
    private static final ReglasCombate reglasCombate      = new ReglasCombate();
    private static final ReglasPociones reglasPociones    = new ReglasPociones();
    private static final ReglasVida reglasVida            = new ReglasVida();
    private static final ReglasExperiencia reglasXP       = new ReglasExperiencia();

    private Criaturas() {}

    // ============================================================
    // Creación
    // ============================================================

    /**
     * Crea una nueva instancia de {@link Criatura} utilizando los valores
     * proporcionados. Esta operación delega en {@link CriaturaAssembler},
     * responsable de validar los parámetros mínimos y aislar el estado interno.
     *
     * @param nombre nombre de la criatura
     * @param experiencia nivel o experiencia inicial
     * @param raza raza asociada a la criatura
     * @param pv puntos de vida actuales
     * @param pvMax puntos de vida máximos
     * @param armas lista inicial de armas
     * @param escudos lista inicial de escudos
     * @param pociones lista inicial de pociones
     * @return una criatura válida y completamente inicializada
     */
    public static Criatura crear(
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
            List<Item> inventarioPasivoPociones) {

        return assembler.crear(nombre, experiencia, raza, pv, pvMax, armas, escudos, pociones,
                inventarioPasivoArmas,
                inventarioPasivoEscudos,
                inventarioPasivoPociones);
    }

    // ============================================================
    // Combate
    // ============================================================

    /**
     * Resuelve un turno de combate entre un atacante y un defensor.
     * Calcula ataque, defensa, daño y modifica el estado del defensor
     * aplicando las reglas definidas en el dominio. Devuelve un
     * {@link DTOResultadoCombate} que contiene toda la información relevante
     * para presentar o registrar lo ocurrido.
     *
     * @param atacante criatura que realiza el ataque
     * @param lanzadorAtaque lanzador usado para la tirada de ataque
     * @param defensor criatura que recibe el ataque
     * @param lanzadorDefensa lanzador usado para la tirada de defensa
     * @return objeto inmutable con el resultado del turno de combate
     */
    public static DTOResultadoCombate combatir(
            Criatura atacante,
            Lanzador lanzadorAtaque,
            Criatura defensor,
            Lanzador lanzadorDefensa
    ) {
        return reglasCombate.combatir(
                atacante,
                lanzadorAtaque,
                defensor,
                lanzadorDefensa
        );
    }

    // ============================================================
    // Pociones
    // ============================================================

    /**
     * Aplica una poción a la criatura, ajustando sus puntos de vida
     * y eliminando la poción usada del inventario. Delegado en
     * {@link ReglasPociones}.
     *
     * @param c criatura a la que se aplica la poción
     * @param pocion poción a consumir
     * @return la misma criatura con su estado actualizado
     */
    public static Criatura aplicarPocion(Criatura c, Item pocion) {
        return reglasPociones.aplicar(c, pocion);
    }

    // ============================================================
    // Vida
    // ============================================================

    /**
     * Aplica daño a la criatura según la regla {@code PV = max(0, PV - daño)}.
     * Delegado en {@link ReglasVida}.
     *
     * @param c criatura que recibe el daño
     * @param dano puntos de daño a aplicar (no negativos)
     * @return la misma criatura con su vida actualizada
     */
    public static Criatura recibirDano(Criatura c, int dano) {
        return reglasVida.recibirDano(c, dano);
    }

    /**
     * Cura la criatura según la regla {@code PV = min(PVmax, PV + puntos)}.
     * Delegado en {@link ReglasVida}.
     *
     * @param c criatura a curar
     * @param puntos puntos de curación (no negativos)
     * @return la misma criatura con su vida actualizada
     */
    public static Criatura curar(Criatura c, int puntos) {
        return reglasVida.curar(c, puntos);
    }

    /**
     * Incrementa la vida máxima en +10 y ajusta la vida actual al nuevo máximo.
     * Delegado en {@link ReglasVida}.
     *
     * @param c criatura sobre la que se aplica el aumento de vida máxima
     * @return la misma criatura con su vida y vida máxima actualizadas
     */
    public static Criatura aumentarVidaMax(Criatura c) {
        return reglasVida.aumentarVidaMax(c);
    }

    // ============================================================
    // Experiencia
    // ============================================================

    /**
     * Incrementa la experiencia de la criatura según la regla
     * {@code XP = XP + 1}. Delegado en {@link ReglasExperiencia}.
     *
     * @param c criatura que gana experiencia
     * @return la misma criatura con su experiencia actualizada
     */
    public static Criatura ganarExperiencia(Criatura c) {
        return reglasXP.ganarExperiencia(c);
    }
    
    /**
     * Crea una copia independiente de la criatura proporcionada,
     * preservando su estado actual (nombre, experiencia, raza,
     * puntos de vida, vida máxima, equipamiento activo e inventario
     * pasivo). Esta operación delega en {@link CriaturaAssembler},
     * responsable de reconstruir el estado interno de manera segura.
     *
     * La copia resultante no comparte ninguna referencia mutable con
     * la criatura original; todas las colecciones internas se
     * replican mediante copias defensivas. Esto permite utilizar la
     * criatura duplicada como snapshot de capítulo, registro histórico
     * o punto de restauración sin riesgo de interferencias con el
     * estado vivo del modelo.
     *
     * No se aplica ninguna lógica de negocio durante la copia: la
     * operación es una réplica estructural del estado, no una
     * transformación ni un cálculo derivado.
     *
     * @param original criatura cuyo estado debe duplicarse
     * @return una nueva criatura con el mismo estado que {@code original},
     *         independiente y totalmente aislada de la instancia original
     */
    public static Criatura copiar(Criatura original) {
        return assembler.copiar(original);
    }

}
