package uy.edu.ort.obligatorioDA.dominio;

import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public class EstadoCerrada extends EstadoCarrera {

    public EstadoCerrada() {
        super("CERRADA");
    }

    @Override
    public void finalizar(Carrera carrera, Participacion ganador) throws ObligatorioException {
        // Cerrada → Finalizada (válido): asigna ganador y cambia estado
        carrera.setGanador(ganador);
        carrera.registrarHoraFinalizacion();    //Despues se registra para la columna fin del tablero.
        carrera.cambiarEstado(new EstadoFinalizada()); //NOTIFICA A LOS OBSERVERS EL NUEVO ESTADO
        ganador.pagarApuestas(); // paga el dinero.
    }

    @Override
    public boolean permiteApuestas() {
        return false;
    }


}
