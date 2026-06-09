package uy.edu.ort.obligatorioDA.dominio;

import java.util.ArrayList;
import java.util.List;

public class Participacion {

	private int nroParticipacion;

	private Carrera carrera;

	private Caballo caballo;

	private Double dividendoActual;

	private Double dividendoFinal;
	
	private List <Apuesta> apuestas = new ArrayList<>();

	public int calcularTotalApuestas() {
		return 0;
	}

	public int cantidadApuestasParticipacion() {
		return 0;
	}

}
