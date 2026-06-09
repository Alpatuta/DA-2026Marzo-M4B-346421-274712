package uy.edu.ort.obligatorioDA.presentadores;

import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;
import uy.edu.ort.obligatorioDA.dominio.Usuario;

public abstract class PresentadorLogin {

	public Commands login(HttpSesion sesionHttp, String nombre, String contrasenia) {
		return null;
	}

	protected abstract void siguienteCU();

	protected abstract Usuario obtenerUsuario(String nombre, String contrasenia);

	protected abstract String loginUrl();

}
