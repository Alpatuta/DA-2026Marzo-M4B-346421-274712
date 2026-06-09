package uy.edu.ort.obligatorioDA.dominio;

public abstract class EstadoCarrera {

	public abstract void abrir(Carrera carrera);

	public abstract void cerrar(Carrera carrera);

	public abstract void finalizar(Carrera carrera, Participacion ganador);

	public abstract boolean permiteApuestas();

}
