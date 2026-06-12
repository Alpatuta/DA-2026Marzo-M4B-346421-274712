package uy.edu.ort.obligatorioDA.dominio;

public class ModalidadSuper extends ModalidadApuesta {


	public ModalidadSuper() {
		super("Super");
	}

	@Override
	public Double calcularMontoApostado( Double monto) {
		return monto * 2;
	}

	@Override
	public Double calcularMontoGanado(Double monto, Double dividendoFinal, Double totalApostadoParticipacion) {
		if (dividendoFinal >= 2) {
			return monto * dividendoFinal * 3;
		} else {
			return monto * dividendoFinal * 4;
		}
	}

}
