package uy.edu.ort.obligatorioDA.dtos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import uy.edu.ort.obligatorioDA.dominio.Carrera;
import uy.edu.ort.obligatorioDA.dominio.Participacion;

public class CarreraApostableDto {
    private int numero;
    private String nombre;
    private String fecha;
    private List<ParticipacionDto> participaciones;

    public CarreraApostableDto(Carrera c) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.numero = c.getIdCarrera();
        this.nombre = c.getNombreCarrera();
        this.fecha = c.getFecha() != null ? sdf.format(c.getFecha()) : "";
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

    public String getFecha() {
        return fecha;
    }

    public List<ParticipacionDto> getParticipaciones() {
        return participaciones;
    }
}
