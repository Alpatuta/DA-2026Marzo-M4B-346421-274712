package uy.edu.ort.obligatorioDA.datosPrueba;

import uy.edu.ort.obligatorioDA.dominio.Administrador;
import uy.edu.ort.obligatorioDA.dominio.Jugador;
import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;

public class DatosPrecarga {
    public static void cargar() {
        Fachada f = Fachada.getInstancia();
        try {
            // Admins
            f.agregarUsuario(new Administrador("a1", "a1", "Usuario Administrador"));
            f.agregarUsuario(new Administrador("a2", "a2", "Segundo Administrador"));

            // Jugadores
            f.agregarUsuario(new Jugador("j1", "j1", "Usuario Jugador", 2000.0));
            f.agregarUsuario(new Jugador("j2", "j2", "Segundo Jugador", 1500.0));

            // Comisión del hipódromo: 10%
            f.setComisionHipodromo(10.0f);

            // ... (carreras, caballos, etc. se agregan acá también)
        } catch (Exception e) {
            System.out.println("Error precarga: " + e.getMessage());
        }
    }
}
