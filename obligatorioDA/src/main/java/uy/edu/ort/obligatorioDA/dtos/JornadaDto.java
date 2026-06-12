package uy.edu.ort.obligatorioDA.dtos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import uy.edu.ort.obligatorioDA.dominio.Carrera;
import uy.edu.ort.obligatorioDA.dominio.Jornada;

public class JornadaDto {
    private String fecha;
    private Double totalApostado;
    private Double totalPagado;
    private Double totalComisiones;
    private Double balance;
    private int cantidadCarreras;
    private int cantidadCarrerasFinalizadas;
    private int cantidadCarrerasPorCorrer;
    private List<CarreraFinalizadaDto> carrerasFinalizadas;
    private List<CarreraProximaDto> proximasCarreras;

    public JornadaDto(Jornada jornada, float comision) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        this.fecha = sdf.format(jornada.getFecha());
        this.totalApostado = jornada.totalApostado();
        this.totalPagado = jornada.totalPagado();
        this.totalComisiones = jornada.totalComisiones(comision);
        this.balance = jornada.balance();
        this.cantidadCarreras = jornada.cantidadCarreras();
        this.cantidadCarrerasFinalizadas = jornada.cantidadCarrerasFinalizadas();
        this.cantidadCarrerasPorCorrer = jornada.cantidadCarrerasPorCorrer();
        this.carrerasFinalizadas = new ArrayList<>();
        for (Carrera c : jornada.carrerasFinalizadasOrdenadasDesc()) {
            carrerasFinalizadas.add(new CarreraFinalizadaDto(c));
        }
        this.proximasCarreras = new ArrayList<>();
        for (Carrera c : jornada.proximasCarreras()) {
            proximasCarreras.add(new CarreraProximaDto(c));
        }
    }
    

    public String getFecha() {
        return fecha;
    }

    public Double getTotalApostado() {
        return totalApostado;
    }

    public Double getTotalPagado() {
        return totalPagado;
    }

    public Double getTotalComisiones() {
        return totalComisiones;
    }

    public Double getBalance() {
        return balance;
    }

    public int getCantidadCarreras() {
        return cantidadCarreras;
    }

    public int getCantidadCarrerasFinalizadas() {
        return cantidadCarrerasFinalizadas;
    }

    public int getCantidadCarrerasPorCorrer() {
        return cantidadCarrerasPorCorrer;
    }
    
    public List<CarreraFinalizadaDto> getCarrerasFinalizadas() {
        return carrerasFinalizadas;
    }

    public List<CarreraProximaDto> getProximasCarreras() {
        return proximasCarreras;
    }
}
