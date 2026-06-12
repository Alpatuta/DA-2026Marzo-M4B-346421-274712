package uy.edu.ort.obligatorioDA.dominio;

import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public class EstadoEstable extends EstadoCarrera {

    public EstadoEstable() {
        super("ESTABLE");
    }

    @Override
    public void cerrar(Carrera carrera) throws ObligatorioException {
        //El dividendo con el que se paga es en el momento que se cierra la carrera. Si no lo hacemos, el pago saldria mal. 
        carrera.fijarDividendoFinales(); 
        // Estable → Cerrada (válido)
        carrera.cambiarEstado(new EstadoCerrada());
    }

    @Override
    public boolean permiteApuestas() {
        return true;
    }

    @Override
    public void dividendoActualizado(Carrera carrera) throws ObligatorioException {
        // No se permite actualizar el dividendo en estado Estable
        if (!carrera.todosDividendosValidos()) {
            // Si algún dividendo es inválido, volver al estado Abierta
            carrera.cambiarEstado(new EstadoAbierta());
        }
    }
}
