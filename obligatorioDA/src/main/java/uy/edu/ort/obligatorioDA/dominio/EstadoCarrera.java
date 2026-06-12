package uy.edu.ort.obligatorioDA.dominio;

import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public abstract class EstadoCarrera {

	public String nombre;

	public String getNombre() {
		return nombre;
	}

	public EstadoCarrera(String nombre) {
		this.nombre = nombre;
	}

	public void abrir(Carrera carrera) throws ObligatorioException {
		throw new ObligatorioException("No se puede abrir esta carrera ");

	}

	public void cerrar(Carrera carrera) throws ObligatorioException {
		throw new ObligatorioException("No se puede cerrar esta carrera ");
	}

	public void finalizar(Carrera carrera, Participacion ganador) throws ObligatorioException {
		throw new ObligatorioException("No se puede finalizar esta carrera ");
	}

	public abstract boolean permiteApuestas();

	public void dividendoActualizado(Carrera carrera) throws ObligatorioException {

	}

}
