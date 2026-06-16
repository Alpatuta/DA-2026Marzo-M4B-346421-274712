package uy.edu.ort.obligatorioDA.dtos;

import uy.edu.ort.obligatorioDA.dominio.Carrera;

public class CarreraFinalizadaDto {
    private int numero;
    private String horaFinalizacion;
    private int cantidadCaballos;
    private Double totalApostado;
    private Double totalPagado;
    private String nombreGanador;
    private Double dividendoFinal;

    public CarreraFinalizadaDto(Carrera carrera) {
        this.numero = carrera.getNumero();
        this.cantidadCaballos = carrera.cantidadCaballosParticipantes();
        this.totalApostado = carrera.calcularTotalApostado();
        this.totalPagado = carrera.totalPagado();
        this.horaFinalizacion = carrera.getHoraFinalizacion();
        if (carrera.getGanador() != null) {
            this.nombreGanador = carrera.getGanador().getCaballo().getNombre();
            this.dividendoFinal = carrera.getDividendoFinalGanador();
        }
    }

    public int getNumero() {
        return numero;
    }

    public String getHoraFinalizacion() {
        return horaFinalizacion;
    }

    public int getCantidadCaballos() {
        return cantidadCaballos;
    }

    public Double getTotalApostado() {
        return totalApostado;
    }

    public Double getTotalPagado() {
        return totalPagado;
    }

    public String getNombreGanador() {
        return nombreGanador;
    }

    public Double getDividendoFinal() {
        return dividendoFinal;
    }
}
