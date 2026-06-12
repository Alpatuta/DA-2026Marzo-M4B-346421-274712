package uy.edu.ort.obligatorioDA.dtos;

import uy.edu.ort.obligatorioDA.dominio.Carrera;

public class CarreraProximaDto {
    private int idCarrera;
    private int numero;
    private String estado;
    private int cantidadCaballos;
    private Double totalApostado;
    private int cantidadApuestas;

    public CarreraProximaDto(Carrera carrera) {
        this.idCarrera = carrera.getIdCarrera();
        this.numero = carrera.getIdCarrera();
        this.estado = carrera.getEstado().getNombre();
        this.cantidadCaballos = carrera.cantidadCaballosParticipantes();
        this.totalApostado = carrera.calcularTotalApostado();
        this.cantidadApuestas = carrera.cantidadApuestasCarrera();
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public int getNumero() {
        return numero;
    }

    public String getEstado() {
        return estado;
    }

    public int getCantidadCaballos() {
        return cantidadCaballos;
    }

    public Double getTotalApostado() {
        return totalApostado;
    }

    public int getCantidadApuestas() {
        return cantidadApuestas;
    }

}
