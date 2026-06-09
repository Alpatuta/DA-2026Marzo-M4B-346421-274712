package uy.edu.ort.obligatorioDA.servicios.Observer;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class ConexionNavegador {

	private SseEmitter sseEmitter;

	public void conectarSSE() {

	}

	public void cerrarConexion() {

	}

	public void enviarJSON(Object data) {

	}

	public SseEmitter getConexionSSE() {
		return sseEmitter;
	}

}
