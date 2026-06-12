package uy.edu.ort.obligatorioDA.dominio;

import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public class EstadoAbierta extends EstadoCarrera {

    public EstadoAbierta() {
        super("ABIERTA");
    }

    @Override
    public void abrir(Carrera carrera) throws ObligatorioException {

        throw new ObligatorioException("La carrera ya se encuentra Abierta.");
    }

    @Override
    public void cerrar(Carrera carrera) throws ObligatorioException {
        // No se puede cerrar estando Abierta: debe estar Estable primero
        throw new ObligatorioException(
                "No se puede cerrar la carrera: hay caballos con dividendo inválido. " +
                        "La carrera debe estar en estado Estable para poder cerrarse.");
    }

    @Override
    public void finalizar(Carrera carrera, Participacion ganador) throws ObligatorioException {
        throw new ObligatorioException("No se puede finalizar una carrera en estado Abierta.");
    }

    @Override
    public boolean permiteApuestas() {
        return true;
    }

    @Override
    public void dividendoActualizado(Carrera carrera) throws ObligatorioException {
        // Verificar si todos los caballos tienen un dividendo válido
        if (carrera.todosDividendosValidos()) {
            // Si todos los dividendos son válidos, cambiar el estado a Estable
            carrera.cambiarEstado(new EstadoEstable());
        }
    }
}
