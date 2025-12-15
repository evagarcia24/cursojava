package es.juego.dominio.criatura;

import java.util.List;
import es.juego.dominio.item.Item;
import es.juego.dominio.raza.Raza;

/**
 * Ensamblador encargado de construir instancias de {@link Criatura}
 * a partir de los valores proporcionados por la capa de aplicación.
 *
 * Valida las invariantes esenciales del modelo (nombre, raza, puntos
 * de vida, equipamiento, experiencia) para garantizar que ninguna
 * criatura inválida pueda construirse dentro del dominio. El objetivo
 * es asegurar que todas las instancias creadas cumplen siempre las
 * restricciones estructurales mínimas del juego.
 *
 * No contiene reglas de negocio ni lógica asociada al combate, vida,
 * experiencia o uso de objetos; dichas responsabilidades pertenecen
 * a los servicios de dominio. Este ensamblador opera únicamente como
 * constructor controlado del estado interno de una criatura.
 *
 * Las colecciones proporcionadas (armas, escudos, pociones) se copian
 * de forma defensiva antes de delegar en la implementación concreta,
 * evitando que la instancia resultante comparta referencias mutables
 * con estructuras externas. Esto garantiza el aislamiento del estado
 * interno y la integridad del equipamiento.
 *
 * Características principales:
 * <ul>
 *   <li>Centraliza la creación de criaturas y su validación inicial.</li>
 *   <li>Protege el dominio frente a valores nulos o inconsistentes.</li>
 *   <li>Aplica copias defensivas para evitar fugas de mutabilidad.</li>
 *   <li>Devuelve siempre una instancia válida y lista para el uso en
 *       el resto del dominio.</li>
 * </ul>
 */

final class CriaturaAssembler {

    public Criatura crear(
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
        // ============================
        // Validaciones esenciales
        // ============================
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la criatura no puede ser nulo ni vacío.");
        }

        if (raza == null) {
            throw new IllegalArgumentException("La raza no puede ser nula.");
        }

        if (experiencia < 1) {
            throw new IllegalArgumentException("La experiencia no puede ser menor que 1.");
        }

        if (pvMax <= 0) {
            throw new IllegalArgumentException("Los puntos de vida máximos deben ser positivos.");
        }

        if (pv < 0 || pv > pvMax) {
            throw new IllegalArgumentException("Los puntos de vida iniciales deben estar entre 0 y pvMax.");
        }

        if (armas == null || escudos == null || pociones == null 
        		|| inventarioPasivoArmas == null 
        		|| inventarioPasivoEscudos == null 
        		|| inventarioPasivoPociones == null) {
            throw new IllegalArgumentException("Las colecciones de equipamiento no pueden ser nulas.");
        }

        if (armas.contains(null) || escudos.contains(null) || pociones.contains(null)
                || inventarioPasivoArmas.contains(null)
                || inventarioPasivoEscudos.contains(null)
                || inventarioPasivoPociones.contains(null)) {
            throw new IllegalArgumentException("Las colecciones de equipamiento no pueden contener elementos nulos.");
        }

        // ============================
        // Construcción segura
        // ============================
        return new CriaturaBase(
                nombre,
                experiencia,
                raza,
                pv,
                pvMax,
                List.copyOf(armas),
                List.copyOf(escudos),
                List.copyOf(pociones),
                List.copyOf(inventarioPasivoArmas),
                List.copyOf(inventarioPasivoEscudos),
                List.copyOf(inventarioPasivoPociones)
        );
    }
    
    /**
     * Construye una copia estructural de la criatura especificada,
     * duplicando todos sus valores internos (nombre, experiencia,
     * raza, puntos de vida, vida máxima, equipamiento activo e
     * inventario pasivo) mediante un nuevo objeto del dominio.
     *
     * Esta operación no se limita a clonar referencias: todas las
     * colecciones se reproducen mediante copias defensivas para
     * asegurar que la criatura resultante quede completamente
     * aislada del estado mutable original. De esta forma, cualquier
     * modificación posterior realizada sobre la copia o sobre la
     * instancia fuente no puede afectar a la otra.
     *
     * El método no introduce reglas de negocio ni cálculos derivados;
     * su único propósito es reconstruir de manera segura una nueva
     * criatura con el mismo estado observable que la original. Es
     * especialmente útil para generar snapshots de capítulo,
     * respaldos de estado o restauraciones internas en el flujo de
     * la historia.
     *
     * @param c instancia original a copiar
     * @return una nueva criatura con el mismo estado que {@code c},
     *         protegida mediante copias defensivas de todas sus colecciones
     */
    Criatura copiar(Criatura c) {
        return new CriaturaBase(
            c.getNombre(),
            c.getExperiencia(),
            c.getRaza(),
            c.getPuntosVida(),
            c.getPuntosVidaMax(),
            c.getArmas(),
            c.getEscudos(),
            c.getPociones(),
            c.getInventarioPasivoArmas(),
            c.getInventarioPasivoEscudos(),
            c.getInventarioPasivoPociones()
        );
    }

}