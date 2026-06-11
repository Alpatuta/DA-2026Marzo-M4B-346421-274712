package uy.edu.ort.obligatorioDA.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Manejador global de excepciones de la aplicación.
 * Atrapa todas las ObligatorioException lanzadas desde el dominio
 * y devuelve una respuesta con status 299 al cliente.
 * La vista invoca mostrarMensajeDeError() al recibir un status 299.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObligatorioException.class)
    public ResponseEntity<String> manejarExcepcion(ObligatorioException e) {
        return ResponseEntity.status(299).body(e.getMessage());
    }
}
