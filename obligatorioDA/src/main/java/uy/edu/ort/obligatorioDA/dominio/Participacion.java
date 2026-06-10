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

}
