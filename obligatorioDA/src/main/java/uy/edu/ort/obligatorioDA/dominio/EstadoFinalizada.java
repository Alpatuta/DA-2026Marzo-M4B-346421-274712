package uy.edu.ort.obligatorioDA.dominio;

import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public class EstadoFinalizada extends EstadoCarrera {

    @Override
    public void abrir(Carrera carrera) throws ObligatorioException {
        throw new ObligatorioException("No se puede abrir una carrera en estado Finalizada.");
    }

    @Override
    public void cerrar(Carrera carrera) throws ObligatorioException {
        throw new ObligatorioException("No se puede cerrar una carrera en estado Finalizada.");
    }

    @Override
    public void finalizar(Carrera carrera, Participacion ganador) throws ObligatorioException {
        throw new ObligatorioException("La carrera ya se encuentra Finalizada.");
    }

    @Override
    public boolean permiteApuestas() {
        return false;
    }
    @Override
    public void dividendoActualizado(Carrera carrera) throws ObligatorioException {
        // No se permite actualizar el dividendo en estado Finalizada
        throw new ObligatorioException("No se puede actualizar el dividendo en estado Finalizada.");  
    }
}
