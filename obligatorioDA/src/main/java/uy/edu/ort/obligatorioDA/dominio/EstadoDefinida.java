package uy.edu.ort.obligatorioDA.dominio;

import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public class EstadoDefinida extends EstadoCarrera {

    public EstadoDefinida() {
        super("DEFINIDA");
    }

    @Override
    public void abrir(Carrera carrera) throws ObligatorioException {
        
        carrera.cambiarEstado(new EstadoAbierta());
    }

    @Override
    public boolean permiteApuestas() {
        return false;
    }

}
