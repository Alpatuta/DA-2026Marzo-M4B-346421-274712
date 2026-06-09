package uy.edu.ort.obligatorioDA.dominio;

import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public class EstadoEstable extends EstadoCarrera {

    @Override
    public void abrir(Carrera carrera) throws ObligatorioException {
        throw new ObligatorioException("La carrera ya se encuentra Abierta/Estable.");
    }

    @Override
    public void cerrar(Carrera carrera) throws ObligatorioException {
        // Estable → Cerrada (válido)
        carrera.cambiarEstado(new EstadoCerrada());
    }

    @Override
    public void finalizar(Carrera carrera, Participacion ganador) throws ObligatorioException {
        throw new ObligatorioException("No se puede finalizar una carrera en estado Estable.");
    }

    @Override
    public boolean permiteApuestas() {
        return true;
    }

    @Override
    public void dividendoActualizado(Carrera carrera) throws ObligatorioException {
        // No se permite actualizar el dividendo en estado Estable
        if(!carrera.todosDividendosValidos()) {
            // Si algún dividendo es inválido, volver al estado Abierta
            carrera.cambiarEstado(new EstadoAbierta());
        }
    }
}
