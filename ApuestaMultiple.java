import java.util.List;
public class ApuestaMultiple extends Apuesta {

    // Atributo: varias líneas
    private List<LineaApuesta> lineas;

    // Constructor
    public ApuestaMultiple(double monto, jugador jugador, List<LineaApuesta> lineas) {
        super(monto, jugador);
        this.lineas = lineas;
    }

    // Getter
    public List<LineaApuesta> getLineas() {
        return lineas;
    }

    // Implementación del cálculo de ganancia
    @Override
    public double calcularGananciaPotencial(double monto) {

        double productoCuotas = 1;

        for (LineaApuesta linea : lineas) {
            productoCuotas *= linea.getCuotaSeleccionada();
        }

        return monto * productoCuotas;
    }
}