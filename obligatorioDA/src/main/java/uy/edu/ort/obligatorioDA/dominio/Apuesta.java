package uy.edu.ort.obligatorioDA.dominio;

public class Apuesta {

	private Double montoApostado;

	private Double costoDescontar;

	private Jugador jugador;

	private Participacion participacion;

	private Double montoCobrado;

	private boolean finalizada;

	private ModalidadApuesta modalidad;

	private Double dividendoFinal;

	private ModalidadApuesta modalidadApuesta;

	public Apuesta(Double monto, Jugador jugador, ModalidadApuesta modalidad) {
		validarMonto(monto);
		this.montoApostado = monto;
		this.modalidad = modalidad;
		this.jugador = jugador;
		this.finalizada = false;
	}

	public void validarMonto(Double monto) {
		if (monto <= 0) {
			throw new IllegalArgumentException("El monto apostado debe ser mayor a cero.");
		}
		if (monto > jugador.getSaldo()) {
			throw new IllegalArgumentException("El monto apostado no puede ser mayor al saldo del jugador.");
		}
		this.montoApostado = monto;
	}

	public double getMontoApostado() {
		return montoApostado;
	}

	public void pagar(Double dividendo, double totalApostadoParticipacion) {
		// Cambio el dividendo final para que sepa cuanto tiene que pagarle al jugador
		this.dividendoFinal = dividendo;
		this.montoCobrado = modalidadApuesta.calcularMontoGanado(montoApostado, dividendo, totalApostadoParticipacion);
		this.finalizada = true;
		jugador.acreditarSaldo(montoCobrado);
	}

}
