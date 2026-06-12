package uy.edu.ort.obligatorioDA.dominio;

import java.util.List;

public class Caballo {

	private String nombre;

	private List<Participacion> participaciones;

	public Caballo(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
