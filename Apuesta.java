
public abstract class Apuesta implements CalculableGanancia {

    // Atributos
    protected double monto;
    protected jugador jugador;

    // Constructor
    public Apuesta(double monto, jugador jugador) {
        this.monto = monto;
        this.jugador = jugador;
    }

    // Getters
    public double getMonto() {
        return monto;
    }

    public jugador getJugador() {
        return jugador;
    }

    // Método abstracto (obliga a las clases hijas a definir la lógica)
    @Override
    public abstract double calcularGananciaPotencial(double monto);
}