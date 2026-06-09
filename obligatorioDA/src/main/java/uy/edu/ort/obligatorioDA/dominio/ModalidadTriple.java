package uy.edu.ort.obligatorioDA.dominio;

public class ModalidadTriple extends ModalidadApuesta {

	@Override
	public Double calcularMontoApostado( Double monto) {
		return monto * 1.5;
	}

	@Override
	public Double calcularMontoGanado(Double monto, Double dividendoFinal, Double totalApostadoParticipacion) {
		if (totalApostadoParticipacion < 100000) {
			return monto * dividendoFinal * 2;
		} else {
			return monto * dividendoFinal * 3;
		}
	}

}
