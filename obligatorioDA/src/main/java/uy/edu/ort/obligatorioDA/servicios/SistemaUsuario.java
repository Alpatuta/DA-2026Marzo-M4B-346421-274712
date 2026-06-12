package uy.edu.ort.obligatorioDA.servicios;

import java.util.ArrayList;
import java.util.List;

import uy.edu.ort.obligatorioDA.dominio.Administrador;
import uy.edu.ort.obligatorioDA.dominio.Jugador;
import uy.edu.ort.obligatorioDA.dominio.Usuario;
import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public class SistemaUsuario {

	private List<Usuario> usuarios = new ArrayList<>();

	private List<Usuario> usuariosConectados = new ArrayList<>();

	private Usuario login(String nombre, String contrasenia) throws ObligatorioException {
		for (Usuario u : usuarios) {
			if (u.getNombreUsuario().equals(nombre) && u.getContrasenia().equals(contrasenia)) {
				return u;
			}
		}

		throw new ObligatorioException("Credenciales invalidas");
	}

	public Administrador loginAdministrador(String nombre, String contrasenia) throws ObligatorioException {
		Usuario u = login(nombre, contrasenia);
		if (!(u instanceof Administrador)) {
			throw new ObligatorioException("Usuario no es administrador");
		}
		Administrador admin = (Administrador) u;
		if (estaConectado(admin)) {
			throw new ObligatorioException("Administrador ya conectado");
		}
		conectar(admin);
		return admin;
	}

	public Jugador loginJugador(String nombre, String contrasenia) throws ObligatorioException {
		Usuario u = login(nombre, contrasenia);
		if (!(u instanceof Jugador)) {
			throw new ObligatorioException("Usuario no es jugador");
		}
		Jugador jugador = (Jugador) u;
		return jugador;
	}

	public Boolean estaConectado(Usuario usuario) {
		return usuariosConectados.contains(usuario);
	}

	public void conectar(Usuario usuario) {
		if (!estaConectado(usuario)) {
			usuariosConectados.add(usuario);
		}
	}

	public void desconectar(String nombreUsuario) {
		for (Usuario u : usuariosConectados) {
			if (u.getNombreUsuario().equals(nombreUsuario) && u instanceof Administrador) {
				usuariosConectados.remove(u);
				return;
			}

		}
	}

	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public Jugador obtenerJugadorPorNombre (String nombreUsuario) {
		for (Usuario u : usuarios) {
			if (u.getNombreUsuario().equals(nombreUsuario) && u instanceof Jugador) {
				return (Jugador) u;
			}
		}
		return null;
	}

}
