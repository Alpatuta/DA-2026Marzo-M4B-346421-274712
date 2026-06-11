package uy.edu.ort.obligatorioDA.presentadores;

import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;
import jakarta.servlet.http.HttpSession;
import uy.edu.ort.obligatorioDA.dominio.Usuario;
import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public abstract class PresentadorLogin {

	protected Fachada fachada;

	public PresentadorLogin(Fachada fachada) {
		this.fachada = fachada;
	}

	// Template method
	public Commands login(HttpSession sesionHttp, String nombreUsuario, String contrasenia)
			throws ObligatorioException {
		HttpSesion session = new HttpSesion(sesionHttp);
		Usuario usuario = obtenerUsuario(nombreUsuario, contrasenia);
		guardarUsuarioEnSesion(session, usuario);
		return Commands.create(new Command("accesoPermitido", siguienteCU()));
	}

	protected abstract void guardarUsuarioEnSesion(HttpSesion session, Usuario usuario);

	protected abstract String siguienteCU();

	protected abstract Usuario obtenerUsuario(String nombreUsuario, String contrasenia) throws ObligatorioException;

}
