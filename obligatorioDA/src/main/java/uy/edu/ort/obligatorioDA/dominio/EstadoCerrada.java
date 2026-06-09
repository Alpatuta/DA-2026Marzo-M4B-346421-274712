package uy.edu.ort.obligatorioDA.dominio;

import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public class EstadoCerrada extends EstadoCarrera {

    @Override
    public void abrir(Carrera carrera) throws ObligatorioException {
        throw new ObligatorioException("No se puede abrir una carrera en estado Cerrada.");
    }

    @Override
    public void cerrar(Carrera carrera) throws ObligatorioException {
        throw new ObligatorioException("La carrera ya se encuentra Cerrada.");
    }

    @Override
    public void finalizar(Carrera carrera, Participacion ganador) throws ObligatorioException {
        // Cerrada → Finalizada (válido): asigna ganador y cambia estado
        carrera.setGanador(ganador);
        carrera.cambiarEstado(new EstadoFinalizada());
    }

    @Override
    public boolean permiteApuestas() {
        return false;
    }

    @Override   
    public void dividendoActualizado(Carrera carrera) throws ObligatorioException {
        // No se permite actualizar el dividendo en estado Cerrada
        throw new ObligatorioException("No se puede actualizar el dividendo en estado Cerrada.");
    }

}
