package uy.edu.ort.obligatorioDA.presentadores;

import jakarta.servlet.http.HttpSession;
import uy.edu.ort.obligatorioDA.dtos.AdminDto;
import uy.edu.ort.obligatorioDA.dtos.ApuestaEnCursoDto;
import uy.edu.ort.obligatorioDA.dtos.JugadorDto;

public class HttpSesion {
    private final HttpSession httpSession;

    public HttpSesion(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public void setAdmin(AdminDto dto) {
        httpSession.setAttribute("admin", dto);
    }

    public AdminDto getAdmin() {
        return (AdminDto) httpSession.getAttribute("admin");
    }

    public void setJugador(JugadorDto dto) {
        httpSession.setAttribute("jugador", dto);
    }

    public JugadorDto getJugador() {
        return (JugadorDto) httpSession.getAttribute("jugador");
    }

    public boolean tieneAdmin() {
        return getAdmin() != null;
    }

    public boolean tieneJugador() {
        return getJugador() != null;
    }

    public String getNombreAdmin() {
        AdminDto dto = getAdmin();
        return dto != null ? dto.getNombreUsuario() : null;
    }

    public void invalidar() {
        httpSession.invalidate();
    }

    public void setApuestaEnCurso(ApuestaEnCursoDto dto) {
        httpSession.setAttribute("apuestaEnCurso", dto);
    }

    public ApuestaEnCursoDto getApuestaEnCurso() {
        return (ApuestaEnCursoDto) httpSession.getAttribute("apuestaEnCurso");
    }

    public void limpiarApuestaEnCurso() {
        httpSession.removeAttribute("apuestaEnCurso");
    }

    public String getNombreJugador() {
        JugadorDto dto = getJugador();
        return dto != null ? dto.getNombreUsuario() : null;
    }

}
