package uy.edu.ort.obligatorioDA.servicios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import uy.edu.ort.obligatorioDA.Observer.Observable;
import uy.edu.ort.obligatorioDA.dominio.Carrera;
import uy.edu.ort.obligatorioDA.dominio.Hipodromo;
import uy.edu.ort.obligatorioDA.dominio.Jornada;
import uy.edu.ort.obligatorioDA.dominio.Participacion;
import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public class SistemaCarrera extends Observable {

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

	public Carrera obtenerCarreraPorId(int id) {
		for (Jornada j : hipodromo.getJornadas()) {
			for (Carrera c : j.getCarreras()) {
				if (c.getIdCarrera() == id) {
					return c;
				}
			}
		}
		return null;
	}

	public void abrirCarrera(int idCarrera) throws ObligatorioException {
		Carrera c = obtenerCarreraPorId(idCarrera);
		if (c == null) {
			throw new ObligatorioException("No hay carrera seleccionada");
		}
		c.getEstado().abrir(c);
		notificarObservadores(this);// Notifico a los observadores que se ha abierto una carrera, para que puedan
									// actualizar su información de dividendos
	}

	public void cerrarCarrera(int idCarrera) throws ObligatorioException {
		Carrera c = obtenerCarreraPorId(idCarrera);
		if (c == null) {
			throw new ObligatorioException("No hay carrera seleccionada");
		}
		c.getEstado().cerrar(c);
		notificarObservadores(this);// Notifico a los observadores que se ha cerrado una carrera, para que puedan
									// actualizar su información de dividendos
	}

	public void finalizarCarrera(int idCarrera, int nroParticipacionGanadora) throws ObligatorioException {
		Carrera c = obtenerCarreraPorId(idCarrera);
		if (c == null) {
			throw new ObligatorioException("No hay carrera seleccionada");
		}
		Participacion ganador = c.obtenerParticipacionPorNro(nroParticipacionGanadora);

		if (ganador == null) {
			throw new ObligatorioException("Debe indicar el caballo ganador de la carrera");
		}
		c.getEstado().finalizar(c, ganador);
		notificarObservadores(this);// Notifico a los observadores que se ha finalizado una carrera, para que puedan
									// actualizar su información de dividendos
	}

	public List<Carrera> obtenerCarrerasApostables() {
		List<Carrera> carrerasApostables = new ArrayList<>();
		for (Jornada j : hipodromo.getJornadas()) {
			for (Carrera c : j.getCarreras()) {
				if (c.getEstado().permiteApuestas()) {
					carrerasApostables.add(c);
				}
			}
		}
		return carrerasApostables;
	}

	public float getComisionHipodromo() {
		return hipodromo.getPorcentajeComision();
	}

	public void setComisionHipodromo(float comision) {
		hipodromo.setPorcentajeComision(comision);
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

}
