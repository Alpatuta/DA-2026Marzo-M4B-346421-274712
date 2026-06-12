package uy.edu.ort.obligatorioDA.servicios;

import java.util.ArrayList;
import java.util.List;

import uy.edu.ort.obligatorioDA.dominio.Apuesta;
import uy.edu.ort.obligatorioDA.dominio.Jugador;
import uy.edu.ort.obligatorioDA.dominio.ModalidadApuesta;
import uy.edu.ort.obligatorioDA.dominio.Participacion;

public class SistemaApuesta {

	private List<ModalidadApuesta> modalidades = new ArrayList<>();

	public SistemaApuesta getInstancia() {
		return null;
	}

	public List<ModalidadApuesta> obtenerModalidades() {
		return modalidades;
	}

	public void agregarModalidad(ModalidadApuesta modalidad) {
		modalidades.add(modalidad);	
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
