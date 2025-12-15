package es.juego.dominio.criatura;

@SuppressWarnings("serial")
final class VidaPorDebajoDeCeroException extends RuntimeException {
    VidaPorDebajoDeCeroException(String msg) {
        super(msg);
    }
}
