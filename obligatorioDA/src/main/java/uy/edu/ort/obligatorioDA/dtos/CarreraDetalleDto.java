package uy.edu.ort.obligatorioDA.dtos;

import java.util.ArrayList;
import java.util.List;

import uy.edu.ort.obligatorioDA.dominio.Carrera;
import uy.edu.ort.obligatorioDA.dominio.Participacion;

public class CarreraDetalleDto {

    private int numero;
    private String nombre;
    private String estado;
    private Double totalApostado;
    private List<ParticipacionDto> participaciones;

    public CarreraDetalleDto(Carrera c) {
        this.numero = c.getNumero();
        this.nombre = c.getNombreCarrera();
        this.estado = c.getEstado().getNombre();
        this.totalApostado = c.calcularTotalApostado();
        this.participaciones = new ArrayList<>();
        for (Participacion p : c.getParticipantes()) {
            participaciones.add(new ParticipacionDto(p));
        }
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public Double getTotalApostado() {
        return totalApostado;
    }

    public List<ParticipacionDto> getParticipaciones() {
        return participaciones;
    }


}
