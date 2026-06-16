package uy.edu.ort.obligatorioDA.dominio;

import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public class Apuesta {

	private Double montoApostado;

	private Double costoDescontar;

	private Jugador jugador;

	private Participacion participacion;

	private Double montoCobrado;

	private boolean finalizada;

	private Double dividendoFinal;

	private ModalidadApuesta modalidadApuesta;

	public Apuesta(Double monto, Jugador jugador, ModalidadApuesta modalidad) throws ObligatorioException {
		validarMonto(monto);
		this.montoApostado = monto;
		this.modalidadApuesta = modalidad;
		this.jugador = jugador;
		this.finalizada = false;
		this.costoDescontar = modalidad.calcularMontoApostado(monto);
	}

	public void validarMonto(Double monto) throws ObligatorioException {
		if (monto < 1) {
			throw new ObligatorioException("Monto inválido");
		}

	}

	public Double getMontoApostado() {
		return montoApostado;
	}

	public Double getMontoCobrado() {
		return montoCobrado;
	}

	public Participacion getParticipacion() {
		return participacion;
	}

	public ModalidadApuesta getModalidadApuesta() {
		return modalidadApuesta;
	}

	public Double getDividendoFinal() {
		return dividendoFinal;
	}

	public boolean estaFinalizada() {
		return finalizada;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setParticipacion(Participacion participacion) {
		this.participacion = participacion;
	}

	public void pagar(Double dividendo, double totalApostadoParticipacion) {
		// Cambio el dividendo final para que sepa cuanto tiene que pagarle al jugador
		this.dividendoFinal = dividendo;
		this.montoCobrado = modalidadApuesta.calcularMontoGanado(montoApostado, dividendo, totalApostadoParticipacion);
		this.finalizada = true;
		jugador.acreditarSaldo(montoCobrado);
	}

}
