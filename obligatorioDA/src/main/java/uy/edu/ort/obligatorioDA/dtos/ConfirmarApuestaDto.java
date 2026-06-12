package uy.edu.ort.obligatorioDA.dtos;

import uy.edu.ort.obligatorioDA.dominio.Carrera;
import uy.edu.ort.obligatorioDA.dominio.ModalidadApuesta;
import uy.edu.ort.obligatorioDA.dominio.Participacion;

public class ConfirmarApuestaDto {
    private int nroCarrera;
    private String nombreCarrera;
    private int nroCaballo;
    private String nombreCaballo;
    private String tipoApuesta;
    private Double dividendoActual;
    private boolean dividendoValido;
    private Double montoApostado;
    private Double montoADebitar;
    private Double montoACobrar;

    public ConfirmarApuestaDto(Carrera carrera, Participacion participacion,
            ModalidadApuesta modalidad, double monto) {
        this.nroCarrera = carrera.getIdCarrera();
        this.nombreCarrera = carrera.getNombreCarrera();
        this.nroCaballo = participacion.getNroParticipacion();
        this.nombreCaballo = participacion.getCaballo().getNombre();
        this.tipoApuesta = modalidad.getNombre();
        this.dividendoActual = participacion.getDividendoActual();
        this.dividendoValido = participacion.dividendoValido();
        this.montoApostado = monto;
        this.montoADebitar = modalidad.calcularMontoApostado(monto);
        if (DividendoValido()) {
            this.montoACobrar = modalidad.calcularMontoGanado(monto, dividendoActual,
                    participacion.calcularTotalApuestas());
        }
    }

    public int getNroCarrera() {
        return nroCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public int getNroCaballo() {
        return nroCaballo;
    }

    public String getNombreCaballo() {
        return nombreCaballo;
    }

    public String getTipoApuesta() {
        return tipoApuesta;
    }

    public Double getDividendoActual() {
        return dividendoActual;
    }

    public boolean DividendoValido() {
        return dividendoValido;
    }

    public Double getMontoApostado() {
        return montoApostado;
    }

    public Double getMontoADebitar() {
        return montoADebitar;
    }

    public Double getMontoACobrar() {
        return montoACobrar;
    }
}
