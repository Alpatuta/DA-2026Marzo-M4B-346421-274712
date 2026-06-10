package uy.edu.ort.obligatorioDA.Observer;

import java.util.Observable;

public interface IObservador {

	public abstract void actualizar(Observable origen, Object evento);

}
