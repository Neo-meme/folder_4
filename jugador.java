import java.util.List;
import java.util.ArrayList;

public class jugador extends Persona {

    // ASOCIACIÓN: Un jugador puede tener múltiples tickets,
    // pero los tickets pueden existir sin el jugador.

    // Atributos
    private String id;
    private double saldo;
    private List<TicketApuesta> tickets; // Asociación

    //constructor
    public jugador(String nombre, String id, double saldo) {
        super(nombre);
        this.id = id;
        this.saldo = saldo;
        this.tickets = new ArrayList<>();
    }

    //metodo abstracto
    @Override
    public String getIdentificador() {
        return id;
    }

    //getters y setters
    public String getId() { 
        return id;
    }   
    public double getSaldo() {
        return saldo;
    }   
    public List<TicketApuesta> getTickets() {
        return tickets;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTickets(List<TicketApuesta> tickets) {
        this.tickets = tickets;
    }

    //asociacion TicketApuesta
    public void crearTicket(TicketApuesta ticket) {
        tickets.add(ticket);
    }   

    public void eliminarTicket(TicketApuesta ticket) {
        tickets.remove(ticket);
    }

    //metodos para manejar el saldo del jugador
    public void depositar(double monto) {
        saldo += monto;
    }

    public boolean retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }


    
}
