package es.juego.dominio.criatura;

/**
 * Servicio de dominio responsable de gestionar todas las reglas relacionadas
 * con los puntos de vida de una {@link Criatura}. Opera exclusivamente sobre
 * instancias de {@link CriaturaBase}, aprovechando la visibilidad de paquete
 * para modificar de forma segura el estado interno de la entidad sin exponer
 * setters a capas externas como la aplicación o la UI.
 *
 * Este servicio implementa las tres reglas fundamentales asociadas a la vida:
 *
 * <ul>
 *   <li><strong>recibirDano</strong>: reduce los puntos de vida sin permitir
 *       valores negativos. Si la operación intenta llevar la vida por debajo
 *       de cero, se corrige el valor a 0 según la regla del dominio.</li>
 *
 *   <li><strong>curar</strong>: incrementa los puntos de vida sin superar el
 *       máximo permitido. Si la operación intenta exceder el PV máximo, el
 *       valor se corrige automáticamente al máximo.</li>
 *
 *   <li><strong>aumentarVidaMax</strong>: incrementa la vida máxima en un
 *       valor fijo y establece automáticamente la vida actual al nuevo máximo.</li>
 * </ul>
 *
 * Internamente, el servicio delega las validaciones en métodos privados que
 * lanzan excepciones específicas del dominio:
 * <ul>
 *   <li>{@link VidaPorDebajoDeCeroException}</li>
 *   <li>{@link VidaPorEncimaDelMaximoException}</li>
 * </ul>
 *
 * Las reglas públicas capturan dichas excepciones para aplicar las correcciones
 * apropiadas siguiendo las invariantes del modelo, ofreciendo así una API
 * limpia, consistente y segura para el resto del dominio.
 *
 * Este servicio no crea nuevas instancias de criatura; trabaja directamente
 * sobre la instancia existente siguiendo el modelo de entidad mutable protegida.
 */
final class ReglasVida {

    private static final int AUMENTO_VIDA_MAX = 10;

    // ===========================================================
    // Validadores internos — solo lanzan excepciones
    // ===========================================================

    /**
     * Valida que los puntos de vida no queden por debajo de 0.
     *
     * @param pvNuevo valor resultante tras aplicar la regla
     * @throws VidaPorDebajoDeCeroException si pvNuevo &lt; 0
     */
    private void validarNoEsNegativo(int pvNuevo) {
        if (pvNuevo < 0)
            throw new VidaPorDebajoDeCeroException("Los puntos de vida quedarían por debajo de 0.");
    }

    /**
     * Valida que los puntos de vida no superen el máximo permitido.
     *
     * @param pvNuevo valor resultante tras aplicar la regla
     * @param pvMax máximo permitido
     * @throws VidaPorEncimaDelMaximoException si pvNuevo &gt; pvMax
     */
    private void validarNoSuperaMaximo(int pvNuevo, int pvMax) {
        if (pvNuevo > pvMax)
            throw new VidaPorEncimaDelMaximoException("Los puntos de vida superarían el máximo permitido.");
    }

    // ===========================================================
    // Reglas públicas
    // ===========================================================

    /**
     * Aplica daño a la criatura según la regla:
     * <pre>
     *     PV = max(0, PV - daño)
     * </pre>
     *
     * Si la operación excede el límite inferior (PV &lt; 0), la vida se
     * corrige automáticamente a 0.
     *
     * @param criatura criatura que recibe daño
     * @param dano puntos de daño a aplicar (no negativos)
     * @return la misma instancia de criatura con su vida actualizada
     */
    Criatura recibirDano(Criatura criatura, int dano) {

        if (criatura == null)
            throw new IllegalArgumentException("La criatura no puede ser nula.");

        if (dano < 0)
            throw new IllegalArgumentException("El daño no puede ser negativo.");

        CriaturaBase c = (CriaturaBase) criatura;

        int pvActual = c.getPuntosVida();
        int pvNuevo = pvActual - dano;

        try {
            validarNoEsNegativo(pvNuevo);
            c.setPuntosVida(pvNuevo);
        } catch (VidaPorDebajoDeCeroException e) {
            c.setPuntosVida(0);
        }

        return c;
    }

    /**
     * Cura a la criatura sin superar su máximo de vida según la regla:
     * <pre>
     *     PV = min(PVmax, PV + puntos)
     * </pre>
     *
     * Si la operación excede el límite superior (PV &gt; PVmax), la vida se
     * corrige automáticamente al valor máximo.
     *
     * @param criatura criatura a curar
     * @param puntos puntos de curación (no negativos)
     * @return la misma instancia de criatura con su vida actualizada
     */
    Criatura curar(Criatura criatura, int puntos) {

        if (criatura == null)
            throw new IllegalArgumentException("La criatura no puede ser nula.");

        if (puntos < 0)
            throw new IllegalArgumentException("Los puntos de curación no pueden ser negativos.");

        CriaturaBase c = (CriaturaBase) criatura;

        int pvActual = c.getPuntosVida();
        int pvMax = c.getPuntosVidaMax();
        int pvNuevo = pvActual + puntos;

        try {
            validarNoSuperaMaximo(pvNuevo, pvMax);
            c.setPuntosVida(pvNuevo);
        } catch (VidaPorEncimaDelMaximoException e) {
            c.setPuntosVida(pvMax);
        }

        return c;
    }

    /**
     * Incrementa la vida máxima en un valor fijo y establece la vida actual
     * al nuevo máximo según la regla:
     * <pre>
     *     PVmax = PVmax + incremento
     *     PV    = PVmax
     * </pre>
     *
     * @param criatura criatura a la que se aumenta la vida máxima
     * @return la misma instancia de criatura con su vida y vida máxima actualizadas
     */
    Criatura aumentarVidaMax(Criatura criatura) {

        if (criatura == null)
            throw new IllegalArgumentException("La criatura no puede ser nula.");

        CriaturaBase c = (CriaturaBase) criatura;

        int nuevoMax = c.getPuntosVidaMax() + AUMENTO_VIDA_MAX;

        c.setPuntosVidaMax(nuevoMax);
        c.setPuntosVida(nuevoMax);

        return c;
    }
}
