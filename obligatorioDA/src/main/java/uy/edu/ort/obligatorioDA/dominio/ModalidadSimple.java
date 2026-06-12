package uy.edu.ort.obligatorioDA.dominio;

public class ModalidadSimple extends ModalidadApuesta {

	public ModalidadSimple() {
		super("Simple");
	}

	@Override
	public Double calcularMontoApostado( Double monto) {
		return monto;
	} 

	@Override
	public Double calcularMontoGanado(Double monto, Double dividendoFinal, Double totalApostadoParticipacion) {
		return monto * dividendoFinal;
	}

}
