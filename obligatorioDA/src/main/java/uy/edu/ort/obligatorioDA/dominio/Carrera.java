package uy.edu.ort.obligatorioDA.dominio;

import java.util.ArrayList;
import java.util.List;

import uy.edu.ort.obligatorioDA.Observer.IObservador;
import uy.edu.ort.obligatorioDA.Observer.Observable;
import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public class Carrera extends Observable {

	private int idCarrera = 0;

	private String nombreCarrera;

	private List<Participacion> participantes;

	private EstadoCarrera estado;

	private Participacion ganador;

	private String horaFinalizacion;

	private List<IObservador> listaObservers;

	private static int contadorId = 0;

	public Carrera(String nombre) {
		this.idCarrera = ++contadorId;
		this.nombreCarrera = nombre;
		this.participantes = new ArrayList<>();
		this.estado = new EstadoDefinida();
	}

	public void agregarParticipante(Participacion participacion) {
		participantes.add(participacion);
	}

	public Double calcularTotalApostado() {
		double total = 0;

		for (Participacion p : participantes) {
			total += p.calcularTotalApuestas();
		}

		return total;
	}

	public int cantidadApuestasCarrera() {
		int total = 0;

		for (Participacion p : participantes) {
			total += p.cantidadApuestasParticipacion();
		}
		return total;
	}

	public Double totalPagado() {
		if (ganador == null) {
			return 0.0;
		}

		return ganador.totalPagado();
	}

	public int cantidadCaballosParticipantes() {
		return participantes.size();
	}

	public Boolean estaFinalizada() {
		return estado instanceof EstadoFinalizada;
	}

	public Boolean estaProxima() {
		return !estaFinalizada();
	}

	public Boolean todosDividendosValidos() {
		for (Participacion p : participantes) {
			if (!p.dividendoValido()) {
				return false;
			}

		}

		return true;
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public List<Participacion> getParticipantes() {
		return participantes;
	}

	public EstadoCarrera getEstado() {
		return estado;
	}

	public Participacion getGanador() {
		return ganador;
	}

	public Double getDividendoFinalGanador() {
		if (ganador == null) {
			return 0.0;
		}

		return ganador.getDividendoFinal();
	}

	public String getHoraFinalizacion() {
		return horaFinalizacion;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void cambiarEstado(EstadoCarrera nuevoEstado) {
		this.estado = nuevoEstado;
		notificarObservadores(nuevoEstado);
	}

	public void setGanador(Participacion ganador) {
		this.ganador = ganador;
	}

	public Double recalcularDividendos(float comision) throws ObligatorioException {
		Double totalApostadoCarrera = calcularTotalApostado();

		for (Participacion p : participantes) {
			p.recalcularDividendo(totalApostadoCarrera, comision);
		}

		estado.dividendoActualizado(this);

		return null;
	}

}
