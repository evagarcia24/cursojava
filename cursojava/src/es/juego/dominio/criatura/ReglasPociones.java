package es.juego.dominio.criatura;

import es.juego.dominio.item.Item;

/**
 * Servicio de dominio responsable de aplicar los efectos de una poción sobre
 * una {@link Criatura}.
 */
final class ReglasPociones {

    private final ReglasVida reglasVida = new ReglasVida();

    /**
     * Aplica una poción a la criatura, delegando el incremento de vida en
     * {@link ReglasVida#curar}, garantizando que los puntos permanecen en
     * rangos válidos. Tras ser usada, la poción se retira del inventario activo
     * y pasa al inventario pasivo (lista de pociones consumidas).
     *
     * @param criatura criatura que consume la poción
     * @param pocion poción a aplicar
     * @return la misma criatura, con vida actualizada y la poción movida a inventario pasivo
     * @throws IllegalArgumentException si criatura o poción son nulas,
     *         o si la criatura no posee dicha poción
     */
    Criatura aplicar(Criatura criatura, Item pocion) {

        if (criatura == null)
            throw new IllegalArgumentException("La criatura no puede ser nula.");

        if (pocion == null)
            throw new IllegalArgumentException("La poción no puede ser nula.");

        // Acceso a listas internas mutables
        CriaturaBase c = (CriaturaBase) criatura;

        if (!c.pociones.contains(pocion)) {
            throw new IllegalArgumentException("La criatura no posee la poción indicada.");
        }

        // Curación delegada en ReglasVida
        reglasVida.curar(c, pocion.getPuntos());

        // 1) Retirar la poción del inventario activo
        c.pociones.remove(pocion);

        // 2) Añadirla al inventario pasivo de pociones
        c.inventarioPasivoPociones.add(pocion);

        return c;
    }
}
