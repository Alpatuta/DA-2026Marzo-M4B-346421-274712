package uy.edu.ort.obligatorioDA.servicios;

import uy.edu.ort.obligatorioDA.dominio.Hipodromo;
import uy.edu.ort.obligatorioDA.dominio.Jornada;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import uy.edu.ort.obligatorioDA.dominio.Carrera;

public class SistemaCarrera {

	private Hipodromo hipodromo = new Hipodromo();

	private List<Carrera> carreras = new ArrayList<>();

	public void agregarJornada(Jornada j) {
		hipodromo.agregarJornada(j);
	}

	public Jornada obtenerJornadaActual(Date fecha) {
		List<Jornada> jornadas = hipodromo.getJornadas();

		Jornada jornadaActual = null;

		for (Jornada j : jornadas) {
			if (mismaFecha(j.getFecha(), fecha))
				return j;

			if (j.getFecha().before(fecha)) {
				if (jornadaActual == null || j.getFecha().after(jornadaActual.getFecha())) {
					jornadaActual = j;
				}
			}

		}
		return jornadaActual;

	}

	public Jornada obtenerJornadaSiguiente(Jornada actual) {
		List<Jornada> jornadas = hipodromo.getJornadas();
		Jornada siguiente = null;
		for (Jornada j : jornadas) {
			if (j.getFecha().after(actual.getFecha())) {
				if (siguiente == null || j.getFecha().before(siguiente.getFecha())) {
					siguiente = j;
				}
			}
		}
		return siguiente;
	}

	public Jornada obtenerJornadaAnterior(Jornada actual) {
		List<Jornada> jornadas = hipodromo.getJornadas();
		Jornada anterior = null;
		for (Jornada j : jornadas) {
			if (j.getFecha().before(actual.getFecha())) {
				if (anterior == null || j.getFecha().after(anterior.getFecha())) {
					anterior = j;
				}
			}
		}
		return anterior;
	}

	private boolean mismaFecha(Date fecha, Date fecha2) {

		Calendar ca = Calendar.getInstance();
		Calendar cb = Calendar.getInstance();
		ca.setTime(fecha);
		cb.setTime(fecha2);
		return ca.get(Calendar.YEAR) == cb.get(Calendar.YEAR)
				&& ca.get(Calendar.MONTH) == cb.get(Calendar.MONTH)
				&& ca.get(Calendar.DAY_OF_MONTH) == cb.get(Calendar.DAY_OF_MONTH);

	}

	public List<Carrera> obtenerCarrerasApostables() {
		return null;
	}

	public float getComisionHipodromo() {
		return hipodromo.getPorcentajeComision();
	}

	public void setComisionHipodromo(float comision) {
		hipodromo.setPorcentajeComision(comision);
	}

}
