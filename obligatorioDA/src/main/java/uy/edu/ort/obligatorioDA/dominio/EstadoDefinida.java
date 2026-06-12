package uy.edu.ort.obligatorioDA.dominio;

import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public class EstadoDefinida extends EstadoCarrera {

    public EstadoDefinida() {
        super("DEFINIDA");
    }

    @Override
    public void abrir(Carrera carrera) throws ObligatorioException {
        
        carrera.cambiarEstado(new EstadoAbierta());
    }

    @Override
    public void cerrar(Carrera carrera) throws ObligatorioException {
        throw new ObligatorioException("No se puede cerrar una carrera en estado Definida.");
    }

    @Override
    public void finalizar(Carrera carrera, Participacion ganador) throws ObligatorioException {
        throw new ObligatorioException("No se puede finalizar una carrera en estado Definida.");
    }

    @Override
    public boolean permiteApuestas() {
        return false;
    }

	@Override
	public void dividendoActualizado(Carrera carrera) throws ObligatorioException {
		// No se permite actualizar el dividendo en estado Definida
		throw new ObligatorioException("No se puede actualizar el dividendo en estado Definida.");
	}
}
