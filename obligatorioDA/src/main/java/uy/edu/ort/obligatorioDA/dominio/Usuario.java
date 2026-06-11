package uy.edu.ort.obligatorioDA.dominio;

public abstract class Usuario {

	private String nombreUsuario;

	private String contrasenia;

	private String nombreCompleto;

	public Usuario(String nombreUsuario, String nombreCompleto, String contrasenia) {
		this.nombreUsuario = nombreUsuario;
		this.nombreCompleto = nombreCompleto;
		this.contrasenia = contrasenia;
	}

	public void validar() {

	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

}
