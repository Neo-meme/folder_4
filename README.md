
# Sistema de Casa de Apuestas (Java)
Este proyecto consiste en el desarrollo de un sistema de consola en Java que simula el funcionamiento básico de una casa de apuestas deportivas.

Permite registrar jugadores, crear eventos deportivos, generar apuestas (simples y múltiples) y gestionar tickets.
## Objetivos
Aplicar conceptos de Programación Orientada a Objetos (POO) como:
- Clases y objetos
- Herencia
- Asociación, agregación y composición
- Encapsulamiento
- Manejo de colecciones (ArrayList)
- Validación de datos por consola
## Tecnologías
- Java
- Programación Orientada a Objetos (POO)
- github
## Funcionalidades
El sistema permite:
1. Registrar jugadores con:
- Nombre
- Identificador
- Saldo inicial
2. Registrar eventos con:
- Código
- Descripción (ej: Colombia vs Brasil)
- Cuotas:
    - Local
    - Empate
    - Visitante
3. Crear tickets de apuesta múltiple
- Seleccionar:
    - Jugador
    - Uno o varios eventos
    - Pronóstico (LOCAL, EMPATE, VISITANTE)
- Ingresar monto de apuesta
- Validar saldo disponible
4. Se calcula automáticamente la ganancia potencial
- formula:
    - ganancia = monto × cuotas combinadas

5. Listado de tickets:
- Mostrar todos los tickets creados
- Incluye:
    - Código del ticket
    - Jugador
    - Monto
    - Líneas de apuesta

## Estructura del Proyecto
1. Clases principales
- Main → Controla el menú y la interacción
- CasaDeApuestas → Administra jugadores, eventos y tickets
- Jugador → Representa a un usuario con saldo
- EventoDeportivo → Contiene información del evento y cuotas
- LineaApuesta → Relaciona evento + pronóstico
- ApuestaMultiple → Maneja múltiples líneas y cálculo de ganancia
- TicketApuesta → Contenedor final de la apuesta
- TipoPronostico → Enum (LOCAL, EMPATE, VISITANTE)

## Relaciones POO
1. herencia
- Jugador hereda de Persona
2. Asociación
- LineaApuesta → tiene un EventoDeportivo
3. agregación
- CasaDeApuestas → contiene:
    - Jugadores
    - Eventos
    - Tickets
4. composición
- TicketApuesta → contiene LineaApuesta
- Si el ticket se elimina, sus líneas también

## Ejemplo


    Salida:
    ===== CASA DE APUESTAS =====
    1. Registrar jugador
    2. Registrar evento deportivo
    3. Crear ticket de apuesta
    4. Listar tickets
    5. Salir

    Seleccione una opción: 1
    Ingrese el nombre del jugador: Juan
    Ingrese el ID del jugador: j1
    Ingrese el saldo inicial del jugador: $100
    Jugador registrado correctamente.

    ===== CASA DE APUESTAS =====
    Seleccione una opción: 2
    Codigo del evento: e1
    Descripcion del evento: Colombia vs Brasil
    Cuota Local: $2.1
    Cuota Empate: $3.8
    Cuota Visitante: $2.5

    ===== CASA DE APUESTAS =====
    Seleccione una opción: 2
    Codigo del evento: e2
    Descripcion del evento: Argentina vs Chile
    Cuota Local: $1.9
    Cuota Empate: $3.2
    Cuota Visitante: $2.8

    ===== CASA DE APUESTAS =====
    Seleccione una opción: 3
    Seleccione un jugador:
    1. j1
    Opción: 1

    Seleccione un evento:
    1. Colombia vs Brasil
    2. Argentina vs Chile
    Opción: 1

    Seleccione pronóstico:
    1. LOCAL  2. EMPATE  3. VISITANTE
    Opción: 1

    ¿Agregar otra línea? (s/n): s

    Seleccione un evento:
    1. Colombia vs Brasil
    2. Argentina vs Chile
    Opción: 2

    Seleccione pronóstico:
    1. LOCAL  2. EMPATE  3. VISITANTE
    Opción: 3

    ¿Agregar otra línea? (s/n): n

    Ingrese el monto de la apuesta: $50
    Saldo restante: 50.0
    Ganancia potencial: $294.0

    ===== CASA DE APUESTAS =====
    Seleccione una opción: 4

    --- Tickets Registrados ---

    Código Ticket: T1
    Jugador: j1
    Monto: 50.0
    Líneas de apuesta:
    - Evento: Colombia vs Brasil | Pronóstico: LOCAL | Cuota: 2.1
    - Evento: Argentina vs Chile | Pronóstico: VISITANTE | Cuota: 2.8

    ----------------------

    ===== CASA DE APUESTAS =====
    Seleccione una opción: 5
    Saliendo del sistema...

## Autor
- Juan David Merchán

   