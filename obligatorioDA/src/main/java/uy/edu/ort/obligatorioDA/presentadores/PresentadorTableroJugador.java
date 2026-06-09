package uy.edu.ort.obligatorioDA.Presentadores;

import uy.edu.ort.obligatorioDA.Servicios.Fachada.Fachada;
import uy.edu.ort.obligatorioDA.Dominio.Apuesta;
import uy.edu.ort.obligatorioDA.Dominio.Jornada;
import uy.edu.ort.obligatorioDA.Dominio.Jugador;
import uy.edu.ort.obligatorioDA.Servicios.Observer.IObservador;
import uy.edu.ort.obligatorioDA.Servicios.Observer.ConexionNavegador;
import uy.edu.ort.obligatorioDA.Servicios.Observer.Observable;

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
