import java.util.List;

public class jugador extends Persona {
    String id;
    double saldo;
    List<TicketApuesta> tickets;

    //constructor
    public jugador(String nombre, String id, double saldo) {
        super(nombre);
        this.id = id;
        this.saldo = saldo;
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

    //asociacion TicketApuesta
    public void crearTicket(TicketApuesta ticket) {
        tickets.add(ticket);
    }   

    public void eliminarTicket(TicketApuesta ticket) {
        tickets.remove(ticket);
    }


    //metodo abstracto
    @Override
    public String getIdentificador() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdentificador'");
    }
}
