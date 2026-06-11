package uy.edu.ort.obligatorioDA.presentadores;

public class Command {
    private String id;
    private Object parametro;

    public Command(String id, Object parametro) {
        this.id = id;
        this.parametro = parametro;
    }

    public String getId() {
        return id;
    }

    public Object getParametro() {
        return parametro;
    }
}
