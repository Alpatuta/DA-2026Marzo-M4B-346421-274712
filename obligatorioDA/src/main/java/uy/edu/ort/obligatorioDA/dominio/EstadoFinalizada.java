package uy.edu.ort.obligatorioDA.dominio;

public class EstadoFinalizada extends EstadoCarrera {

    public EstadoFinalizada() {
        super("FINALIZADA");
    }

    @Override
    public boolean permiteApuestas() {
        return false;
    }

   
}
