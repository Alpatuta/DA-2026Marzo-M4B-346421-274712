package uy.edu.ort.obligatorioDA.dominio;

import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public class EstadoAbierta extends EstadoCarrera {

    public EstadoAbierta() {
        super("ABIERTA");
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
