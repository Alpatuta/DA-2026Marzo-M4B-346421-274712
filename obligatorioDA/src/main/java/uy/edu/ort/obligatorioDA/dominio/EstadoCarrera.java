package uy.edu.ort.obligatorioDA.dominio;

import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public abstract class EstadoCarrera {

	public abstract void abrir(Carrera carrera) throws ObligatorioException;

	public abstract void cerrar(Carrera carrera) throws ObligatorioException;

	public abstract void finalizar(Carrera carrera, Participacion ganador) throws ObligatorioException;

	public abstract boolean permiteApuestas();

	public abstract void dividendoActualizado(Carrera carrera) throws ObligatorioException;	

}
