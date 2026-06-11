package uy.edu.ort.obligatorioDA.servicios.Fachada;

import uy.edu.ort.obligatorioDA.servicios.SistemaUsuario;
import uy.edu.ort.obligatorioDA.servicios.SistemaApuesta;
import uy.edu.ort.obligatorioDA.servicios.SistemaCarrera;
import uy.edu.ort.obligatorioDA.dominio.Administrador;
import uy.edu.ort.obligatorioDA.dominio.Jugador;
import java.util.Date;
import uy.edu.ort.obligatorioDA.dominio.Jornada;
import uy.edu.ort.obligatorioDA.dominio.Carrera;
import java.util.List;
import uy.edu.ort.obligatorioDA.dominio.Apuesta;
import uy.edu.ort.obligatorioDA.dominio.Participacion;
import uy.edu.ort.obligatorioDA.dominio.Usuario;
import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public class Fachada {

	private static Fachada instancia = new Fachada();

	private SistemaUsuario su;

	private SistemaApuesta sa;

	private SistemaCarrera sc;

	private Fachada() {
		su = new SistemaUsuario();
		sa = new SistemaApuesta();
		sc = new SistemaCarrera();
	}

	public Administrador loginAdministrador(String nombre, String contrasenia) throws ObligatorioException {
		return su.loginAdministrador(nombre, contrasenia);
	}

	public Jugador loginJugador(String nombre, String contrasenia) throws ObligatorioException {
		return su.loginJugador(nombre, contrasenia);
	}

	public void desconectarAdmin(Usuario admin) {
		su.desconectar(admin);
	}

	public static Fachada getInstancia() {
		return instancia;
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

	public Carrera obtenerDetalleCarrera(int idCarrera) {
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

	public void agregarUsuario(Usuario usuario) {
		su.agregarUsuario(usuario);
	}

	public void setComisionHipodromo(float comision) {
		sc.setComisionHipodromo(comision);
	}

}
