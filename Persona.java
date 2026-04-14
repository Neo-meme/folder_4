
public abstract class Persona {

    // Atributo
    protected String nombre;

    // Constructor
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    // Getter
    public String getNombre() {
        return nombre;
    }

    // Método abstracto (obliga a las clases hijas a implementarlo)
    public abstract String getIdentificador();
}