package uy.edu.ort.obligatorioDA.excepciones;

/**
 * Excepción base de la aplicación.
 * Todas las excepciones de negocio heredan de esta clase.
 * Es lanzada por la capa de dominio (entidades) y atrapada
 * por el GlobalExceptionHandler en la capa de presentadores.
 */
public class ObligatorioException extends Exception {
    public ObligatorioException(String message) {
        super(message);
    }
}
