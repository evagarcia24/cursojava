package es.juego.dominio.criatura;

/**
 * Value Object que representa el resultado de un turno de combate entre dos criaturas.
 * Contiene toda la información necesaria para que capas superiores (como la UI
 * o los flujos de aplicación) puedan mostrar o registrar lo ocurrido sin necesidad
 * de recalcular nada.
 *
 * Este objeto es inmutable y refleja un único instante del combate.
 */
public record DTOResultadoCombate(
        int ataque,
        int defensa,
        int dano,
        int vidaRestanteDefensor,
        boolean defensorDerrotado
) {}
