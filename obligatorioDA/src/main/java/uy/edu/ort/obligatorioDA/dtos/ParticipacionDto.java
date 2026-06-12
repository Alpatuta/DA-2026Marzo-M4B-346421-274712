package uy.edu.ort.obligatorioDA.dtos;

import uy.edu.ort.obligatorioDA.dominio.Participacion;

public class ParticipacionDto {

    private int nroParticipacion;
    private String nombreCaballo;
    private Double dividendoActual;
    private boolean dividendoValido;
    private Double totalApostado;
    private int cantidadApuestas;

    public ParticipacionDto(Participacion p) {
        this.nroParticipacion = p.getNroParticipacion();
        this.nombreCaballo = p.getCaballo().getNombre();
        this.dividendoActual = p.getDividendoActual();
        this.dividendoValido = p.dividendoValido();
        this.totalApostado = p.calcularTotalApuestas();
        this.cantidadApuestas = p.cantidadApuestasParticipacion();
    }

    public int getNroParticipacion() {
        return nroParticipacion;
    }

    public String getNombreCaballo() {
        return nombreCaballo;
    }

    public Double getDividendoActual() {
        return dividendoActual;
    }

    public boolean getDividendoValido() {
        return dividendoValido;
    }

    public Double getTotalApostado() {
        return totalApostado;
    }

    public int getCantidadApuestas() {
        return cantidadApuestas;
    }


}
