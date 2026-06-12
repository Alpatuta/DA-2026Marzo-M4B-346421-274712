package uy.edu.ort.obligatorioDA.dtos;

public class ApuestaEnCursoDto {
    private int idCarrera;
    private int nroParticipacion;
    private String nombreModalidad;
    private double monto;

    public ApuestaEnCursoDto(int idCarrera, int nroParticipacion, String nombreModalidad, double monto) {
        this.idCarrera = idCarrera;
        this.nroParticipacion = nroParticipacion;
        this.nombreModalidad = nombreModalidad;
        this.monto = monto;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public int getNroParticipacion() {
        return nroParticipacion;
    }

    public String getNombreModalidad() {
        return nombreModalidad;
    }

    public double getMonto() {
        return monto;
    }
}