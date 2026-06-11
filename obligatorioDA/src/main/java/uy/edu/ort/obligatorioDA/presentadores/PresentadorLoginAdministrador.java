package uy.edu.ort.obligatorioDA.presentadores;

import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;
import uy.edu.ort.obligatorioDA.dominio.Administrador;
import uy.edu.ort.obligatorioDA.dominio.Usuario;
import uy.edu.ort.obligatorioDA.dtos.AdminDto;
import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;
import uy.edu.ort.obligatorioDA.presentadores.Commands;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/loginAdmin")
public class PresentadorLoginAdministrador extends PresentadorLogin {

	public PresentadorLoginAdministrador(Fachada fachada) {
		super(fachada);
	}

	@PostMapping("/ingresar")
	public Commands login(HttpSession httpSession, @RequestParam String nombreUsuario,
			@RequestParam String contrasenia) throws ObligatorioException {
		return super.login(httpSession, nombreUsuario, contrasenia);

	}

	@Override
	protected Usuario obtenerUsuario(String nombre, String contrasenia) throws ObligatorioException {
		return fachada.loginAdministrador(nombre, contrasenia);
	}

	@Override
	protected String siguienteCU() {
		return "tableroAdmin.html";
	}

	@Override
	protected void guardarUsuarioEnSesion(HttpSesion session, Usuario usuario) {
		session.setAdmin(new AdminDto((Administrador) usuario));
	}

}
