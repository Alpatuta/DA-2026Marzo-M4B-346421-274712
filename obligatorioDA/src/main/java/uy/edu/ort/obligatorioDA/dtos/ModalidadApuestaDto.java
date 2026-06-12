package uy.edu.ort.obligatorioDA.dtos;

import uy.edu.ort.obligatorioDA.dominio.ModalidadApuesta;

public class ModalidadApuestaDto {

    private String nombre;

    public ModalidadApuestaDto(ModalidadApuesta m) {
        this.nombre = m.getNombre();
    }

    public String getNombre() {
        return nombre;
    }
}
