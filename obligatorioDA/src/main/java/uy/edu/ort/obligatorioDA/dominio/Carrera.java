package uy.edu.ort.obligatorioDA.Dominio;

import uy.edu.ort.obligatorioDA.Servicios.Observer.Observable;
import java.util.List;
import uy.edu.ort.obligatorioDA.dominio.Participacion;
import uy.edu.ort.obligatorioDA.Servicios.Observer.IObservador;
import java.util.Collection;

public class Carrera extends Observable {

	private static int idCarrera;

	private String nombreCarrera;

	private List<Participacion> participantes;

	EstadoCarrera estado;

	private Participacion ganador;

	private int horaFinalizacion;

	private List<IObservador> listaObservers;

	private EstadoCarrera estadoCarrera;

	private Participacion participacion;

	private Participacion participacion;

	private Collection<EstadoCarrera> estadoCarrera;

	private Collection<Participacion> participacion;

	private Participacion participacion;

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

	/**
	 * Que haga un ganador.getCaballo
	 * 
	 *  
	 */
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
