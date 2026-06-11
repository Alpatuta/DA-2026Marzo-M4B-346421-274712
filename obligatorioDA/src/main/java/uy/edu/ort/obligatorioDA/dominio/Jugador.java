package uy.edu.ort.obligatorioDA.dominio;

import java.util.List;

public class Jugador extends Usuario {

	private Double saldo;

	public Jugador(String nombreUsuario, String nombreCompleto, String contrasenia, Double saldo) {
		super(nombreUsuario, nombreCompleto, contrasenia);
		this.saldo = saldo;
	}

	public Double totalApostado() {
		return null;
	}

	public Double totalGanado() {
		return null;
	}

	public List<Apuesta> apuestasOrdenadasDesc() {
		return null;
	}

	public Boolean tieneSaldoSuficiente(Double monto) {
		return null;
	}

	public void acreditarSaldo(Double monto) {

	}

	public void descontarSaldo(Double monto) {

	}

	public String getNombreUsuario() {
		return super.getNombreUsuario();
	}

	public String getNombreCompleto() {
		return super.getNombreCompleto();
	}

	public Double getSaldo() {
		return saldo;
	}

}
