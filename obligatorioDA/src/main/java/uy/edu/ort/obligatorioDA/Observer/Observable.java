package uy.edu.ort.obligatorioDA.Observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {

	private List<IObservador> listaObservers = new ArrayList<>();

	public void agregarObserver(IObservador observer) {
		if (!listaObservers.contains(observer)) {
			listaObservers.add(observer);
		}
	}

	public void removerObserver(IObservador observer) {
		listaObservers.remove(observer);
	}

	public void notificarObservadores(Object evento) {
		List<IObservador> copia = new ArrayList<>(listaObservers);
		for (IObservador o : copia) {
			o.actualizar(this, evento);
		}
	}

}
