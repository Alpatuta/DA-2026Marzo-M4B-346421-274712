package uy.edu.ort.obligatorioDA.dominio;

public abstract class ModalidadApuesta  {

	private String nombre;

	public ModalidadApuesta(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public abstract Double calcularMontoApostado(Double monto);

	public abstract Double calcularMontoGanado(Double monto, Double dividendoFinal, Double totalApostadoParticipacion);

}
