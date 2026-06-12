package uy.edu.ort.obligatorioDA.dominio;

import java.util.ArrayList;
import java.util.List;

public class Hipodromo {

	private float porcentajeComision;

	private List<Jornada> jornadas = new ArrayList<>();

	public Hipodromo() {
	}

	public void agregarJornada(Jornada j) {
		jornadas.add(j);
	}

	public List<Jornada> getJornadas() {
		return jornadas;
	}

	public float getPorcentajeComision() {
		return porcentajeComision;
	}

	public void setPorcentajeComision(float comision) {
		this.porcentajeComision = comision;
	}

}
