# LinkedIn — Proyectos + posteo del título

Todo listo para copiar y pegar. Los textos entre `[corchetes]` son los únicos que tenés que completar vos.

---

## 1. Dónde va cada cosa

**Sección Proyectos:** Perfil → *Añadir sección* → *Contenido adicional* → *Añadir proyectos*.
Campos que te va a pedir: Nombre · Descripción (máx. 2.000 caracteres) · Fecha de inicio / fin · Asociado a (elegí Universidad ORT Uruguay) · URL del proyecto · Colaboradores (podés etiquetar a tus compañeros) · Aptitudes (hasta 5, y son las que después LinkedIn usa para matchear búsquedas).

**Título intermedio:** va en **Educación** (editás la entrada de ORT y agregás el título) y además conviene cargarlo en **Licencias y certificaciones** — así aparece como un ítem propio y genera una notificación a tu red.

---

## 2. Proyecto 1 — RecetasApp

> Recomendación: **una sola entrada** para los dos repos. LinkedIn te deja un solo campo de URL, así que el link principal va al front (que es lo que se puede *ver* funcionando) y el back lo mencionás en la descripción. Si preferís separarlos, abajo te dejo la versión en dos entradas.

### Opción A — Entrada única (recomendada)

**Nombre**
```
RecetasApp — Plataforma fullstack de recetas con IA
```

**Asociado a:** Universidad ORT Uruguay
**Fechas:** [mes/año de inicio] – [mes/año de fin]
**URL:** https://front-obligatorio-fullstack.vercel.app

**Descripción**
```
Aplicación web fullstack para crear, gestionar y descubrir recetas de cocina, con generación y adaptación de recetas mediante IA.

Backend (Node.js + Express 5 + MongoDB/Mongoose): API REST con autenticación JWT y roles (usuario/admin), validación de entrada con Joi, hasheo de contraseñas con BcryptJS, rate limiting y buenas prácticas OWASP. Subida de imágenes con Multer + Cloudinary, paginado y filtrado de recetas, y sistema de planes (Plus con límite de recetas y Premium ilimitado). Integración con Google Gemini 2.5 Flash para generar recetas y variantes (vegana, sin gluten, etc.).

Frontend (React 19 + Vite + Redux Toolkit + React Router 7): SPA con rutas protegidas por token, ABM completo de recetas, categorías y reseñas, formularios con React Hook Form + Joi, métricas y gráficas con Chart.js y notificaciones con Sonner.

Ambas partes desplegadas en Vercel.

Repositorios:
• Backend: https://github.com/Alpatuta/OBLIGATORIO_FULLSTACK
• Frontend: https://github.com/Alpatuta/FRONT_OBLIGATORIO_FULLSTACK
```

**Aptitudes sugeridas (5):** React · Node.js · MongoDB · API REST · JavaScript

---

### Opción B — Dos entradas separadas

**Entrada 1 — Nombre**
```
RecetasApp — API REST (Backend)
```
**URL:** https://github.com/Alpatuta/OBLIGATORIO_FULLSTACK

**Descripción**
```
API REST para una aplicación de gestión de recetas, desarrollada con Node.js y Express 5 sobre MongoDB (Mongoose).

Funcionalidades: autenticación con JWT y control de acceso por roles (usuario/admin), ABM de recetas, categorías, ingredientes y reseñas, sistema de planes de suscripción (Plus y Premium), subida de imágenes a Cloudinary vía Multer, paginado y filtrado, rate limiting y validación de entrada con Joi siguiendo lineamientos OWASP.

Integración con Google Gemini 2.5 Flash para generar recetas a medida y crear variantes adaptadas a restricciones alimentarias.

Desplegada en Vercel. Obligatorio 1 de Desarrollo Fullstack — Universidad ORT Uruguay.
```
**Aptitudes:** Node.js · Express.js · MongoDB · API REST · JWT

**Entrada 2 — Nombre**
```
RecetasApp — SPA en React (Frontend)
```
**URL:** https://front-obligatorio-fullstack.vercel.app

**Descripción**
```
Single Page Application en React 19 + Vite que consume la API REST de RecetasApp.

Funcionalidades: registro y login con JWT y rutas protegidas, ABM de recetas con carga de imágenes y niveles de dificultad, gestión de categorías y reseñas, panel con métricas y gráficas en tiempo real (Chart.js), y funciones de IA para generar y adaptar recetas según restricciones alimentarias.

Stack: React 19, Vite, Redux Toolkit, React Router 7, React Hook Form + Joi, Axios y Sonner. Desplegada en Vercel.

Repositorio: https://github.com/Alpatuta/FRONT_OBLIGATORIO_FULLSTACK
```
**Aptitudes:** React · Redux · JavaScript · Vite · Desarrollo front-end

---

## 3. Proyecto 2 — Sistema de apuestas hípicas (Java + Spring Boot)

**Nombre**
```
MalaPATA — Sistema de apuestas hípicas en tiempo real (Java + Spring Boot)
```

**Asociado a:** Universidad ORT Uruguay
**Fechas:** Marzo 2026 – Julio 2026
**URL:** https://github.com/Alpatuta/DA-2026Marzo-M4B-346421-274712

**Descripción**
```
Aplicación web para la gestión de un hipódromo y sus apuestas, desarrollada como obligatorio de Diseño de Aplicaciones con foco en arquitectura en capas y patrones de diseño.

El sistema modela jornadas, carreras, caballos y participaciones. Los jugadores apuestan en distintas modalidades (Simple, Triple y Súper) y siguen sus apuestas, dividendos y saldo desde su tablero; el administrador gestiona el ciclo de vida de cada carrera (abrir, cerrar, finalizar con ganador) y controla el balance de la jornada: total apostado, total pagado y comisiones. Cuando el administrador cambia el estado de una carrera, los tableros de todos los jugadores conectados se actualizan solos, sin recargar la página, mediante Server-Sent Events.

Patrones aplicados:
• Fachada — punto de entrada único a la lógica de negocio, que desacopla la capa de presentación de los servicios.
• Observer — notificación en tiempo real a los navegadores conectados ante cada cambio de estado.
• State — el ciclo de vida de la carrera (abierta, cerrada, definida, finalizada) resuelto con estados intercambiables en lugar de condicionales.
• Strategy — cada modalidad de apuesta encapsula su propia lógica de validación y de cálculo de premios.
• Command — despacho uniforme de las acciones de la interfaz hacia el servidor.
• MVP (Model–View–Presenter) y DTOs para separar el dominio de lo que se expone a la vista.

Stack: Java 21, Spring Boot 4, Spring Web MVC, Maven, Lombok, y un front en HTML/CSS/JavaScript sin frameworks. El diseño se modeló previamente en UML (Astah).

Trabajo en equipo de dos personas, con control de versiones en Git.
```

**Aptitudes sugeridas (5):** Java · Spring Boot · Patrones de diseño · Programación orientada a objetos · Arquitectura de software

---

## 4. Posteo del título — Programador Web

Elegí una de las dos. Las dos entran cómodas en el límite de 3.000 caracteres.

### Versión A (la que te recomiendo)

```
Hoy levanté mi título de Programador Web en la Universidad ORT Uruguay 🎓

Suena a un papel más, pero para mí cierra una etapa concreta: la de pasar de "quiero aprender a programar" a poder sentarme, agarrar un problema y resolverlo de punta a punta. En el camino aprendí muchísimo más de lo que esperaba, y buena parte fue peleándome con código que no compilaba a las 2 de la mañana.

Gracias a mi familia, que me bancó desde el primer día. A mis compañeros, que hicieron que los obligatorios fueran mucho más llevaderos (y bastante más divertidos). Y a los docentes de ORT, por exigir en serio y enseñar mejor todavía.

Ahora sigo con la carrera y con ganas de seguir construyendo cosas. Dejo por acá algunos de los proyectos que fui armando en el camino, por si a alguien le sirve o le da curiosidad 👇

#ProgramadorWeb #UniversidadORT #DesarrolloWeb #React #NodeJS #Uruguay
```

### Versión B (más corta)

```
Título de Programador Web ✅ — Universidad ORT Uruguay 🎓

Dos años de obligatorios, noches largas y muchísimo aprendizaje. Gracias a mi familia por el aguante, a mis compañeros por hacer el camino más liviano y a los docentes de ORT por la exigencia y la dedicación.

Es un primer paso: sigo con la carrera y con muchas ganas de seguir sumando proyectos y experiencia en desarrollo.

#ProgramadorWeb #UniversidadORT #DesarrolloWeb #Uruguay
```

**Tips para que rinda más:**

- Subí una foto (vos con el diploma, o con tus compañeros). Los posteos con imagen tienen bastante más alcance que los de solo texto.
- Publicá entre martes y jueves, a la mañana temprano (8–10 h).
- Cargá primero el título en Educación y Proyectos, y publicá el posteo después: así, cuando alguien entra a tu perfil desde el posteo, ya encuentra todo actualizado.
- Contestá los comentarios en la primera hora, ayuda al alcance.

---

## 5. Dos ajustes extra que valen la pena

**Titular (headline)** — hoy tenés algo genérico; probá con:
```
Programador Web | Estudiante de Tecnologías de la Información en Universidad ORT | React · Node.js · Java/Spring Boot
```

**Acerca de (About)** — versión corta para pegar:
```
Estudiante de Tecnologías de la Información en la Universidad ORT Uruguay y Programador Web titulado.

Me muevo cómodo en desarrollo web fullstack: React, JavaScript y Node.js del lado de la aplicación, MongoDB y SQL en datos, y Java (Spring Boot) y C# en programación orientada a objetos y diseño con patrones. Últimamente me interesa mucho todo lo que tiene que ver con integrar IA en productos reales — mi último proyecto usa la API de Gemini para generar y adaptar recetas según restricciones alimentarias.

Busco mi primera experiencia laboral en desarrollo, donde pueda aportar y sobre todo aprender de gente con más recorrido.

Podés ver mis proyectos en github.com/Alpatuta
```
