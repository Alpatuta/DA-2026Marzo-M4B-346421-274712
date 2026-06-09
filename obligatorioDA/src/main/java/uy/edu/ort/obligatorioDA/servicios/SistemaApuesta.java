package uy.edu.ort.obligatorioDA.Servicios;

import java.util.List;
import uy.edu.ort.obligatorioDA.dominio.Apuesta;
import uy.edu.ort.obligatorioDA.dominio.ModalidadApuesta;
import java.util.Collection;
import uy.edu.ort.obligatorioDA.Dominio.Apuesta;
import uy.edu.ort.obligatorioDA.Dominio.ModalidadApuesta;
import uy.edu.ort.obligatorioDA.Dominio.Jugador;
import uy.edu.ort.obligatorioDA.Dominio.Participacion;

public class SistemaApuesta {

	private List<Apuesta> apuestas;

	private List<ModalidadApuesta> modalidades;

	private Collection<Apuesta> apuesta;

	private Collection<ModalidadApuesta> modalidadApuesta;

	public SistemaApuesta getInstancia() {
		return null;
	}

	public List<ModalidadApuesta> obtenerModalidades() {
		return null;
	}

	public void confirmarApuesta(Jugador jugador, Apuesta apuesta, String contrasenia) {

	}

	public List<Apuesta> obtenerApuestasPorJugador(Jugador jugador) {
		return null;
	}

	public List<Apuesta> obtenerApuestasPorParticipacion(Participacion participacion) {
		return null;
	}

}
