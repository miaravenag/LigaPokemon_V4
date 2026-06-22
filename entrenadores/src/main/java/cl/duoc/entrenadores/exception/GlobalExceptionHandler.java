package cl.duoc.entrenadores.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<cl.duoc.entrenadores.exception.ErrorResponse> errorDeValidacion(MethodArgumentNotValidException ex) {
        List<String> errores = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .toList();
        return ResponseEntity.badRequest().body(new cl.duoc.entrenadores.exception.ErrorResponse(
                400, "Error de validación", errores.toString(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<cl.duoc.entrenadores.exception.ErrorResponse> recursoNoEncontrado(RecursoNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new cl.duoc.entrenadores.exception.ErrorResponse(
                404, "No encontrado", ex.getMessage(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(RecursoDuplicadoException.class)
    public ResponseEntity<cl.duoc.entrenadores.exception.ErrorResponse> recursoDuplicado(RecursoDuplicadoException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new cl.duoc.entrenadores.exception.ErrorResponse(
                409, "Recurso duplicado", ex.getMessage(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(ValidacionNegocioException.class)
    public ResponseEntity<cl.duoc.entrenadores.exception.ErrorResponse> validacionNegocio(ValidacionNegocioException ex) {
        return ResponseEntity.status(HttpStatus.valueOf(422)).body(new cl.duoc.entrenadores.exception.ErrorResponse(
                422, "Regla de negocio no cumplida", ex.getMessage(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<cl.duoc.entrenadores.exception.ErrorResponse> errorGeneral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new cl.duoc.entrenadores.exception.ErrorResponse(
                500, "Error interno del servidor", ex.getMessage(), LocalDateTime.now()
        ));
    }
}