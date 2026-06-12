package uy.edu.ort.obligatorioDA.datosPrueba;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import uy.edu.ort.obligatorioDA.dominio.Administrador;
import uy.edu.ort.obligatorioDA.dominio.Apuesta;
import uy.edu.ort.obligatorioDA.dominio.Caballo;
import uy.edu.ort.obligatorioDA.dominio.Carrera;
import uy.edu.ort.obligatorioDA.dominio.Jornada;
import uy.edu.ort.obligatorioDA.dominio.Jugador;
import uy.edu.ort.obligatorioDA.dominio.ModalidadApuesta;
import uy.edu.ort.obligatorioDA.dominio.ModalidadSimple;
import uy.edu.ort.obligatorioDA.dominio.ModalidadSuper;
import uy.edu.ort.obligatorioDA.dominio.ModalidadTriple;
import uy.edu.ort.obligatorioDA.dominio.Participacion;
import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;

public class DatosPrecarga {

    private static List<Jugador> jugadores = new ArrayList<>();
    private static List<ModalidadApuesta> modalidades = new ArrayList<>();

    public static void cargar() {
        Fachada f = Fachada.getInstancia();
        try {
            // Comisión del hipódromo: 10% (letra pág. 3)
            f.setComisionHipodromo(10.0f);

            // Administradores (al menos 2, uno debe ser a1/a1)
            f.agregarUsuario(new Administrador("a1", "Usuario Administrador", "a1"));
            f.agregarUsuario(new Administrador("a2", "Segundo Administrador", "a2"));

            // Jugadores (varios para que las apuestas sean de jugadores diferentes)
            crearJugador(f, "j1", "Usuario Jugador", "j1", 2000.0);
            crearJugador(f, "j2", "Carlos Méndez", "j2", 15000.0);
            crearJugador(f, "j3", "Ana Torres", "j3", 12000.0);
            crearJugador(f, "j4", "Luis Pérez", "j4", 9000.0);
            crearJugador(f, "j5", "Marta Díaz", "j5", 18000.0);
            crearJugador(f, "j6", "Jorge Ruiz", "j6", 7000.0);

            // Modalidades de apuesta (letra pág. 4)
            modalidades.add(new ModalidadSimple());
            modalidades.add(new ModalidadTriple());
            modalidades.add(new ModalidadSuper());

            float comision = f.getComisionHipodromo();

            // === Jornada HOY: 3 carreras Definidas sin apuestas ===
            Jornada hoy = new Jornada(hoy());
            hoy.agregarCarrera(crearCarreraDefinida("Gran Premio del Litoral", 8));
            hoy.agregarCarrera(crearCarreraDefinida("Clásico Río de la Plata", 9));
            hoy.agregarCarrera(crearCarreraDefinida("Copa San Martín", 7));
            f.agregarJornada(hoy);

            // === Jornada SEMANA ANTERIOR: 2 carreras Cerradas con apuestas ===
            Jornada anterior = new Jornada(diasDesdeHoy(-7));
            anterior.agregarCarrera(crearCarreraCerrada("Premio Apertura", 8, comision));
            anterior.agregarCarrera(crearCarreraCerrada("Sprint del Centro", 6, comision));
            f.agregarJornada(anterior);

            // === Jornada SEMANA POSTERIOR: 1 carrera Definida ===
            Jornada posterior = new Jornada(diasDesdeHoy(7));
            posterior.agregarCarrera(crearCarreraDefinida("Gran Final", 10));
            f.agregarJornada(posterior);

            // 1) Registrar las modalidades en SistemaApuesta (no solo en la lista local)
            ModalidadApuesta simple = new ModalidadSimple();
            ModalidadApuesta triple = new ModalidadTriple();
            ModalidadApuesta sup    = new ModalidadSuper();
            f.agregarModalidad(simple);
            f.agregarModalidad(triple);
            f.agregarModalidad(sup);
            modalidades.add(simple);
            modalidades.add(triple);
            modalidades.add(sup);






            System.out.println("Datos de precarga cargados correctamente.");
        } catch (Exception e) {
            System.out.println("Error en precarga: " + e.getMessage());
        }
    }

    private static void crearJugador(Fachada f, String user, String nombre, String pass, double saldo) {
        Jugador j = new Jugador(user, nombre, pass, saldo);
        f.agregarUsuario(j);
        jugadores.add(j);
    }

    private static Carrera crearCarreraDefinida(String nombre, int cantCaballos) {
        Carrera c = new Carrera(nombre);
        for (int i = 1; i <= cantCaballos; i++) {
            Participacion p = new Participacion(i, c, new Caballo("Caballo " + i + " - " + nombre));
            c.agregarParticipante(p);
        }
        return c; // queda en EstadoDefinida (estado inicial del constructor)
    }

    private static Carrera crearCarreraCerrada(String nombre, int cantCaballos, float comision) throws Exception {
        Carrera c = new Carrera(nombre);
        for (int i = 1; i <= cantCaballos; i++) {
            Participacion p = new Participacion(i, c, new Caballo("Caballo " + i + " - " + nombre));
            c.agregarParticipante(p);
        }

        c.getEstado().abrir(c); // Definida → Abierta

        int idx = 0;
        for (Participacion p : c.getParticipantes()) {
            int cantApuestas = 10 + (int) (Math.random() * 11); // entre 10 y 20
            for (int k = 0; k < cantApuestas; k++) {
                Jugador j = jugadores.get(idx % jugadores.size());
                ModalidadApuesta m = modalidades.get(idx % modalidades.size());
                double monto = 500 + (k * 100);
                Apuesta apuesta = new Apuesta(monto, j, m);
                p.agregarApuesta(apuesta);   // a la participación (setea la referencia inversa)
                j.agregarApuesta(apuesta);   // al jugador (para totalApostado/totalGanado/apuestas)
                idx++;
            }
        }

        c.recalcularDividendos(comision); // recalcula y, si todos válidos, Abierta → Estable
        c.getEstado().cerrar(c); // Estable → Cerrada
        return c;
    }

    private static Date hoy() {
        return new Date();
    }

    private static Date diasDesdeHoy(int dias) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, dias);
        return cal.getTime();
    }
}