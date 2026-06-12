package uy.edu.ort.obligatorioDA.servicios.Fachada;

import java.util.Date;
import java.util.List;

import uy.edu.ort.obligatorioDA.dominio.Administrador;
import uy.edu.ort.obligatorioDA.dominio.Apuesta;
import uy.edu.ort.obligatorioDA.dominio.Carrera;
import uy.edu.ort.obligatorioDA.dominio.Jornada;
import uy.edu.ort.obligatorioDA.dominio.Jugador;
import uy.edu.ort.obligatorioDA.dominio.Participacion;
import uy.edu.ort.obligatorioDA.dominio.Usuario;
import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;
import uy.edu.ort.obligatorioDA.servicios.SistemaApuesta;
import uy.edu.ort.obligatorioDA.servicios.SistemaCarrera;
import uy.edu.ort.obligatorioDA.servicios.SistemaUsuario;

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

	public void desconectarAdmin(String nombreUsuario) {
		su.desconectar(nombreUsuario);
	}

	public static Fachada getInstancia() {
		return instancia;
	}

	public Jornada obtenerJornadaActual(Date fecha) {
		return sc.obtenerJornadaActual(fecha);
	}

	public Jornada obtenerJornadaSiguiente(Jornada jornada) {
		return sc.obtenerJornadaSiguiente(jornada);
	}

	public Jornada obtenerJornadaAnterior(Jornada jornada) {
		return sc.obtenerJornadaAnterior(jornada);
	}

	public Carrera obtenerDetalleCarrera(int idCarrera) {
		return sc.obtenerCarreraPorId(idCarrera);
	}

	public void abrirCarrera(int idCarrera) throws ObligatorioException {
		sc.abrirCarrera(idCarrera);
	}

	public void cerrarCarrera(int idCarrera) throws ObligatorioException {
		sc.cerrarCarrera(idCarrera);
	}

	public void finalizarCarrera(int idCarrera, int idGanador) throws ObligatorioException {
		sc.finalizarCarrera(idCarrera, idGanador);
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

	public void agregarJornada(Jornada jornada) {
		sc.agregarJornada(jornada);
	}

	public float getComisionHipodromo() {
		return sc.getComisionHipodromo();
	}

	public void setComisionHipodromo(float comision) {
		sc.setComisionHipodromo(comision);
	}

}
