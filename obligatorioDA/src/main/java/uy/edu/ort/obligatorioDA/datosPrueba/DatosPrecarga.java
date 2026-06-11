package uy.edu.ort.obligatorioDA.datosPrueba;

import uy.edu.ort.obligatorioDA.dominio.Administrador;
import uy.edu.ort.obligatorioDA.dominio.Jugador;
import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;

public class DatosPrecarga {
    public static void cargar() {
        Fachada f = Fachada.getInstancia();
        try {
            // Admins
            f.agregarUsuario(new Administrador("a1", "Usuario Administrador", "a1"));
            f.agregarUsuario(new Administrador("a2", "Segundo Administrador", "a2"));

            // Jugadores
            f.agregarUsuario(new Jugador("j1", "Usuario Jugador", "j1", 2000.0));
            f.agregarUsuario(new Jugador("j2", "Segundo Jugador", "j2", 1500.0));

            // Comisión del hipódromo: 10%
            f.setComisionHipodromo(10.0f);

            // ... (carreras, caballos, etc. se agregan acá también)
        } catch (Exception e) {
            System.out.println("Error precarga: " + e.getMessage());
        }
    }
}
