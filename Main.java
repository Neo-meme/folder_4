import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

     static Scanner sc = new Scanner(System.in);
     private static CasaDeApuestas casa = new CasaDeApuestas("MiCasa");
     
    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    registrarJugador();
                    break;
                case 2:
                    registrarEvento();
                    break;
                case 3:
                    crearTicketSimple();
                    break;
                case 4:
                    listarTickets();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);
    }

    // ================= MENU =================
    public static void mostrarMenu() {
        System.out.println("\n===== CASA DE APUESTAS =====");
        System.out.println("1. Registrar jugador");
        System.out.println("2. Registrar evento deportivo");
        System.out.println("3. Crear ticket");
        System.out.println("4. Listar tickets");
        System.out.println("5. Salir");
    }

    // ================= CREACION DEL JUGADOR   =================
    public static void registrarJugador() {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese el ID del jugador: ");
        String id = sc.nextLine();

        double saldo = leerDouble("Ingrese el saldo inicial del jugador: $");

        jugador nuevoJugador = new jugador(nombre, id, saldo);
        casa.crearJugador(nuevoJugador);
         /*
            aca se crea el objeto jugador con los datos que se piden, el nombre (de la clase persona) y el id y saldo (de la clase jugador). 
            aca se hace la herencia, ya que el jugador hereda de persona
         */
        System.out.println("Jugador registrado correctamente.");
    }

    // ================= CREACION DEL EVENTO  =================
    public static void registrarEvento() {
        System.out.print("Codigo del evento: ");
        String codigoEvento = sc.nextLine();

        System.out.print("Descripcion del evento: ");
        String descripcionEvento = sc.nextLine();

        double local = leerDouble("Cuota Local: $");
        double empate = leerDouble("Cuota Empate: $");
        double visitante = leerDouble("Cuota Visitante: $");

        EventoDeportivo nuevoEvento = new EventoDeportivo(codigoEvento, descripcionEvento, local, empate, visitante);
         /*
            aca se crea el objeto EventoDeportivo con los datos que se piden, el codigo, la descripcion y las cuotas. 
            y se le envia a la casa para que lo agregue a su lista de eventos, utilizando el metodo crearEvento
            que se encuentra en la clase CasaDeApuestas, y que hace la agregacion entre CasaDeApuestas y EventoDeportivo
         */
        casa.crearEvento(nuevoEvento);

    }

    // ================= CREACION DEL TICKET =================

    public static void crearTicketSimple() {

        // comprobar que la lista de jugadores y eventos no este vacia.
        if (casa.getJugadores().isEmpty() || casa.getEventos().isEmpty()) {
            System.out.println("Debe haber al menos 1 jugador y 1 evento.");
            return;
        }

        jugador jugadorSeleccionado = seleccionarJugador();

        if (jugadorSeleccionado == null) {
            System.out.println("No se seleccionó un jugador válido.");
            return;
        }

        List<LineaApuesta> lineas = new ArrayList<>();
        String continuar = null;
        
        do {
            
            EventoDeportivo eventoSeleccionado = seleccionarEvento();

            if (eventoSeleccionado == null) {
            System.out.println("No se seleccionó un evento válido.");
            return;
            }

            System.out.println("Seleccione pronóstico: || 1.LOCAL || 2.EMPATE || 3.VISITANTE || ");
            int opcion = leerEntero2("Opción: ");

            TipoPronostico tipo;

                switch (opcion) {
                case 1:
                    tipo = TipoPronostico.LOCAL;
                    break;
                case 2:
                    tipo = TipoPronostico.EMPATE;

                    break;
                case 3:
                    tipo = TipoPronostico.VISITANTE;
                    break;
                default:
                    System.out.println("Opción inválida.");
                    continue;
                }
            
            // Crear línea
            LineaApuesta linea = new LineaApuesta(eventoSeleccionado, tipo);
            lineas.add(linea);
            
            System.out.print("¿Agregar otra línea? (s/n): ");
            continuar = sc.nextLine();
            
        } while (continuar.equalsIgnoreCase("s"));
        
        double monto = leerDouble("Ingrese el monto de la apuesta: $");

        /*
            aca se comprueba el saldo y se retira el monto del jugador seleccionado, 
            utilizando el metodo retirar que se encuentra en la clase jugador
         */
       

        if (!jugadorSeleccionado.retirar(monto)) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        //prueba para ver si si retira el monto del jugador seleccionado
        System.out.println("Saldo restante: " + jugadorSeleccionado.getSaldo());
 
        // Crear apuesta multiple
        ApuestaMultiple apuesta = new ApuestaMultiple(monto, jugadorSeleccionado, lineas);

        // Crear ticket
        TicketApuesta ticket = new TicketApuesta("T"+ (casa.getTickets().size() + 1), jugadorSeleccionado, monto);

        for (LineaApuesta l : lineas) {
            ticket.agregarLinea(l);
        }

        casa.crearTicket(ticket);

        double ganancia = apuesta.calcularGananciaPotencial(monto);
        System.out.println("Ganancia potencial: $" + ganancia);

        /*
            esta mierda fue muy complicada de hacer, me enrede muchas veces :c 
            aca se crea el ticket simple, pero antes:
                1. se debe seleccionar el jugador y el evento
                2. luego se le pide el monto de la apuesta
                3. se crea la lina de apuesta con el evento seleccionado y el pronostico seleccionado
                4. se crea la apuesta simple con el monto, el jugador seleccionado y la linea de apuesta creada (aca fue donde mas me perdi)
                5. se crea el ticket con un codigo unico (en este caso se le asigna "T" + el tamaño de la lista de tickets + 1), el jugador seleccionado 
                   y el monto, y se le agrega la linea de apuesta creada
                6. se le agrega el ticket a la casa, utilizando el metodo crearTicket que se encuentra en la clase CasaDeApuestas

                ------------------------ Importante ya que se pedia en el opunto 5 -----------------------
                se le hizo una mejora ya que no se estaba usando la clase ApuestaMultiple,
                entonces ahora despues del punto 2 , se abre un ciclo do-while para agregar varias lineas de apuesta,
                y se crea la ApuestaMultiple con el monto, el jugador seleccionado y la lista de lineas creada, 
                y luego se crea el ticket con el mismo proceso que antes, pero ahora se le agrega todas las lineas creadas al ticket.
         */
        
    }


    // ================= LISTA DE TICKET =================

    public static void listarTickets() {
        System.out.println("\n--- Tickets Registrados ---");

        if (casa.getTickets().isEmpty()) {
            System.out.println("No hay tickets.");
            return;
        }

        for (TicketApuesta t : casa.getTickets()) {
            t.mostrarTicket();
            System.out.println("----------------------");
        }
    }


    // ================= COSAS PARA EVITAR ROMPER EL PROGRAMA =================
    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String entrada = sc.nextLine().toLowerCase().trim(); // aca se pasan a minusculas y con trim() se eliminan espacios al inicio y al final

                int valor;

                // Convertir palabras a números
                switch (entrada) {
                    case "uno": return 1;
                    case "dos": return 2;
                    case "tres": return 3;
                    case "cuatro": return 4;
                    case "cinco": return 5;
                    default:
                    valor = Integer.parseInt(entrada);
                }
                
                if (valor < 1 || valor > 5) {
                    System.out.println("Ingrese un número entre 1 y 5.");
                    continue;
                }

                return valor;

            } catch (Exception e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    //este leerEntero2 solo es para la seleccion del pronostico 
    public static int leerEntero2(String mensaje) {
    while (true) {
        try {
            System.out.print(mensaje);
            String entrada = sc.nextLine().toLowerCase().trim();

            int valor;

            // Convertir palabras a números
            switch (entrada) {
                case "local": valor = 1;
                break;
                case "empate": valor = 2;
                break;
                case "visitante": valor = 3;
                break;
                default:
                valor = Integer.parseInt(entrada);
            }
            if (valor < 1 || valor > 3) {
                System.out.println("Ingrese 1, 2 o 3 (LOCAL, EMPATE, VISITANTE).");
                continue;
            }

            return valor;

        } catch (Exception e) {
            System.out.println("Ingrese un valor válido.");
        }
    }
}

    public static double leerDouble(String mensaje) {
    while (true) {
        try {
            System.out.print(mensaje);
            double valor = Double.parseDouble(sc.nextLine());

            if (valor <= 0) {
                System.out.println("El valor debe ser mayor que cero.");
                continue;
            }

            return valor;

        } catch (Exception e) {
            System.out.println("Ingrese un número válido.");
        }
    }
}

    // ================= SELECCION DE COSAS =================

    public static jugador seleccionarJugador() {
        System.out.println("Seleccione un jugador:");
        for (int i = 0; i < casa.getJugadores().size(); i++) {
            System.out.println((i + 1) + ". " + casa.getJugadores().get(i).getIdentificador());
        }
        int opcion = leerEntero("Opción: ") - 1;
        if (opcion >= 0 && opcion < casa.getJugadores().size()) {
            return casa.getJugadores().get(opcion);
        } else {
            System.out.println("Opción inválida.");
            return null;
        }
    }

    public static EventoDeportivo seleccionarEvento() {
        System.out.println("Seleccione un evento:");
        for (int i = 0; i < casa.getEventos().size(); i++) {
            System.out.println((i + 1) + ". " + casa.getEventos().get(i).getDescripcion());
        }
        int opcion = leerEntero("Opción: ") - 1;
        if (opcion >= 0 && opcion < casa.getEventos().size()) {
            return casa.getEventos().get(opcion);
        } else {
            System.out.println("Opción inválida.");
            return null;
        }
    }

}