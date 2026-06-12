package uy.edu.ort.obligatorioDA.dominio;

import java.util.ArrayList;
import java.util.List;

public class Participacion {

	private int nroParticipacion;

	private Carrera carrera;

	private Caballo caballo;

	private Double dividendoActual;

	private Double dividendoFinal;

	private List<Apuesta> apuestas = new ArrayList<>();

	// Participacion.java
	public Participacion(int nroParticipacion, Carrera carrera, Caballo caballo) {
		this.nroParticipacion = nroParticipacion;
		this.carrera = carrera;
		this.caballo = caballo;
		this.apuestas = new ArrayList<>();
	}

	public void agregarApuesta(Apuesta a) {
		apuestas.add(a);
	}

	public Caballo getCaballo() {
		return caballo;
	}

	public Double getDividendoFinal() {
		return dividendoFinal;
	}

	public int getNroParticipacion() {
		return nroParticipacion;
	}

	public Double getDividendoActual() {
		return dividendoActual;
	}

	public void fijarDividendoFinal(){
		this.dividendoFinal = this.dividendoActual;
	}

	public Boolean dividendoValido() {
		return cantidadApuestasParticipacion() > 0 && dividendoActual != null && dividendoActual > 1;
	}

	public double calcularTotalApuestas() {
		double total = 0;
		for (Apuesta apuesta : apuestas) {
			total += apuesta.getMontoApostado();
		}
		return total;
	}

	public int cantidadApuestasParticipacion() {
		return apuestas.size();
	}

	// El ganador hace esto
	public void pagarApuestas() {
		for (Apuesta a : apuestas) {
			a.pagar(dividendoFinal, calcularTotalApuestas());
		}
	}

	public Double totalPagado() {
		double total = 0;
		for (Apuesta a : apuestas) {
			if (a.getMontoCobrado() != null) {
				total += a.getMontoCobrado();
			}
		}
		return total;
	}

	public void recalcularDividendo(Double totalApostadoCarrera, float comision) {
		double totalCaballo = calcularTotalApuestas();

		if (totalCaballo == 0) {
			this.dividendoActual = 0.0;
			return;
		}

		double pozoARepartir = totalApostadoCarrera - (totalApostadoCarrera * comision / 100);
		this.dividendoActual = pozoARepartir / totalCaballo;
	}

}
