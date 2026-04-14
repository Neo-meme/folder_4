import java.util.List;
import java.util.ArrayList;

public class CasaDeApuestas{

    private String nombre;
    private List<EventoDeportivo> eventos; //agregacion 1 a n 
    private List<jugador> jugadores; //agregacion 1 a n 
    private List<TicketApuesta> tickets; //agregacion 1 a n 

    //constructor
    public CasaDeApuestas(String nombre) {
        this.nombre = nombre;
        this.eventos = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }   

    //getters y setters
    public String getNombre() {
        return nombre;
    }  

    public List<EventoDeportivo> getEventos() {
        return eventos;
    }

    public List<jugador> getJugadores() {
        return jugadores;
    }

    public List<TicketApuesta> getTickets() {
        return tickets;
    }

    //agregacion EventoDeportivo
    public void crearEvento(EventoDeportivo evento) {
        eventos.add(evento);
    }
    public void eliminarEvento(EventoDeportivo evento) {
        eventos.remove(evento);
    }

    //agregacion jugador
    public void crearJugador(jugador jugador) {
        jugadores.add(jugador);
    }
    public void eliminarJugador(jugador jugador) {
        jugadores.remove(jugador);
    }

    //agregacion TicketApuesta
    public void crearTicket(TicketApuesta ticket) {
        tickets.add(ticket);
    }
    public void eliminarTicket(TicketApuesta ticket) {
        tickets.remove(ticket);
    }

}