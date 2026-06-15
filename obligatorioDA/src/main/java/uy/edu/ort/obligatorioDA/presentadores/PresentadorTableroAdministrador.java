package uy.edu.ort.obligatorioDA.presentadores;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import jakarta.servlet.http.HttpSession;
import uy.edu.ort.obligatorioDA.Observer.ConexionNavegador;
import uy.edu.ort.obligatorioDA.Observer.IObservador;
import uy.edu.ort.obligatorioDA.Observer.Observable;
import uy.edu.ort.obligatorioDA.dominio.Carrera;
import uy.edu.ort.obligatorioDA.dominio.Jornada;
import uy.edu.ort.obligatorioDA.dtos.AdminDto;
import uy.edu.ort.obligatorioDA.dtos.JornadaDto;
import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;

@RestController
@RequestMapping("/tableroAdmin")
@Scope("session")
public class PresentadorTableroAdministrador implements IObservador {

	private final Fachada fachada;
	private ConexionNavegador conexionNavegador;
	private Jornada jornadaActual;

	public PresentadorTableroAdministrador(Fachada fachada, ConexionNavegador conexionNavegador) {
		this.fachada = fachada;
		this.conexionNavegador = conexionNavegador;
	}

	@GetMapping(value = "/registrarSSE", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public SseEmitter registrarSSE() {
		conexionNavegador.conectarSSE();
		return conexionNavegador.getConexionSSE();
	}

	@PostMapping("/vistaConectada")
	public Commands inicializarVista(@SessionAttribute(name = "admin", required = false) AdminDto adminDto) {
		if (adminDto == null) {
			return Commands.create(new Command("accesoNoPermitido", "loginAdmin.html"));
		}

		jornadaActual = fachada.obtenerJornadaActual(new Date());
		if (jornadaActual == null) {
			return Commands.create(
					new Command("nombreAdmin", adminDto.getNombreCompleto()),
					new Command("error", "No hay jornadas definidas en el sistema"));
		}
		registrarObservadoresCarreras();
		return Commands.create(
				new Command("nombreAdmin", adminDto.getNombreCompleto()),
				comandoJornada());
	}

	@PostMapping("/avanzarJornada")
	public Commands avanzarJornada() {
		Jornada siguiente = fachada.obtenerJornadaSiguiente(jornadaActual);
		if (siguiente != null) {
			jornadaActual = siguiente;
		}

		return Commands.create(comandoJornada());
	}

	@PostMapping("/retrocederJornada")
	public Commands retrocederJornada() {
		Jornada anterior = fachada.obtenerJornadaAnterior(jornadaActual);
		if (anterior != null) {
			jornadaActual = anterior;
		}
		return Commands.create(comandoJornada());
	}

	@PostMapping("/gestionarCarrera")
	public Commands gestionarCarrera(@RequestParam int idCarrera) {
		return Commands.create(new Command("accesoPermitido", "gestionCarrera.html?id=" + idCarrera));
	}

	@PostMapping("/logout")
	public Commands logout(HttpSession httpSession) {
		HttpSesion sesion = new HttpSesion(httpSession);
		fachada.removerObserver(this);
		fachada.desconectarAdmin(sesion.getNombreAdmin());
		sesion.invalidar();
		return Commands.create(new Command("accesoPermitido", "loginAdmin.html"));
	}

	@Override
	public void actualizar(Observable origen, Object evento) {
		conexionNavegador.enviarJSON(
				Commands.create(comandoJornada()));
	}

	// Metodos privados para SRP

	private Command comandoJornada() {
		float comision = fachada.getComisionHipodromo();
		return new Command("jornada", new JornadaDto(jornadaActual, comision));
	}

	private void registrarObservadoresCarreras() {
		for (Carrera c : jornadaActual.getCarreras()) {
			c.agregarObserver(this);
		}

		fachada.agregarObserver(this);
	}

}
