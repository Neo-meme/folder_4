import java.util.ArrayList;
import java.util.List;

public class TicketApuesta {
    private String codigo;
    private jugador jugador;
    private List<LineaApuesta> Lineas;
    private Double montoTotal;

    //constructor
    public TicketApuesta(String codigo, jugador jugador, Double monto_total) {
        this.codigo = codigo;
        this.jugador = jugador;
        this.Lineas = new ArrayList<>();
        this.montoTotal = monto_total;
    }

    //getters y setters
    public String getCodigo() {
        return codigo;
    }
    public jugador getJugador() {
        return jugador;
    }
    public List<LineaApuesta> getLineas() {
        return Lineas;
    }
    public Double getMontoTotal() {
        return montoTotal;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setJugador(jugador jugador) {
        this.jugador = jugador;
    }
    public void setLineas(List<LineaApuesta> Lineas) {
        this.Lineas = Lineas;
    }
    public void setMontoTotal(Double monto_total) {
        this.montoTotal = monto_total;
    }

    //composicion LineaApuesta
    public void agregarLinea(LineaApuesta linea) {
        Lineas.add(linea);
    }
    public void eliminarLinea(LineaApuesta linea) {
        Lineas.remove(linea);
    }

    // Método para mostrar el ticket
    public void mostrarTicket() {
        System.out.println("Código Ticket: " + codigo);
        System.out.println("Jugador: " + jugador.getIdentificador());
        System.out.println("Monto: " + montoTotal);

        System.out.println("Líneas de apuesta:");
        for (LineaApuesta linea : Lineas) {
            System.out.println("- Evento: " + linea.getEvento().getDescripcion()
                    + " | Pronóstico: " + linea.getPronostico()
                    + " | Cuota: " + linea.getCuotaSeleccionada());
        }
    }
}
