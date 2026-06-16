package uy.edu.ort.obligatorioDA.presentadores;

import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import jakarta.annotation.PreDestroy;
import jakarta.servlet.http.HttpSession;
import uy.edu.ort.obligatorioDA.Observer.ConexionNavegador;
import uy.edu.ort.obligatorioDA.Observer.IObservador;
import uy.edu.ort.obligatorioDA.Observer.Observable;
import uy.edu.ort.obligatorioDA.dominio.Carrera;
import uy.edu.ort.obligatorioDA.dtos.AdminDto;
import uy.edu.ort.obligatorioDA.dtos.CarreraDetalleDto;
import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;
import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;


@RestController
@RequestMapping("/gestionCarrera")
@Scope("session")
public class PresentadorGestionCarrera implements IObservador {

    private final Fachada fachada;
    private final ConexionNavegador conexionNavegador;
    private Carrera carreraActual;

    public PresentadorGestionCarrera(Fachada fachada, ConexionNavegador conexionNavegador) {
        this.fachada = fachada;
        this.conexionNavegador = conexionNavegador;
    }

    @GetMapping(value = "/registrarSSE", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter registrarSSE() {
        conexionNavegador.conectarSSE();
        return conexionNavegador.getConexionSSE();
    }

    @PostMapping("/vistaConectada")
    public Commands inicializarVista(@RequestParam(required = false) Integer idCarrera,
            @SessionAttribute(name = "admin", required = false) AdminDto adminDto) {
        if (adminDto == null) {
            return Commands.create(new Command("accesoNoPermitido", "loginAdmin.html"));
        }
        if (idCarrera == null) {
            return Commands.create(new Command("error", "No hay carrera seleccionada"));
        }
        carreraActual = fachada.obtenerDetalleCarrera(idCarrera);
        if (carreraActual == null) {
            return Commands.create(new Command("error", "No hay carrera seleccionada"));
        }
        carreraActual.agregarObserver(this);
        fachada.agregarObserver(this);
        return comandoCarrera();
    }

    @PostMapping("/abrir")
    public Commands abrirCarrera(@RequestParam int idCarrera) throws ObligatorioException {
        fachada.abrirCarrera(idCarrera);
        return comandoCarrera();
    }

    @PostMapping("/cerrar")
    public Commands cerrarCarrera(@RequestParam int idCarrera) throws ObligatorioException {
        fachada.cerrarCarrera(idCarrera);
        return comandoCarrera();
    }

    @PostMapping("/finalizar")
    public Commands finalizarCarrera(@RequestParam int idCarrera, @RequestParam int nroGanador)
            throws ObligatorioException {
        fachada.finalizarCarrera(idCarrera, nroGanador);
        return comandoCarrera();
    }

    @PostMapping("/volver")
    public Commands volverTablero() {
        fachada.removerObserver(this);
        return Commands.create(new Command("accesoPermitido", "tableroAdmin.html"));
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
        conexionNavegador.enviarJSON(comandoCarrera());

    }

    private Commands comandoCarrera() {
        return Commands.create(new Command("carrera", new CarreraDetalleDto(carreraActual)));
    }

    @PreDestroy 
    public void limpiar() {

        fachada.removerObserver(this);
        conexionNavegador.cerrarConexion();

    }
}

    