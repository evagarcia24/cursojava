package es.juego.dominio.criatura;

import es.juego.dominio.dado.Caras;
import es.juego.dominio.dado.Dados;
import es.juego.dominio.dado.Lanzador;

/**
 * Servicio de dominio responsable de resolver turnos completos de combate entre
 * dos criaturas, calculando el ataque, la defensa y aplicando el daño mediante
 * {@link ReglasVida}. Este servicio no imprime nada ni toma decisiones de flujo;
 * simplemente aplica las reglas del dominio y devuelve un {@link DTOResultadoCombate}.
 */
final class ReglasCombate {

    private final ReglasSumaItemsService sumador = new ReglasSumaItemsService();
    private final ReglasVida reglasVida = new ReglasVida();
    private static final Caras D10 = Dados.d10();

    /**
     * Resuelve un turno completo de combate entre atacante y defensor.
     * Calcula ataque, defensa y daño, aplica el daño mediante {@link ReglasVida}
     * y devuelve un Value Object con el resumen del turno.
     */
    DTOResultadoCombate combatir(
            Criatura atacante,
            Lanzador lanzadorAtaque,
            Criatura defensor,
            Lanzador lanzadorDefensa
    ) {
        if (atacante == null)
            throw new IllegalArgumentException("El atacante no puede ser nulo.");

        if (defensor == null)
            throw new IllegalArgumentException("El defensor no puede ser nulo.");

        if (lanzadorAtaque == null)
            throw new IllegalArgumentException("El lanzador de ataque no puede ser nulo.");

        if (lanzadorDefensa == null)
            throw new IllegalArgumentException("El lanzador de defensa no puede ser nulo.");

        CriaturaBase atacanteBase = (CriaturaBase) atacante;
        CriaturaBase defensorBase = (CriaturaBase) defensor;

        // 1. Cálculos internos
        int ataque = calcularAtaque(atacanteBase, lanzadorAtaque);
        int defensa = calcularDefensa(defensorBase, lanzadorDefensa);

        // 2. Daño final
        int dano = Math.max(0, ataque - defensa);

        // 3. Aplicar daño usando ReglasVida
        reglasVida.recibirDano(defensorBase, dano);

        int vidaRestante = defensorBase.getPuntosVida();
        boolean derrotado = vidaRestante <= 0;

        // 4. Devolver resultado
        return new DTOResultadoCombate(
                ataque,
                defensa,
                dano,
                vidaRestante,
                derrotado
        );
    }

    // ------------------------------------------------------------
    // Métodos internos privados — no validan nada
    // ------------------------------------------------------------

    private int calcularAtaque(CriaturaBase c, Lanzador lanzador) {
        int tirada = lanzador.lanzar(D10);
        int nivel = c.getExperiencia();
        int fuerza = c.getRaza().getFuerza();
        int sumaArmas = sumador.sumarPuntos(c.armas);
        return tirada * nivel + sumaArmas + fuerza;
    }

    private int calcularDefensa(CriaturaBase c, Lanzador lanzador) {
        int tirada = lanzador.lanzar(D10);
        int nivel = c.getExperiencia();
        int resistencia = c.getRaza().getResistencia();
        int sumaEscudos = sumador.sumarPuntos(c.escudos);
        return tirada * nivel + sumaEscudos + resistencia;
    }
}
