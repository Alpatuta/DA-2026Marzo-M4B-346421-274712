package uy.edu.ort.obligatorioDA.presentadores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import uy.edu.ort.obligatorioDA.dominio.Carrera;
import uy.edu.ort.obligatorioDA.dominio.ModalidadApuesta;
import uy.edu.ort.obligatorioDA.dominio.Participacion;
import uy.edu.ort.obligatorioDA.dtos.ApuestaEnCursoDto;
import uy.edu.ort.obligatorioDA.dtos.ConfirmarApuestaDto;
import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;
import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;

@RestController
@RequestMapping("/confirmarApuesta")
public class PresentadorConfirmarApuesta {

	private final Fachada fachada;

	public PresentadorConfirmarApuesta(Fachada fachada) {
		this.fachada = fachada;
	}

	@PostMapping("/vistaConectada")
	public Commands inicializarVista(HttpSession httpSession) {
		HttpSesion sesion = new HttpSesion(httpSession);
		if (!sesion.tieneJugador()) {
			return Commands.create(new Command("accesoNoPermitido", "loginJugador.html"));
		}
		ApuestaEnCursoDto enCurso = sesion.getApuestaEnCurso();
		if (enCurso == null) {
			return Commands.create(new Command("error", "No hay apuesta en curso"));
		}

		return Commands.create(new Command("apuesta", construirDtoApuesta(enCurso)));
	}

	@PostMapping("/confirmar")
	public Commands confirmar(HttpSession httpSession, @RequestParam String contrasenia) throws ObligatorioException {
		HttpSesion sesion = new HttpSesion(httpSession);
		ApuestaEnCursoDto enCurso = sesion.getApuestaEnCurso();
		if (enCurso == null) {
			return Commands.create(new Command("error", "No hay apuesta en curso"));
		}
		fachada.confirmarApuesta(sesion.getNombreJugador(), enCurso.getIdCarrera(),
				enCurso.getNroParticipacion(), enCurso.getNombreModalidad(), enCurso.getMonto(), contrasenia);
		sesion.limpiarApuestaEnCurso();
		return Commands.create(new Command("accesoPermitido", "tableroJugador.html"));
	}

	@PostMapping("/descartar")
	public Commands descartar(HttpSession httpSession) {
		HttpSesion sesion = new HttpSesion(httpSession);
		sesion.limpiarApuestaEnCurso();
		return Commands.create(new Command("accesoPermitido", "tableroJugador.html"));
	}

	private ConfirmarApuestaDto construirDtoApuesta(ApuestaEnCursoDto enCurso) {
		Carrera carrera = fachada.obtenerDetalleCarrera(enCurso.getIdCarrera());
		Participacion participacion = carrera.obtenerParticipacionPorNro(enCurso.getNroParticipacion());
		ModalidadApuesta modalidad = fachada.obtenerModalidadPorNombre(enCurso.getNombreModalidad());
		return new ConfirmarApuestaDto(carrera, participacion, modalidad, enCurso.getMonto());
	}
}