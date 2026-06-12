package uy.edu.ort.obligatorioDA.presentadores;

import jakarta.servlet.http.HttpSession;
import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;
import uy.edu.ort.obligatorioDA.Observer.IObservador;
import uy.edu.ort.obligatorioDA.Observer.Observable;
import uy.edu.ort.obligatorioDA.Observer.ConexionNavegador;
import uy.edu.ort.obligatorioDA.Observer.SseEmitter;

public class PresentadorTableroJugador implements IObservador {

	private ConexionNavegador conexionNavegador;

	public Commands inicializarVista(HttpSession sesionHttp) {
		return null;
	}

	public Commands prepararApuesta(int idCarrera, int nroParticipacion, String nombreModalidad, double monto) {
		return null;
	}

	public Commands logout(HttpSession sesionHttp) {
		return null;
	}

	@Override
	public void actualizar(Observable origen, Object evento) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
	}

	public SseEmitter registrarSSE() {
		return null;
	}

}
