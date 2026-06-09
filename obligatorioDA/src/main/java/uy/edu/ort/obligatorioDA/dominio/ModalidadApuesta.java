package uy.edu.ort.obligatorioDA.Dominio;

public abstract class ModalidadApuesta implements Modalidad {

	private String nombre;

	public abstract Double calcularMontoApostado();

	public abstract Double calcularMontoGanado();

}
