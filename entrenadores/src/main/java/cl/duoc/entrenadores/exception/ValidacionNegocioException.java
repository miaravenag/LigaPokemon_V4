package cl.duoc.entrenadores.exception;

public class ValidacionNegocioException extends RuntimeException {
    public ValidacionNegocioException(String mensaje) {
        super(mensaje);
    }
}