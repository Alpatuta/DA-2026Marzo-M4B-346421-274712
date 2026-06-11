package uy.edu.ort.obligatorioDA.dominio;

public class Administrador extends Usuario {

    public Administrador(String nombreUsuario, String nombreCompleto, String contrasenia) {
        super(nombreUsuario, nombreCompleto, contrasenia);
    }

    public String getNombreUsuario() {
        return super.getNombreUsuario();
    }

    public String getNombreCompleto() {
        return super.getNombreCompleto();
    }

}
