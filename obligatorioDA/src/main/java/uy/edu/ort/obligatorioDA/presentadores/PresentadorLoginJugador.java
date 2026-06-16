package uy.edu.ort.obligatorioDA.presentadores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import uy.edu.ort.obligatorioDA.dominio.Jugador;
import uy.edu.ort.obligatorioDA.dominio.Usuario;
import uy.edu.ort.obligatorioDA.dtos.JugadorDto;
import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;
import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;

@RestController
@RequestMapping("/loginJugador")
public class PresentadorLoginJugador extends PresentadorLogin {

    public PresentadorLoginJugador(Fachada fachada) {
        super(fachada);
    }

    @PostMapping("/ingresar")
    public Commands login(HttpSession httpSession,
            @RequestParam String nombreUsuario,
            @RequestParam String contrasenia) throws ObligatorioException {
        return super.login(httpSession, nombreUsuario, contrasenia);
    }

    @Override
    protected Usuario obtenerUsuario(String nombre, String contrasenia) throws ObligatorioException {
        return fachada.loginJugador(nombre, contrasenia);
    }

    @Override
    protected String siguienteCU() {
        return "tableroJugador.html";
    }

    @Override
    protected void guardarUsuarioEnSesion(HttpSesion sesion, Usuario usuario) {
        sesion.setJugador(new JugadorDto((Jugador) usuario));
    }
}
