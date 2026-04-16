/**
 * Representa una línea dentro de un ticket de apuesta.
 * Relación: Asociación con EventoDeportivo
 */
public class LineaApuesta {

    // Atributos
    private EventoDeportivo evento;
    private TipoPronostico tipo;
    private double cuotaSeleccionada;

    // Constructor
    public LineaApuesta(EventoDeportivo evento, TipoPronostico tipo) {
        this.evento = evento;
        this.tipo = tipo;
        this.cuotaSeleccionada = obtenerCuota(evento, tipo);
    }

    // Método privado para determinar la cuota según el pronóstico
    private double obtenerCuota(EventoDeportivo evento, TipoPronostico tipo) {
        switch (tipo) {
            case LOCAL:
                return evento.getCuotaLocal();
            case EMPATE:
                return evento.getCuotaEmpate();
            case VISITANTE:
                return evento.getCuotaVisitante();
            default:
                return 0;
        }
    }

    // Getters
    public EventoDeportivo getEvento() {
        return evento;
    }

    public TipoPronostico getTipo() {
        return tipo;
    }

    public double getCuotaSeleccionada() {
        return cuotaSeleccionada;
    }
}