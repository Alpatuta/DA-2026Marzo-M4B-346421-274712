package uy.edu.ort.obligatorioDA.Servicios;

import java.util.List;
import uy.edu.ort.obligatorioDA.dominio.Usuario;
import java.util.Collection;
import uy.edu.ort.obligatorioDA.Dominio.Usuario;
import uy.edu.ort.obligatorioDA.Dominio.Administrador;
import uy.edu.ort.obligatorioDA.Dominio.Jugador;

public class SistemaUsuario {

	private List<Usuario> usuarios;

	private Collection<Usuario> usuario;

	public SistemaUsuario getInstancia() {
		return null;
	}

	/**
	 *  
	 */
	public Administrador loginAdministrador(String nombre, String contrasenia) {
		return null;
	}

	public Jugador loginJugador(String nombre, String contrasenia) {
		return null;
	}

	public Usuario login(String nombre, String contrasenia) {
		return null;
	}

	public Boolean estaConectado(Usuario usuario) {
		return null;
	}

	public void conectar(Usuario usuario) {

	}

	public void desconectar(Usuario usuario) {

	}

}
