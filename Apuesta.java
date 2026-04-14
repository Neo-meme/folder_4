abstract class Apuesta implements CalculableGanancia {
    double monto;
    jugador jugador;
    
    public abstract double calcularGananciaPotencial(double monto);
}