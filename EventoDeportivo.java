public class EventoDeportivo {

    // Atributos
    private String codigo;
    private String descripcion;
    private double cuotaLocal;
    private double cuotaEmpate;
    private double cuotaVisitante;

    // Constructor
    public EventoDeportivo(String codigo, String descripcion,double cuotaLocal, double cuotaEmpate, double cuotaVisitante) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cuotaLocal = cuotaLocal;
        this.cuotaEmpate = cuotaEmpate;
        this.cuotaVisitante = cuotaVisitante;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCuotaLocal() {
        return cuotaLocal;
    }

    public double getCuotaEmpate() {
        return cuotaEmpate;
    }

    public double getCuotaVisitante() {
        return cuotaVisitante;
    }

    // Método útil para mostrar información
    public void mostrarInfo() {
        System.out.println("Evento: " + descripcion);
        System.out.println("Código: " + codigo);
        System.out.println("Cuotas:");
        System.out.println(" Local: " + cuotaLocal);
        System.out.println(" Empate: " + cuotaEmpate);
        System.out.println(" Visitante: " + cuotaVisitante);
    }
}
