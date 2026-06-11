package uy.edu.ort.obligatorioDA.presentadores;

import java.util.Observable;

import jakarta.servlet.http.HttpSession;
import uy.edu.ort.obligatorioDA.dominio.Jornada;
import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;
import uy.edu.ort.obligatorioDA.Observer.IObservador;
import uy.edu.ort.obligatorioDA.Observer.ConexionNavegador;
import uy.edu.ort.obligatorioDA.Observer.SseEmitter;

public class PresentadorTableroAdministrador implements IObservador {

	private ConexionNavegador conexionNavegador;

	public Commands inicializarVista(HttpSession sesionHttp) {
		return null;
	}

	public Commands avanzarJornada() {
		return null;
	}

	public Commands retrocederJornada() {
		return null;
	}

	public Commands gestionarCarrera(int idCarrera) {
		return null;
	}

	public Commands logout(HttpSession sesionHttp) {
		return null;
	}

	public SseEmitter registrarSSE() {
		return null;
	}

	@Override
	public void actualizar(Observable origen, Object evento) {

	}

}
