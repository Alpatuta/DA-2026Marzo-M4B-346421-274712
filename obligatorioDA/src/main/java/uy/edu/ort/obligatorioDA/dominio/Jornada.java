package uy.edu.ort.obligatorioDA.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Jornada {

	private Date fecha;

	private List<Carrera> carreras;

	public Jornada(Date fecha) {
		this.fecha = fecha;
		this.carreras = new ArrayList<>();
	}

	public void agregarCarrera(Carrera c) {
		c.setFecha(fecha);
		carreras.add(c);
	}

	public List<Carrera> getCarreras() {
		return carreras;
	}

	public Date getFecha() {
		return fecha;
	}

	public Double totalApostado() {
		double total = 0;
		for (Carrera c : carreras) {
			total += c.calcularTotalApostado();
		}
		return total;
	}

	public Double totalPagado() {
		double total = 0;
		for (Carrera c : carreras) {
			total += c.totalPagado();
		}
		return total;
	}

	public Double totalComisiones(float porcentajeComision) {
		return (totalApostado() * porcentajeComision) / 100;
	}

	public Double balance() {
		return totalApostado() - totalPagado();
	}

	public int cantidadCarreras() {
		return carreras.size();
	}

	public int cantidadCarrerasFinalizadas() {
		int cantidad = 0;

		for (Carrera c : carreras) {
			if (c.estaFinalizada()) {
				cantidad++;
			}

		}

		return cantidad;
	}

	public int cantidadCarrerasPorCorrer() {
		return cantidadCarreras() - cantidadCarrerasFinalizadas();
	}

	public List<Carrera> carrerasFinalizadasOrdenadasDesc() {
		List<Carrera> carrerasFinalizadas = new ArrayList<>();

		for (Carrera c : carreras) {
			if (c.estaFinalizada()) {
				carrerasFinalizadas.add(c);
			}
		}

		carrerasFinalizadas.sort((c1, c2) -> c2.getIdCarrera() - c1.getIdCarrera());

		return carrerasFinalizadas;
	}

	public List<Carrera> proximasCarreras() {
		List<Carrera> proximasCarreras = new ArrayList<>();

		for (Carrera c : carreras) {
			if (!c.estaFinalizada()) {
				proximasCarreras.add(c);
			}
		}
		return proximasCarreras;
	}

}
