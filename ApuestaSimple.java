
public class ApuestaSimple extends Apuesta {
    private LineaApuesta linea;

    // Constructor
    public ApuestaSimple(double monto, jugador jugador, LineaApuesta linea) {
        super(monto, jugador);
        this.linea = linea;
    }

    // Getter
    public LineaApuesta getLinea() {
        return linea;
    }

    // Implementación del método de la interfaz
    @Override
    public double calcularGananciaPotencial(double monto) {
        return monto * linea.getCuotaSeleccionada();
    }
}