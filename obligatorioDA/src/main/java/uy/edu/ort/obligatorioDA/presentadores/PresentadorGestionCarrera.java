package uy.edu.ort.obligatorioDA.Presentadores;

import uy.edu.ort.obligatorioDA.Servicios.Fachada.Fachada;
import uy.edu.ort.obligatorioDA.Dominio.Carrera;
import uy.edu.ort.obligatorioDA.Servicios.Observer.IObservador;
import uy.edu.ort.obligatorioDA.Servicios.Observer.ConexionNavegador;
import uy.edu.ort.obligatorioDA.Servicios.Observer.Observable;

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

	public void actualizar(Observable origen, Object evento) {

	}

}
