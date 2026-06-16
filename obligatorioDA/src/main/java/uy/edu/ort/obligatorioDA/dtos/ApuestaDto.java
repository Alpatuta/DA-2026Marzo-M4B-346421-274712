package uy.edu.ort.obligatorioDA.dtos;

import java.text.SimpleDateFormat;

import uy.edu.ort.obligatorioDA.dominio.Apuesta;
import uy.edu.ort.obligatorioDA.dominio.Carrera;
import uy.edu.ort.obligatorioDA.dominio.Participacion;

public class ApuestaDto {
    private String fecha;
    private int nroCarrera;
    private String nombreCarrera;
    private int nroCaballo;
    private String nombreCaballo;
    private Double montoApostado;
    private String tipo;
    private Double dividendoFinal;
    private Double montoCobrado;
    private String estado;

    public ApuestaDto(Apuesta a) {
        Participacion p = a.getParticipacion();
        Carrera c = p.getCarrera();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.fecha = c.getFecha() != null ? sdf.format(c.getFecha()) : "";
        this.nroCarrera = c.getNumero();
        this.nombreCarrera = c.getNombreCarrera();
        this.nroCaballo = p.getNroParticipacion();
        this.nombreCaballo = p.getCaballo().getNombre();
        this.montoApostado = a.getMontoApostado();
        this.tipo = a.getModalidadApuesta().getNombre();
        this.dividendoFinal = a.getDividendoFinal();
        this.montoCobrado = a.getMontoCobrado();
        this.estado = a.estaFinalizada() ? "Finalizada" : "Por correr";
    }

    public String getFecha() {
        return fecha;
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

    public Double getMontoApostado() {
        return montoApostado;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getDividendoFinal() {
        return dividendoFinal;
    }

    public Double getMontoCobrado() {
        return montoCobrado;
    }

    public String getEstado() {
        return estado;
    }

}
