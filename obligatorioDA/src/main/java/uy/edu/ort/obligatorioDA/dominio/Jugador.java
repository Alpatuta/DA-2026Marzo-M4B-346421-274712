package uy.edu.ort.obligatorioDA.dominio;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Usuario {

	private List <Apuesta> apuestas = new ArrayList<>();

	private Double saldo;

	public Jugador(String nombreUsuario, String nombreCompleto, String contrasenia, Double saldo) {
		super(nombreUsuario, nombreCompleto, contrasenia);
		this.saldo = saldo;
	}

	public Double totalApostado() {
		double total = 0;
		for (Apuesta apuesta : apuestas) {
			total += apuesta.getMontoApostado();
		}
		return total;
	}

	public Double totalGanado() {
		double total = 0;
		for (Apuesta apuesta : apuestas) {
			if (apuesta.getMontoCobrado() != null) {
				total += apuesta.getMontoCobrado();
			}
		}
		return total;
	}

	public List<Apuesta> apuestasOrdenadasDesc() {
		List <Apuesta> ordenadas = new ArrayList<>(apuestas);
		ordenadas.sort((a, b) -> b.getParticipacion().getCarrera().getFecha().compareTo(a.getParticipacion().getCarrera().getFecha()));
		return ordenadas;
	}

	public Boolean tieneSaldoSuficiente(Double monto) {
		return saldo >= monto;
	}

	public void acreditarSaldo(Double monto) {
		this.saldo += monto;

	}

	public void descontarSaldo(Double monto) {
		this.saldo -= monto;
	}
	
	public void agregarApuesta(Apuesta apuesta) {
		apuestas.add(apuesta);
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
