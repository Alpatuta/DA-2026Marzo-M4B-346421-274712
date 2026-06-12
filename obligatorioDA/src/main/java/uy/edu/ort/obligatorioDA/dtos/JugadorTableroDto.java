package uy.edu.ort.obligatorioDA.dtos;

import uy.edu.ort.obligatorioDA.dominio.Jugador;

public class JugadorTableroDto {
    private String nombreCompleto;
    private Double saldo;
    private Double totalApostado;
    private Double totalGanado;

    public JugadorTableroDto(Jugador j) {
        this.nombreCompleto = j.getNombreCompleto();
        this.saldo = j.getSaldo();
        this.totalApostado = j.totalApostado();
        this.totalGanado = j.totalGanado();
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    public Double getSaldo() {
        return saldo;
    }

    public Double getTotalApostado() {
        return totalApostado;
    }

    public Double getTotalGanado() {
        return totalGanado;
    }

    
}
