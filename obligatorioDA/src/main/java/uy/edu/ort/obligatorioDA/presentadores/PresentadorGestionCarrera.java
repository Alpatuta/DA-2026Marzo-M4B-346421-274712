package uy.edu.ort.obligatorioDA.presentadores;

import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;
import uy.edu.ort.obligatorioDA.dominio.Carrera;
import uy.edu.ort.obligatorioDA.Observer.IObservador;
import uy.edu.ort.obligatorioDA.Observer.Observable;
import uy.edu.ort.obligatorioDA.Observer.ConexionNavegador;

public class PresentadorGestionCarrera implements IObservador {

	private ConexionNavegador conexionNavegador;

	public Commands inicializarVista(int idCarrera) {
		return null;
	}

	public Commands abrirCarrera(int idCarrera) {
		return null;
	}

	public Commands cerrarCarrera(int idCarrera) {
		return null;
	}

	public Commands finalizarCarrera(int idCarrera, int nroGanador) {
		return null;
	}

	public Commands volverTablero() {
		return null;
	}

	@Override
	public void actualizar(Observable origen, Object evento) {

		throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
	}

}
