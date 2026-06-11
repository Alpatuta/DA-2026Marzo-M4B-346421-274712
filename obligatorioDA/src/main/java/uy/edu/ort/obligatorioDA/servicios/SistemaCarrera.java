package uy.edu.ort.obligatorioDA.servicios;

import uy.edu.ort.obligatorioDA.dominio.Hipodromo;

import java.util.ArrayList;
import java.util.List;
import uy.edu.ort.obligatorioDA.dominio.Carrera;

public class SistemaCarrera {

	private Hipodromo hipodromo = new Hipodromo();

	private List<Carrera> carreras = new ArrayList<>();

	public SistemaCarrera getInstancia() {
		return null;
	}

	public List<Carrera> obtenerCarrerasApostables() {
		return null;
	}

	public void setComisionHipodromo(float comision) {
		hipodromo.setPorcentajeComision(comision);
	}

}
