package uy.edu.ort.obligatorioDA.Observer;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import tools.jackson.databind.ObjectMapper;

@Component
@Scope("session")
public class ConexionNavegador {

	private SseEmitter sseEmitter;

	public void conectarSSE() {
		if (sseEmitter != null) {
			cerrarConexion();
		}
		long timeout = 30 * 60 * 1000L; // 30 minutos
		// Crear un nuevo SseEmitter con el tiempo de espera configurado
		sseEmitter = new SseEmitter(timeout);
	}

	public void cerrarConexion() {
		try {
			if (sseEmitter != null) {
				// Completar la conexión para cerrar el SSE
				sseEmitter.complete();
				// Liberar el recurso del SseEmitter
				sseEmitter = null;
			}
		} catch (Exception e) {

		}
	}

	public void enviarJSON(Object data) {
		if (sseEmitter == null)
			return;
		try {
			// Esto es para convertir el objeto a JSON, se puede usar cualquier librería de
			// JSON como Jackson o Gson
			String json = new ObjectMapper().writeValueAsString(data);
			sseEmitter.send(json);
		} catch (Exception e) {
			cerrarConexion();
		}
	}

	public SseEmitter getConexionSSE() {
		return sseEmitter;
	}

}
