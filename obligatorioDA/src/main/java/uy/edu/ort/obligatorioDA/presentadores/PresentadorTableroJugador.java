package uy.edu.ort.obligatorioDA.presentadores;

import java.util.ArrayList;
import java.util.List;

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
import uy.edu.ort.obligatorioDA.dominio.Apuesta;
import uy.edu.ort.obligatorioDA.dominio.Carrera;
import uy.edu.ort.obligatorioDA.dominio.Jugador;
import uy.edu.ort.obligatorioDA.dominio.ModalidadApuesta;
import uy.edu.ort.obligatorioDA.dtos.ApuestaDto;
import uy.edu.ort.obligatorioDA.dtos.ApuestaEnCursoDto;
import uy.edu.ort.obligatorioDA.dtos.CarreraApostableDto;
import uy.edu.ort.obligatorioDA.dtos.JugadorDto;
import uy.edu.ort.obligatorioDA.dtos.JugadorTableroDto;
import uy.edu.ort.obligatorioDA.dtos.ModalidadApuestaDto;
import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;

@RestController
@RequestMapping("/tableroJugador")
@Scope("session")
public class PresentadorTableroJugador implements IObservador {

    private final Fachada fachada;
    private final ConexionNavegador conexionNavegador;
    private Jugador jugadorActual;
    private List<Carrera> carrerasObservadas = new ArrayList<>();

    public PresentadorTableroJugador(Fachada fachada, ConexionNavegador conexionNavegador) {
        this.fachada = fachada;
        this.conexionNavegador = conexionNavegador;
    }

    @GetMapping(value = "/registrarSSE", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter registrarSSE() {
        conexionNavegador.conectarSSE();
        return conexionNavegador.getConexionSSE();
    }

    @PostMapping("/vistaConectada")
    public Commands inicializarVista(@SessionAttribute(name = "jugador", required = false) JugadorDto jugadorDto) {
        if (jugadorDto == null) {
            return Commands.create(new Command("accesoNoPermitido", "loginJugador.html"));
        }
        jugadorActual = fachada.obtenerJugadorPorNombre(jugadorDto.getNombreUsuario());
        suscribirCarrerasApostables();
        return comandosTablero();
    }

    @PostMapping("/prepararApuesta")
    public Commands prepararApuesta(HttpSession httpSession,
                                    @RequestParam int idCarrera,
                                    @RequestParam int nroParticipacion,
                                    @RequestParam String nombreModalidad,
                                    @RequestParam double monto) {
        HttpSesion sesion = new HttpSesion(httpSession);
        sesion.setApuestaEnCurso(new ApuestaEnCursoDto(idCarrera, nroParticipacion, nombreModalidad, monto));
        return Commands.create(new Command("accesoPermitido", "confirmarApuesta.html"));
    }

    @PostMapping("/logout")
    public Commands logout(HttpSession httpSession) {
        HttpSesion sesion = new HttpSesion(httpSession);
        desuscribirCarreras();
        sesion.invalidar();
        return Commands.create(new Command("accesoPermitido", "loginJugador.html"));
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        conexionNavegador.enviarJSON(comandosTablero());
    }

    // ---- metodos privados para el presentador ----

    private Commands comandosTablero() {
        return Commands.create(
            new Command("jugador",     new JugadorTableroDto(jugadorActual)),
            new Command("modalidades", construirModalidades()),
            new Command("carreras",    construirCarrerasApostables()),
            new Command("apuestas",    construirApuestas())
        );
    }

    private List<CarreraApostableDto> construirCarrerasApostables() {
        List<CarreraApostableDto> dtos = new ArrayList<>();
        for (Carrera c : fachada.obtenerCarrerasApostables()) {
            dtos.add(new CarreraApostableDto(c));
        }
        return dtos;
    }

    private List<ModalidadApuestaDto> construirModalidades() {
        List<ModalidadApuestaDto> dtos = new ArrayList<>();
        for (ModalidadApuesta m : fachada.obtenerModalidadesApuesta()) {
            dtos.add(new ModalidadApuestaDto(m));
        }
        return dtos;
    }

    private List<ApuestaDto> construirApuestas() {
        List<ApuestaDto> dtos = new ArrayList<>();
        for (Apuesta a : jugadorActual.apuestasOrdenadasDesc()) {
            dtos.add(new ApuestaDto(a));
        }
        return dtos;
    }

    private void suscribirCarrerasApostables() {
        carrerasObservadas = fachada.obtenerCarrerasApostables();
        for (Carrera c : carrerasObservadas) {
            c.agregarObserver(this);
        }
    }

    private void desuscribirCarreras() {
        for (Carrera c : carrerasObservadas) {
            c.removerObserver(this);
        }
        carrerasObservadas.clear();
    }
}