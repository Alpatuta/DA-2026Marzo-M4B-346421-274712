package uy.edu.ort.obligatorioDA.presentadores;

import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.servlet.http.HttpSession;
import uy.edu.ort.obligatorioDA.dominio.Carrera;
import uy.edu.ort.obligatorioDA.dominio.Jornada;
import uy.edu.ort.obligatorioDA.dtos.AdminDto;
import uy.edu.ort.obligatorioDA.dtos.JornadaDto;
import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;
import uy.edu.ort.obligatorioDA.Observer.IObservador;
import uy.edu.ort.obligatorioDA.Observer.Observable;
import uy.edu.ort.obligatorioDA.Observer.ConexionNavegador;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

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
		for (Carrera c : jornadaActual.getCarreras()) {
			c.agregarObserver(this);
		}
		float comision = fachada.getComisionHipodromo();
		return Commands.create(
				new Command("nombreAdmin", adminDto.getNombreCompleto()),
				new Command("jornada", new JornadaDto(jornadaActual, comision)));
	}

	@PostMapping("/avanzarJornada")
	public Commands avanzarJornada() {
		Jornada siguiente = fachada.obtenerJornadaSiguiente(jornadaActual);
		if (siguiente != null) {
			for (Carrera c : jornadaActual.getCarreras())
				c.removerObserver(this);
			jornadaActual = siguiente;
			for (Carrera c : jornadaActual.getCarreras())
				c.agregarObserver(this);
		}
		float comision = fachada.getComisionHipodromo();
		return Commands.create(new Command("jornada", new JornadaDto(jornadaActual, comision)));
	}

	@PostMapping("/retrocederJornada")
	public Commands retrocederJornada() {
		Jornada anterior = fachada.obtenerJornadaAnterior(jornadaActual);
		if (anterior != null) {
			for (Carrera c : jornadaActual.getCarreras())
				c.removerObserver(this);
			jornadaActual = anterior;
			for (Carrera c : jornadaActual.getCarreras())
				c.agregarObserver(this);
		}
		float comision = fachada.getComisionHipodromo();
		return Commands.create(new Command("jornada", new JornadaDto(jornadaActual, comision)));
	}

	public Commands gestionarCarrera(int idCarrera) {
		return null;
	}

	@PostMapping("/logout")
	public Commands logout(HttpSession httpSession) {
		HttpSesion sesion = new HttpSesion(httpSession);
		fachada.desconectarAdmin(sesion.getNombreAdmin());
		sesion.invalidar();
		return Commands.create(new Command("accesoPermitido", "loginAdmin.html"));
	}

	@Override
	public void actualizar(Observable origen, Object evento) {
		float comision = fachada.getComisionHipodromo();
		conexionNavegador.enviarJSON(
				Commands.create(new Command("jornada", new JornadaDto(jornadaActual, comision))));
	}

}
