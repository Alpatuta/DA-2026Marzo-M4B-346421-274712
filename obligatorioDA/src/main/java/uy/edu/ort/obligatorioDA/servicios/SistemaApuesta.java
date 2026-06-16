package uy.edu.ort.obligatorioDA.servicios;

import java.util.ArrayList;
import java.util.List;

import uy.edu.ort.obligatorioDA.Observer.Observable;
import uy.edu.ort.obligatorioDA.dominio.Apuesta;
import uy.edu.ort.obligatorioDA.dominio.Jugador;
import uy.edu.ort.obligatorioDA.dominio.ModalidadApuesta;
import uy.edu.ort.obligatorioDA.dominio.Participacion;
import uy.edu.ort.obligatorioDA.excepciones.ObligatorioException;

public class SistemaApuesta extends Observable {

    private List<ModalidadApuesta> modalidades = new ArrayList<>();

    public List<ModalidadApuesta> obtenerModalidades() {
        return modalidades;
    }

    public ModalidadApuesta obtenerModalidadPorNombre(String nombreModalidad) {
        for (ModalidadApuesta m : modalidades) {
            if (m.getNombre().equals(nombreModalidad)) {
                return m;
            }
        }
        return null;
    }

    public void agregarModalidad(ModalidadApuesta modalidad) {
        modalidades.add(modalidad);
    }

    public void confirmarApuesta(Jugador jugador, Participacion participacion,
            ModalidadApuesta modalidad, double monto,
            String contrasenia, float comision) throws ObligatorioException {

        validarApuesta(jugador, participacion, modalidad, monto, contrasenia);
        registrarApuesta(jugador, participacion, modalidad, monto);
        participacion.getCarrera().recalcularDividendos(comision);
        notificarObservadores(this); // Notifico a los observadores que se ha realizado una apuesta, para que puedan
                                     // actualizar su información de dividendos
    }

    private void validarApuesta(Jugador jugador, Participacion participacion,
            ModalidadApuesta modalidad, double monto, String contrasenia) throws ObligatorioException {
        if (!jugador.contraseniaValida(contrasenia)) {
            throw new ObligatorioException("Contraseña incorrecta");
        }
        if (monto < 1) {
            throw new ObligatorioException("Monto inválido");
        }
        if (!participacion.getCarrera().getEstado().permiteApuestas()) {
            throw new ObligatorioException("Esta carrera ya no recibe apuestas");
        }
        double costo = modalidad.calcularMontoApostado(monto);
        if (!jugador.tieneSaldoSuficiente(costo)) {
            throw new ObligatorioException("Saldo insuficiente");
        }
    }

    private void registrarApuesta(Jugador jugador, Participacion participacion,
            ModalidadApuesta modalidad, double monto) throws ObligatorioException {
        Apuesta apuesta = new Apuesta(monto, jugador, modalidad);
        participacion.agregarApuesta(apuesta);
        jugador.agregarApuesta(apuesta);
        jugador.descontarSaldo(modalidad.calcularMontoApostado(monto));
    }

}
