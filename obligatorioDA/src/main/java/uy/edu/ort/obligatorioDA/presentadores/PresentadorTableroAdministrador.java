package uy.edu.ort.obligatorioDA.Presentadores;

import uy.edu.ort.obligatorioDA.Dominio.Jornada;
import uy.edu.ort.obligatorioDA.Servicios.Fachada.Fachada;
import uy.edu.ort.obligatorioDA.Dominio.Administrador;
import uy.edu.ort.obligatorioDA.Servicios.Observer.IObservador;
import uy.edu.ort.obligatorioDA.Servicios.Observer.ConexionNavegador;
import uy.edu.ort.obligatorioDA.Servicios.Observer.Observable;
import uy.edu.ort.obligatorioDA.Servicios.Observer.SseEmitter;

public class PresentadorTableroAdministrador implements IObservador {

	private ConexionNavegador conexionNavegador;

	public Commands inicializarVista(HttpSesion sesionHttp) {
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

	public Commands logout(HttpSesion sesionHttp) {
		return null;
	}

	public SseEmitter registrarSSE() {
		return null;
	}

	public void actualizar(Observable origen, Object evento) {

	}

}
