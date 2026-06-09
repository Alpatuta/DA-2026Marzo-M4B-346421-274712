package uy.edu.ort.obligatorioDA.dominio;

public class EstadoDefinida extends EstadoCarrera {


	public void abrir(Carrera carrera) {
		// Cambia el estado de la carrera a Abierta
		carrera.cambiarEstado(new EstadoAbierta());
	}

	public void cerrar(Carrera carrera) {

		
	}

	public void finalizar(Carrera carrera, Participacion ganador) {
		throw new RuntimeException("No se puede finalizar la carrera.");
	}

	public boolean permiteApuestas() {
		return false;
	}

}
