package uy.edu.ort.obligatorioDA.Observer;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

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
