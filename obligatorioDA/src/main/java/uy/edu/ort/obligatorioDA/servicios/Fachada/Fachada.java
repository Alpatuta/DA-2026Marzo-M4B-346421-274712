package uy.edu.ort.obligatorioDA.Servicios.Fachada;

import uy.edu.ort.obligatorioDA.Servicios.SistemaUsuario;
import uy.edu.ort.obligatorioDA.Servicios.SistemaApuesta;
import uy.edu.ort.obligatorioDA.Servicios.SistemaCarrera;
import uy.edu.ort.obligatorioDA.Dominio.Administrador;
import uy.edu.ort.obligatorioDA.Dominio.Jugador;
import java.util.Date;
import uy.edu.ort.obligatorioDA.Dominio.Jornada;
import uy.edu.ort.obligatorioDA.dominio.Carerra;
import java.util.List;
import uy.edu.ort.obligatorioDA.dominio.Apuesta;
import uy.edu.ort.obligatorioDA.dominio.Participacion;
import uy.edu.ort.obligatorioDA.Dominio.Participacion;

public class Fachada {

	private SistemaUsuario su;

	private SistemaApuesta sa;

	private SistemaCarrera sc;

	private SistemaUsuario sistemaUsuario;

	private SistemaCarrera sistemaCarrera;

	private SistemaApuesta sistemaApuesta;

	public Administrador loginAdministrador(String nombre, String contrasenia) {
		return null;
	}

	public Jugador loginJugador(String nombre, String contrasenia) {
		return null;
	}

	public static Fachada getInstancia() {
		return null;
	}

	public Jornada obtenerJornadaActual(Date fecha) {
		return null;
	}

	public Jornada obtenerJornadaSiguiente(Jornada jornada) {
		return null;
	}

	public Jornada obtenerJornadaAnterior(Jornada jornada) {
		return null;
	}

	public Carerra obtenerDetalleCarrera(int idCarrera) {
		return null;
	}

	public Jugador obtenerJugadorPorNombre(String nombreUsuario) {
		return null;
	}

	public List<Apuesta> obtenerApuestasPorJugador(Jugador jugador) {
		return null;
	}

	public List<Participacion> obtenerApuestasPorParticipacion(Participacion participacion) {
		return null;
	}

}
