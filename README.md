# 🐴 MalaPATA — Sistema de apuestas hípicas

Aplicación web para la gestión de un hipódromo y sus apuestas, con tableros que se actualizan en tiempo real.

Obligatorio de **Diseño de Aplicaciones** — Universidad ORT Uruguay, marzo–julio 2026.

---

## De qué se trata

El sistema modela una jornada hípica: un conjunto de carreras, cada una con sus caballos participantes y sus dividendos. Hay dos tipos de usuario, cada uno con su propio tablero:

**Jugador**

- Ve su saldo, su total apostado y su total ganado.
- Ve las carreras abiertas con los caballos y el dividendo actual de cada uno.
- Apuesta eligiendo caballo, modalidad y monto, con una pantalla de confirmación previa.
- Sigue el estado de todas sus apuestas: dividendo final, monto cobrado y si la carrera ya se corrió.

**Administrador**

- Ve el resumen de la jornada: total apostado, total pagado, comisiones y balance.
- Gestiona el ciclo de vida de cada carrera: abrirla, cerrarla y finalizarla indicando el caballo ganador.
- Avanza o retrocede la jornada.
- Consulta el detalle de cada carrera con los montos y la cantidad de apuestas por caballo.

Cuando el administrador cierra o finaliza una carrera, **los tableros de todos los jugadores conectados se actualizan solos**, sin recargar la página.

---

## Patrones de diseño aplicados

| Patrón | Dónde | Para qué |
|---|---|---|
| **Fachada** | `servicios/Fachada/Fachada.java` | Punto de entrada único a la lógica de negocio. Los presentadores nunca hablan directo con los servicios. |
| **Observer** | `Observer/Observable.java`, `IObservador`, `ConexionNavegador` | Cada navegador conectado se registra como observador. Ante un cambio de estado, el dominio notifica y la vista se refresca vía Server-Sent Events. |
| **State** | `dominio/EstadoCarrera` + `EstadoAbierta`, `EstadoCerrada`, `EstadoDefinida`, `EstadoEstable`, `EstadoFinalizada` | El ciclo de vida de la carrera vive en objetos de estado intercambiables. Cada estado sabe qué transiciones permite, en lugar de resolverlo con cadenas de `if`. |
| **Strategy** | `dominio/ModalidadApuesta` + `ModalidadSimple`, `ModalidadTriple`, `ModalidadSuper` | Cada modalidad de apuesta encapsula su propia validación y su cálculo de premio. Agregar una modalidad nueva no toca el código existente. |
| **Command** | `presentadores/Command.java`, `Commands.java` + `static/CommandDispatcher.js` | Toda acción de la interfaz viaja al servidor con el mismo protocolo, y la respuesta vuelve como una lista de comandos que la vista sabe interpretar. |
| **MVP** | `presentadores/` | Cada pantalla tiene su presentador. La vista solo renderiza; la decisión de qué mostrar es del presentador. |
| **DTO** | `dtos/` | El dominio nunca se expone directo a la vista. |

---

## Stack

- **Java 21** · **Spring Boot 4.0.6** (Spring Web MVC) · **Maven** · **Lombok**
- Front en **HTML + CSS + JavaScript** puro (módulos ES, sin frameworks)
- **Server-Sent Events** para el push del servidor al navegador
- Datos **en memoria**, precargados al arrancar desde `datosPrueba/DatosPrecarga.java` (no requiere base de datos)

---

## Cómo correrlo

Requisitos: JDK 21.

```bash
cd obligatorioDA
./mvnw spring-boot:run        # en Windows: mvnw.cmd spring-boot:run
```

Después, en el navegador:

- Jugador → http://localhost:8080/loginJugador.html
- Administrador → http://localhost:8080/loginAdmin.html

Los usuarios de prueba están en `DatosPrecarga.java`.

> Para ver la actualización en tiempo real, abrí el tablero del jugador en una ventana y el del administrador en otra (o en una ventana de incógnito, para no compartir la sesión) y finalizá una carrera desde el admin.

---

## Estructura del proyecto

```
obligatorioDA/src/main/
├── java/uy/edu/ort/obligatorioDA/
│   ├── ObligatorioDaApplication.java
│   ├── conf/            → configuración de la aplicación
│   ├── datosPrueba/     → precarga de datos en memoria
│   ├── dominio/         → Hipodromo, Jornada, Carrera, Caballo, Participacion,
│   │                      Apuesta, Jugador, Administrador + estados y modalidades
│   ├── dtos/            → objetos de transferencia hacia las vistas
│   ├── excepciones/     → ObligatorioException + manejador global
│   ├── Observer/        → Observable, IObservador, ConexionNavegador (SSE)
│   ├── presentadores/   → un presentador por pantalla + Command / Commands
│   └── servicios/       → SistemaCarrera, SistemaApuesta, SistemaUsuario y la Fachada
└── resources/static/    → las 6 pantallas (HTML + CSS) y los dispatchers JS
```

## Documentación

- `DA-LetraObligatorioAbril2026Publicada.pdf` — letra del obligatorio
- `DiagramasObligatorio.asta` — diagramas UML (Astah)

---

## Equipo

Grupo M4B — Federico Oteiza y Rodrigo Pintos.
