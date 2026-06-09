package uy.edu.ort.obligatorioDA.presentadores;

import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;
import uy.edu.ort.obligatorioDA.servicios.Observer.IObservador;
import uy.edu.ort.obligatorioDA.servicios.Observer.ConexionNavegador;
import uy.edu.ort.obligatorioDA.servicios.Observer.Observable;
import uy.edu.ort.obligatorioDA.servicios.Observer.SseEmitter;

public class PresentadorTableroJugador implements IObservador {

	private ConexionNavegador conexionNavegador;

	public Commands inicializarVista(HttpSesion sesionHttp) {
		return null;
	}

	public Commands prepararApuesta(int idCarrera, int nroParticipacion, String nombreModalidad, double monto) {
		return null;
	}

	public Commands logout(HttpSesion sesionHttp) {
		return null;
	}

	public void actualizar(Observable origen, Object evento) {

	}

	public SseEmitter registrarSSE() {
		return null;
	}

}
