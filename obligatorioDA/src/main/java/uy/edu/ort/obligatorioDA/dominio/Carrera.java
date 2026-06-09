package uy.edu.ort.obligatorioDA.dominio;

import uy.edu.ort.obligatorioDA.servicios.Observer.Observable;
import java.util.List;

public class Carrera extends Observable {

	private static int idCarrera;

	private String nombreCarrera;

	private List<Participacion> participantes;

	private EstadoCarrera estado;

	private Participacion ganador;

	private int horaFinalizacion;

	public int calcularTotalApostado() {
		return 0;
	}

	public int cantidadApuestasCarrera() {
		return 0;
	}

	public int totalPagado() {
		return 0;
	}

	public int cantidadCaballosParticipantes() {
		return 0;
	}

	public Caballo getGanador() {
		return null;
	}

	public Double getDividendoFinalGanador() {
		return null;
	}

	public Boolean estaFinalizada() {
		return null;
	}

	public Boolean estaProxima() {
		return null;
	}

	public Boolean todosDividendosValidos() {
		return null;
	}

	public void cambiarEstado() {

	}

	public Double recalcularDividendos() {
		return null;
	}

}
