/**
 * Representa una línea dentro de un ticket de apuesta.
 * Relación: Asociación con EventoDeportivo
 */
public class LineaApuesta {

    // Atributos
    private EventoDeportivo evento;
    private TipoPronostico pronostico;
    private double cuotaSeleccionada;

    // Constructor
    public LineaApuesta(EventoDeportivo evento, TipoPronostico pronostico) {
        this.evento = evento;
        this.pronostico = pronostico;
        this.cuotaSeleccionada = obtenerCuota(evento, pronostico);
    }

    // Método privado para determinar la cuota según el pronóstico
    private double obtenerCuota(EventoDeportivo evento, TipoPronostico pronostico) {
        switch (pronostico) {
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

    public TipoPronostico getPronostico() {
        return pronostico;
    }

    public double getCuotaSeleccionada() {
        return cuotaSeleccionada;
    }
}