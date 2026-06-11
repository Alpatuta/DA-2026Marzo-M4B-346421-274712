package uy.edu.ort.obligatorioDA.dtos;

import uy.edu.ort.obligatorioDA.dominio.Jugador;

public class JugadorDto {
    private String nombreUsuario;
    private String nombreCompleto;
    private Double saldo;

    public JugadorDto(Jugador jugador) {
        this.nombreUsuario = jugador.getNombreUsuario();
        this.nombreCompleto = jugador.getNombreCompleto();
        this.saldo = jugador.getSaldo();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Double getSaldo() {
        return saldo;
    }
}
