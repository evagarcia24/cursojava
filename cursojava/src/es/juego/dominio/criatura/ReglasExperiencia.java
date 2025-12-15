package es.juego.dominio.criatura;

/**
 * Servicio de dominio encargado de gestionar el aumento de experiencia de una
 * {@link Criatura}. Este servicio forma parte de la lógica interna del dominio
 * y opera directamente sobre la instancia mutable de {@link CriaturaBase},
 * garantizando que solo las reglas definidas dentro del paquete
 * {@code es.juego.dominio.criatura} puedan modificar la experiencia de una
 * criatura.
 *
 * La regla aplicada es sencilla:
 * <pre>
 *   XP = XP + 1
 * </pre>
 * El incremento se realiza de forma controlada mediante los setters de ámbito
 * package-private de la entidad, asegurando que ninguna capa externa pueda
 * alterar este valor directamente.
 *
 * Antes de aplicar la regla, el servicio valida que la criatura no sea nula.
 * No se crean nuevas instancias ni se utiliza el ensamblador; se actualiza el
 * estado existente de la criatura siguiendo el modelo de entidad mutable
 * controlada dentro del dominio.
 *
 * Responsabilidades principales:
 * <ul>
 *   <li>Validar la criatura recibida.</li>
 *   <li>Incrementar la experiencia en una cantidad fija.</li>
 *   <li>Modificar el estado interno exclusivamente mediante acceso permitido
 *       dentro del dominio.</li>
 *   <li>Garantizar que las capas externas solo puedan leer la experiencia,
 *       nunca modificarla.</li>
 * </ul>
 */

final class ReglasExperiencia {

    private static final int XP_POR_INVOKE = 1;

    /**
     * Incrementa la experiencia de la criatura en +1.
     *
     * Regla:
     *   XP = XP + 1
     */
    Criatura ganarExperiencia(Criatura criatura) {

        if (criatura == null)
            throw new IllegalArgumentException("La criatura no puede ser nula.");

        CriaturaBase c = (CriaturaBase) criatura;

        int xpNueva = c.getExperiencia() + XP_POR_INVOKE;
        c.setExperiencia(xpNueva);

        return c;
    }
}
